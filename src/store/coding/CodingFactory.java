package store.coding;

import store.coding.interfaces.ICoding;

/**
 * 编码对象创建工厂
 * @author Administrator
 *
 */
public class CodingFactory {

	public static ICoding getObj(String classPath) {
		ICoding coding = null;
		try {
			coding = (ICoding) Class.forName(classPath).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return coding;
	}
	
}
