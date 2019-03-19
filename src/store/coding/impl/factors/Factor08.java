package store.coding.impl.factors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.interfaces.IFactor;

/**
 * 
 * º«ÎÄÆ´Òô£ºAC00-D7AF£»
 * º«ÎÄ×ÖÄ¸£º1100-11FF£»
 * º«ÎÄ¼æÈİ×ÖÄ¸£º3130-318F£»
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
