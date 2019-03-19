package store.coding;

import store.coding.interfaces.IFactor;

/**
 * 因素对象创建工厂
 * @author Administrator
 *
 */
public class FactorFactory {

	public static IFactor getFactor(String classPath) {
		IFactor factor = null;
		try {
			factor = (IFactor) Class.forName(classPath).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return factor;
	}
	
}
