package store.coding;

import store.coding.interfaces.ICoding;

/**
 * ������󴴽�����
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
