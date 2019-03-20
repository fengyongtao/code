package store.coding;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Messy2NormalCode {

	/**
	 * 将传入的字符串进行转码（用于乱码问题）
	 * JAVA字符串编码转换不可逆，故存在数据丢失的情况
	 * @param str		
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static List<Object> encode(String str) throws UnsupportedEncodingException {
		String result = null;
		List<Object> resultList = new ArrayList<Object>();
		if (str != null && str.length() != 0) {
			for (Code c : Code.values()) {
				for (Code d : Code.values()) {
					if (c.getName() == d.getName()) {
						continue;
					}
					
					float tempRate = 0;
					result = new String(str.getBytes(c.getName()), d.getName());
					Map<String, Float> factorMap = FactorEngine.doCalculate(result);
					Map<String, Float> ratioMap = RatioEngine.doCalculate(result);
					for (Map.Entry<String, Float> entry: factorMap.entrySet()) {
						String key = entry.getKey().replace("Factor", "Ratio");
						key = key.replace("factors", "ratios");
						tempRate += (ratioMap.get(key) * entry.getValue());
					}
					Map<String, Object> resultMap = new HashMap<String, Object>();
//					//  乱码的长度一般多于正常的字符长度
//					if (str.length() >= result.length()) {
//						tempRate = (float) (tempRate + 0.1);
//					}
//					if (str.equals(result)) {
//						tempRate = (float) (tempRate - 0.1);
//					}
					resultMap.put("messyRate", tempRate);
					resultMap.put("beforeCode", c.getName());
					resultMap.put("afterCode", d.getName());
					resultMap.put("beforeStr", str);
					resultMap.put("afterStr", result);
					resultList.add(resultMap);
				}
			}
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "鏂囦贡鐮侀棶棰� ";
		float maxValue = 0;
		Map<String, Object> tempMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> resultList = encode(str);
		for (int i = 0; i < resultList.size(); i++) {
			tempMap = (Map<String, Object>) resultList.get(i);
			if (maxValue < (float) tempMap.get("messyRate")) {
				maxValue = (float) tempMap.get("messyRate");
				resultMap = tempMap;
			}
		}
		System.out.println("【最优方案】resultMap：" + resultMap);
	}
	
	
	
}