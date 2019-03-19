package store.coding;

import store.coding.impl.Factor01;
import store.coding.impl.Factor02;
import store.coding.impl.Factor03;
import store.coding.impl.Factor04;
import store.coding.impl.Factor05;
import store.coding.impl.Factory06;
import store.coding.impl.Factory07;
import store.coding.impl.Factory08;
import store.coding.impl.Factory09;

public class CodeUtil {

	public static float isMessyCode(String str) {
		
		float init = (float) 0.5;
		
		// 中文（包括简体和繁体）占比
		IMerryFactor factor1 = new Factor01();
		float molecular1 = factor1.doMerryFactor(str);
		
		// 空格、回车、换行符、制表符占比
		IMerryFactor factor2 = new Factor02();
		float molecular2 = factor2.doMerryFactor(str);
		
		// 中日韩文字占比
		IMerryFactor factor3 = new Factor03();
		float molecular3 = factor3.doMerryFactor(str);
		
		// 特殊字符占比
		IMerryFactor factor4 = new Factor04();
		float molecular4 = factor4.doMerryFactor(str);
		
		// 无法转义的字符占比
		IMerryFactor factor5 = new Factor05();
		float molecular5 = factor5.doMerryFactor(str);
		
		// 英文字母或数字占比
		IMerryFactor factor6 = new Factory06();
		float molecular6 = factor6.doMerryFactor(str);
		
		// 拉丁文占比
		IMerryFactor factor7 = new Factory07();
		float molecular7 = factor7.doMerryFactor(str);
		
		// 中文偏旁部首及拓展占比
		IMerryFactor factor8 = new Factory08();
		float molecular8 = factor8.doMerryFactor(str);
		
		// 中英文标点符号占比
		IMerryFactor factor9 = new Factory09();
		float molecular9 = factor9.doMerryFactor(str);
		
		float result = (float) (init + molecular1*0.2 - molecular2*0.2 + molecular3*0.2 - molecular4*0.2 - molecular5*0.1 - molecular6*0.1 - molecular7*0.5 - molecular8*0.5 - molecular9*0.1);
	    return result;
	}

	public static void main(String[] args) {
		String str = "春眠不觉晓，处处闻啼鸟";
		System.out.println(isMessyCode(str));
	}
}
