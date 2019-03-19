package store.coding.impl.factors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.interfaces.IFactor;

/**
 * 
 * ×¢Òô·ûºÅ£º3100-312F£»
 * ×¢Òô·ûºÅ£¨ÃöÄÏÓï¡¢¿Í¼ÒÓïÀ©Õ¹£©£º31A0-31BF£»
 * @author Administrator
 *
 */
public class Factor05 implements IFactor {

	@Override
	public float doFactor(String str) {
		float factor = 0;
		float count = 0;
		Pattern p = Pattern.compile("([\u3100-\u312f])([\u31a0-\u31bf])");
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
