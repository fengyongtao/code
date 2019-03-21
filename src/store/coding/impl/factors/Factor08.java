package store.coding.impl.factors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.interfaces.IFactor;


/**
 * 
 * 韩文拼音：AC00-D7AF；
 * 韩文字母：1100-11FF；
 * 韩文兼容字母：3130-318F；
 * @author Administrator
 *
 */
public class Factor08 implements IFactor {

	@Override
	public float doFactor(String str) {
		float factor = 0;
		float count = 0;
        Pattern p = Pattern.compile("([\uAC00-\uD7AF])([\u1100-\u11FF])([\3130-\u318F])");
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
