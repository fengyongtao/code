package store.coding.impl.ratios;

import java.io.UnsupportedEncodingException;

import store.coding.interfaces.IRatio;

public class Ratio01 implements IRatio {

	@Override
	public float doRatio(String str) {
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
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String temp = "✎﹏₯㎕﹍﹍ ζั͡ޓއއއ๓º\r\n";
		String afterStr = new String(temp.getBytes("GB2312"), "GB2312");
		System.out.println(afterStr);
	}

}
