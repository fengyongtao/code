package store.coding;

public class FactorFactory {

	public static IFactor getFactor(Class<?> clazz) {
		IFactor factor = null;
		try {
			factor = (IFactor) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		return factor;
	}
	
}
