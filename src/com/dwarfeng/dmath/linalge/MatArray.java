package com.dwarfeng.dmath.linalge;

import com.dwarfeng.dmath.DMath;
import com.dwarfeng.dmath.algebra.NumBase;

/**
 * �������С�
 * <p> ��ʵ������Ա�����һ���������С�
 * <p>
 * @author DwArFeng
 * @since 1.8
 */
public interface MatArray extends DMath, NumBase{

	/**
	 * ���ظ����е�������
	 * @return �����е�������
	 */
	public int rows();
	
	/**
	 * ���ظ����е�������
	 * @return �����е�������
	 */
	public int ranks();
	
}
