package store.coding.impl;

import java.util.List;

import store.coding.IMerryFactor;
import store.coding.Txt;

/**
 * ÌØÊâ×Ö·ûÕ¼±È
 * @author Administrator
 *
 */
public class Factor04 implements IMerryFactor{

	@Override
	public float doMerryFactor(String str) {
		List<String> specialList = Txt
				.readTxt("E:\\PROJECT\\wetools\\workspace\\wetools\\src\\store\\coding\\specialsign.txt");

		String unicodeStr = stringToUnicode(str);
		float count = 0;
		for (int i = 0; i < specialList.size(); i++) {
			int index = 0;
			String special = specialList.get(i);
			while ((index = unicodeStr.indexOf(special.toLowerCase())) != -1) {
				unicodeStr = unicodeStr.substring(index + special.length());
				count++;
			}
		}

		char[] ch = str.trim().toCharArray();
		float result = count / ch.length;

		return result;

	}
	
	
	public static String stringToUnicode(String str) {
		StringBuffer sb = new StringBuffer();
		char[] c = str.trim().toCharArray();
		for (int i = 0; i < c.length; i++) {
			sb.append("\\u" + Integer.toHexString(c[i]));
		}
		return sb.toString();
	}

	
}
