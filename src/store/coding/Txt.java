package store.coding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Txt {

	public static List<String> readTxt(String path) {
		List<String> list = new ArrayList<String>();
		// 打开文件
		File file = new File(path);
		// 非目录的判断
		if (file.isDirectory()) {
			System.out.println("The File doesn't not exist.");
			return null;
		} 
		
		// 用流的方式按行读取文件
		InputStream instream = null;
		BufferedReader buffreader = null;
		try {
			instream = new FileInputStream(file);
			if (instream != null) {
				buffreader = new BufferedReader(new InputStreamReader(instream));
				String line;
				while ((line = buffreader.readLine()) != null) {
					list.add(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关流
			if (buffreader != null) {
				try {
					buffreader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (instream != null) {
				try {
					instream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
