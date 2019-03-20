package store.coding.interfaces;

/**
 * 系数类接口（与因素类对应，每一个因素都会对应一个系数），所有的系数类都实现此接口
 * @author Administrator
 *
 */
public interface IRatio extends ICoding {

	public float doRatio(String str);
	
}
