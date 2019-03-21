package store.coding.interfaces;

/**
 * 因素类接口，所有影响因素类全部实现此接口
 * @author Administrator
 *
 */
public interface IFactor extends ICoding {
	
	public float doFactor(String str);
	
}
