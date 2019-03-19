package store.coding.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.IMerryFactor;

/**
 * 空格、回车、换行符、制表符占比
 * @author Administrator
 *
 */
public class Factor02 implements IMerryFactor {

	@Override
	public float doMerryFactor(String str) {
		float factor = 0;
		float count = 0;
        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
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
