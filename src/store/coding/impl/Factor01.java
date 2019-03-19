package store.coding.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.IFactor;

public class Factor01 implements IFactor {

	@Override
	public float doFactor(String str) {
		float factor = 0;
		float count = 0;
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	    char[] ch = str.trim().toCharArray();
        for(int i = 0; i < ch.length; i++){
    		Matcher matcher = p.matcher(String.valueOf(ch[i]));
    		if(matcher.matches()){
    			count++;
    		}
        }
        factor = count/ch.length;
		return factor;
	}

}
