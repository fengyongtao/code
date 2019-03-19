package store.coding.impl.factors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.interfaces.IFactor;

/**
 * 
 * CJK部首补充：2E80-2EFF；
 * CJK标点符号：3000-303F；
 * CJK笔划：31C0-31EF；
 * CJK字母及月份：3200-32FF；
 * CJK特殊符号（日期合并）：3300-33FF；
 * CJK兼容符号（竖排变体、下划线、顿号）：FE30-FE4F；
 * 装饰符号（非CJK专用）：2700-27BF；
 * 杂项符号（非CJK专用）：2600-26FF；
 * @author Administrator
 *
 */
public class Factor03 implements IFactor {

	@Override
	public float doFactor(String str) {
		float factor = 0;
		float count = 0;
        Pattern p = Pattern.compile("([\u2e80-\u2eff])([\u3000-\u303f])([\u31c0-\u31ef])([\u3200-\u32ff])([\u3300-\u33ff])([\ufe30-\ufe4f])([\u2700-\u27bf])([\u2600-\u26ff])");
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
