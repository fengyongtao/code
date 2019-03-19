package store.coding.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.IFactor;

/**
 * 所有中英文标点占比
 * @author Administrator
 *
 */
public class Factor09 implements IFactor {

	@Override
	public float doFactor(String str) {
		float factor = 0;
		float count = 0;
        Pattern p = Pattern.compile("[\\p{P}*]");
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
