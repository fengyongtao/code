package store.coding.impl.factors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.interfaces.IFactor;

/**
 * 
 * ¿µÎõ²¿Ê×£º2F00-2FDF£»
 * ºº×Ö½á¹¹ÃèÊö×Ö·û£º2FF0-2FFF£»
 * @author Administrator
 *
 */
public class Factor04 implements IFactor{

	@Override
	public float doFactor(String str) {
		float factor = 0;
		float count = 0;
        Pattern p = Pattern.compile("([\u2f00-\u2fdf])([\u2ff0-\u2fff])");
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
