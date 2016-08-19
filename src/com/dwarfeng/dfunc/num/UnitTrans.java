package com.dwarfeng.dfunc.num;

import com.dwarfeng.dfunc.infs.Valueable;

/**
 * ��λ���㹤���ࡣ
 * <p> �ð��ṩ��λ������صķ�����
 * <br> ��ע�⣬���㷽�������漰�������㣬���Ȼ�������
 * <br> �ð������˲��ֳ��õĻ���ö�٣������ͱ������û��ڳ����ĵ�λ�����л���ʱ�䡣���� {@linkplain ANGLE}
 * <br> ��ע�⣬��Ȼ���㷽���У�<code>u1</code>��<code>u2</code>�����ò�ͬö���е�
 * �ֶΣ�����������û������ģ��벻Ҫ��������
 * @author DwArFeng
 * @since 1.8
 */
public final class UnitTrans {
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static Valueable trans(Valueable val, Valueable u1, Valueable u2){
		
		return new Valueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
			 */
			@Override
			public double doubleValue() {
				return (val.doubleValue())/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static Valueable trans(float val, Valueable u1, Valueable u2){
		
		return new Valueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
			 */
			@Override
			public double doubleValue() {
				return val/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static Valueable trans(double val, Valueable u1, Valueable u2){
		
		return new Valueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
			 */
			@Override
			public double doubleValue() {
				return val/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static Valueable trans(long val, Valueable u1, Valueable u2){
		
		return new Valueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
			 */
			@Override
			public double doubleValue() {
				return val/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static Valueable trans(short val, Valueable u1, Valueable u2){
		
		return new Valueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
			 */
			@Override
			public double doubleValue() {
				return val/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static Valueable trans(int val, Valueable u1, Valueable u2){
		
		return new Valueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
			 */
			@Override
			public double doubleValue() {
				return val/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * ��ָ����ֵ��һ����λת��Ϊ��һ����λ��
	 * @param val ��ת����ֵ��
	 * @param u1 ��ֵ�����е�λȨ�ء�
	 * @param u2 Ŀ�굥λ��Ȩ�ء�
	 * @return ��ֵ��Ŀ�굥λ�µ�ֵ��
	 */
	public static Valueable trans(byte val, Valueable u1, Valueable u2){
		
		return new Valueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
			 */
			@Override
			public double doubleValue() {
				return val/(u1.doubleValue())*(u2.doubleValue());
			}
		};
	}
	
	/**
	 * �Ƕ�ö�١�
	 * @author DwArFeng
	 * @since 1.8
	 */
	public enum ANGLE implements Valueable{
		
		/**�Ƕ�*/
		DEG(180),
		/**����*/
		RAD(Math.PI),
		/**�ٷֶ�*/
		GRAD(200);
		
		private final double val;
		
		private ANGLE(double val){
			this.val = val;
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
		 */
		@Override
		public double doubleValue() {
			return val;
		}
		
	}
	
	//���ܽ���ʵ����
	private UnitTrans() {}
}
