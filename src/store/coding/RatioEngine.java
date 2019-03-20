package store.coding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import store.coding.interfaces.IRatio;
import store.coding.util.ClassUtils;

/**
 * 计算每个因素的系数
 * @author Administrator
 *
 */
public class RatioEngine {
	
	public static Map<String, Float> doCalculate(String str) {
		Map<String, Float> resultMap = new HashMap<String, Float>();
		Set<String> set = ClassUtils.getClassName("store.coding.impl.ratios", false);
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String path = (String) iterator.next();
			resultMap.put(path, ((IRatio) CodingFactory.getObj(path)).doRatio(str));
		}
	    return resultMap;
	}
}
