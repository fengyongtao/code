package store.coding.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import store.coding.IMerryFactor;

/**
 * 拉丁文及其拓展：
 * C0控制符及基本拉丁文 (C0 Control and Basic Latin) 0080-00FF；
 * C1控制符及拉丁文补充-1 (C1 Control and Latin 1 Supplement) 0100-017F；
 * 拉丁文扩展-A (Latin Extended-A) 0180-024F；
 * 拉丁文扩展-B (Latin Extended-B) 0250-02AF；
 * @author Administrator
 *
 */
public class Factory07 implements IMerryFactor {

	@Override
	public float doMerryFactor(String str) {
		float factor = 0;
		float count = 0;
        Pattern p = Pattern.compile("[\u0080-\u02AF]");
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
