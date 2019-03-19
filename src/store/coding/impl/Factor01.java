package store.coding.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.IMerryFactor;

public class Factor01 implements IMerryFactor {

	@Override
	public float doMerryFactor(String str) {
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
