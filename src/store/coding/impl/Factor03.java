package store.coding.impl;

import store.coding.IMerryFactor;

/**
 * 中日韩文字占比
 * @author Administrator
 *
 */
public class Factor03 implements IMerryFactor {

	@Override
	public float doMerryFactor(String str) {
		float factor = 0;
	    float count = 0;
	    char[] ch = str.trim().toCharArray();
	    for (int i = 0; i < ch.length; i++) {
	        char c = ch[i];
            //判断是否是中日韩文
            if (isChinese(c)) {
            	count++;
            }
	    }
	    factor = count/ch.length;
	    return factor;
	}
	
	
	/**
	 * 判断是否是中日韩文字
	 * @param c     要判断的字符
	 * @return      true或false
	 */
	private static boolean isChinese(char c) {
	    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
	    if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
	            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
	            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
	            || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
	            || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
	            || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
	        return true;
	    }
	    return false;
	}


	/**
	 * 判断是否是数字或者是英文字母
	 * @param c
	 * @return
	 */
	public static boolean judge(char c){
	    if((c >='0' && c<='9')||(c >='a' && c<='z' ||  c >='A' && c<='Z')){
	        return true;
	    }
	    return false;
	}

}
