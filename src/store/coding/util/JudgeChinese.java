package store.coding.util;

/**
 * 判断简体中文占比
 * @author Administrator
 *
 */
public class JudgeChinese {
	
	public static float IsSimple(String str) {
		float count = 0;
		String temp = null;
		for(int i = 0; i < str.length(); i++) {
			temp = str.substring(i, i + 1);
		    try {
		    	String afterStr = new String(temp.getBytes("GB2312"), "GB2312");
		        if (temp.equals(afterStr)) {
		        	count++;
		        }
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
		float result = count/str.length();
	    return result;
	}

}
