package store.coding.impl.factors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.interfaces.IFactor;

/**
 * 
 * 中文竖排标点：FE10-FE1F
 * @author Administrator
 *
 */
public class Factor12 implements IFactor {

	@Override
	public float doFactor(String str) {
		float factor = 0;
		float count = 0;
        Pattern p = Pattern.compile("[\ufe10-\ufe1f]");
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
