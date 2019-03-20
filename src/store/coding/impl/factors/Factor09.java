package store.coding.impl.factors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.interfaces.IFactor;


/**
 * 
 * 太玄经符号：1D300-1D35F；
 * 易经六十四卦象：4DC0-4DFF；
 * @author Administrator
 *
 */
public class Factor09 implements IFactor {

	@Override
	public float doFactor(String str) {
		float factor = 0;
		float count = 0;
        Pattern p = Pattern.compile("([\u1D300-\u1D35F])([\u4DC0-\u4DFF])");
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
