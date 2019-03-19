package store.coding.impl;

import store.coding.IFactor;

/**
 * �޷�ת����ַ�ռ��
 * @author Administrator
 *
 */
public class Factor05 implements IFactor {

	@Override
	public float doFactor(String str) {
		float count = 0;
		char[] ch = str.trim().toCharArray();
		for (int i = 0; i < ch.length; i++) {
			// ����Unicode������ĳ���ַ���ת��ʱ������ڸ��ַ�����û�ж�Ӧ�ı��룬��õ�0x3f�����ʺ��ַ�?��
			// �������ַ�����Unicode����ת��ʱ�����������������ڸ��ַ�����û�б�ʶ�κε��ַ�����õ��Ľ����0xfffd
			if (ch[i] == 0x3f) {
				// ��������
				count++;
			}
		}
		return count / ch.length;
	}

}
