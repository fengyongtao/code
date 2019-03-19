package store.coding.impl;

import store.coding.IFactor;

/**
 * Ӣ�Ļ�����ռ��
 * @author Administrator
 *
 */
public class Factor06 implements IFactor {

	@Override
	public float doFactor(String str) {
		float factor = 0;
	    float count = 0;
	    char[] ch = str.trim().toCharArray();
	    for (int i = 0; i < ch.length; i++) {
	        char c = ch[i];
	        //�ж��Ƿ������ֻ���Ӣ���ַ�
	        if (judge(c)) {
	        	count++;
	        }
	    }
	    factor = count/ch.length;
	    return factor;
	}
	
	
	/**
	 * �ж��Ƿ������ֻ�����Ӣ����ĸ
	 * @param c
	 * @return
	 */
	public static boolean judge(char c){
	    if((c >='0' && c<='9')||(c >='a' && c<='z' ||  c >='A' && c<='Z')){
	        return true;
	    }
	    return false;
	}

}
