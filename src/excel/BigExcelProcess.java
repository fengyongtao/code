package excel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 大数据Excel文件处理 使用xssf_sax_API处理Excel, 参考：
 * http://poi.apache.org/spreadsheet/how-to.html#xssf_sax_api
 * 
 * @author FengYongTao
 *
 */
public class BigExcelProcess {
	
	private static String key = "";
	private static Map<String, String> map = null;
	private static List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	
	public static void processFirstSheet(String filePath) throws Exception {
		try (OPCPackage pkg = OPCPackage.open(filePath, PackageAccess.READ)) {
			XSSFReader r = new XSSFReader(pkg);
			SharedStringsTable sst = r.getSharedStringsTable();

			XMLReader parser = fetchSheetParser(sst);

			// process the first sheet
			try (InputStream sheet = r.getSheetsData().next()) {
				InputSource sheetSource = new InputSource(sheet);
				parser.parse(sheetSource);
			}
		}
	}

	public static List<Map<String, String>> processAllSheets(String filePath) throws Exception {
		OPCPackage pkg = OPCPackage.open(filePath, PackageAccess.READ);
		XSSFReader r = new XSSFReader(pkg);
		SharedStringsTable sst = r.getSharedStringsTable();

		XMLReader parser = fetchSheetParser(sst);

		SheetIterator sheets = (SheetIterator) r.getSheetsData();
		while (sheets.hasNext()) {
			// 每个sheet页使用一个map
			map = new HashMap<String, String>();
			InputStream sheet = sheets.next();
			// 设置sheet名称
			map.put("sheetName", sheets.getSheetName());
			InputSource sheetSource = new InputSource(sheet);
			parser.parse(sheetSource);
			list.add(map);
		}
		return list;
	}

	private static XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException, ParserConfigurationException {
		XMLReader parser = SAXHelper.newXMLReader();
		ContentHandler handler = new SheetHandler(sst);
		parser.setContentHandler(handler);
		return parser;
	}

	private static class SheetHandler extends DefaultHandler {
		private final SharedStringsTable sst;
		private String lastContents;
		private boolean nextIsString;
		private boolean inlineStr;
		private final LruCache<Integer, String> lruCache = new LruCache<>(50);

		private static class LruCache<A, B> extends LinkedHashMap<A, B> {
			private static final long serialVersionUID = 1L;
			private final int maxEntries;

			public LruCache(final int maxEntries) {
				super(maxEntries + 1, 1.0f, true);
				this.maxEntries = maxEntries;
			}

			@Override
			protected boolean removeEldestEntry(final Map.Entry<A, B> eldest) {
				return super.size() > maxEntries;
			}
		}

		private SheetHandler(SharedStringsTable sst) {
			this.sst = sst;
		}

		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
			// c => cell
			if (name.equals("c")) {
				// 组装key值，遇到多个单元格合并的情况，此时的key值等于刀哥单元格key值的拼接，比如A1A2A3
				key += attributes.getValue("r");
				// Figure out if the value is an index in the SST
				String cellType = attributes.getValue("t");
				nextIsString = cellType != null && cellType.equals("s");
				inlineStr = cellType != null && cellType.equals("inlineStr");
			}
			// Clear contents cache
			lastContents = "";
		}

		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			// Process the last contents as required.
			// Do now, as characters() may be called more than once
			if (nextIsString) {
				Integer idx = Integer.valueOf(lastContents);
				lastContents = lruCache.get(idx);
				if (lastContents == null && !lruCache.containsKey(idx)) {
					lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
					lruCache.put(idx, lastContents);
				}
				nextIsString = false;
			}

			// v => contents of a cell
			// Output after we've seen the string contents
			// 每轮训一个单元格（合并的单元格算为多个），先执行startElement，然后执行endElement
			// 只有单元格有其对应的value值时，才会进入到if中（和并的单元格只有其最后一个单元格有值）
			if (name.equals("v") || (inlineStr && name.equals("c"))) {
				map.put(key, lastContents);
				// 因startElement中key是加等的关系，所以key需要每次进入if执行后在此处清空
				key = "";
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException { // NOSONAR
			lastContents += new String(ch, start, length);
		}
	}

}
