package store.coding.impl;

import store.coding.IFactor;

/**
 * 无法转义的字符占比
 * @author Administrator
 *
 */
public class Factor05 implements IFactor {

	@Override
	public float doFactor(String str) {
		float count = 0;
		char[] ch = str.trim().toCharArray();
		for (int i = 0; i < ch.length; i++) {
			// 当从Unicode编码向某个字符集转换时，如果在该字符集中没有对应的编码，则得到0x3f（即问号字符?）
			// 从其他字符集向Unicode编码转换时，如果这个二进制数在该字符集中没有标识任何的字符，则得到的结果是0xfffd
			if (ch[i] == 0x3f) {
				// 存在乱码
				count++;
			}
		}
		return count / ch.length;
	}

}
