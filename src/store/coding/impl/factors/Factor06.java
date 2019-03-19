package store.coding.impl.factors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.interfaces.IFactor;

/**
 *
 * 日文平假名：3040-309F；
 * 日文片假名：30A0-30FF；
 * 日文片假名拼音扩展：31F0-31FF；
 * @author Administrator
 *
 */
public class Factor06 implements IFactor {

	@Override
	public float doFactor(String str) {
		float factor = 0;
		float count = 0;
		Pattern p = Pattern.compile("[\u2f00-\u2fdf]");
	    char[] ch = str.toCharArray();
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