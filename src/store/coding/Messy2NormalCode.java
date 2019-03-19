package store.coding;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
			float messyRate = 1L;
			for (Code c : Code.values()) {
				for (Code d : Code.values()) {
					if (c.getName() == d.getName()) {
						continue;
					}
					result = new String(str.getBytes(c.getName()), d.getName());
					float tempRate = CodeUtil.isMessyCode(result);
					Map<String, Object> resultMap = new HashMap<String, Object>();
					//  乱码的长度一般多于正常的字符长度
					if (str.length() >= result.length()) {
						tempRate = (float) (tempRate + 0.1);
					}
					if (str.equals(result)) {
						tempRate = (float) (tempRate - 0.1);
					}
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
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		float maxValue = 0;
		
		
		// String str = "锘挎槬鐪犱笉瑙夋檽锛屽澶勯椈鍟奸";
		String str = "浼氭浛鎹㈡垚鍘熸枃浠跺悕,閰嶇疆杩欓」闇�瑕佹敞鎰忎腑鏂囦贡鐮侀棶棰� ";
		List<Object> resultList = encode(str);
		for (Iterator<Object> iterator = resultList.iterator(); iterator.hasNext();) {
			resultMap = (Map<String, Object>) iterator.next();
			System.out.println("【" + resultMap.get("messyRate") + "】" + "【" + resultMap.get("afterStr") + "】");
			if (maxValue < (float) resultMap.get("messyRate")) {
				maxValue = (float) resultMap.get("messyRate");
				System.out.println("【最终结果】" + resultMap);
			}
		}
		
		
		
		
	}
	
	
	
}