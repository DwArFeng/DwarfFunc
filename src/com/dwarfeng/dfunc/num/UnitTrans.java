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
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
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
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
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
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
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
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
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
				return ((double)val)/(u1.doubleValue())*(u2.doubleValue());
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
	
	/**
	 * ʱ��ö�١�
	 * @author DwArFeng
	 * @since 1.8
	 */
	public enum Time implements Valueable{
		
		/**����*/
		NS(86400000000000d),
		/**΢��*/
		US(86400000000d),
		/**����*/
		MS(86400000d),
		/**��*/
		SEC(86400d),
		/**����*/
		MIN(1440d),
		/**Сʱ*/
		HOR(24d),
		/**��*/
		DAY(1d);

		private final double val;
		
		private Time(double val) {
			this.val = val;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
		 */
		@Override
		public double doubleValue() {
			return this.val;
		}

	}
	
	/**
	 * ����ö�١�
	 * @author DwArFeng
	 * @since 1.8
	 */
	public enum Weight implements Valueable{
		
		/**��*/
		T(1d),
		/**ǧ��*/
		KG(1000d),
		/**��*/
		G(1000000d),
		/**����*/
		MG(1000000000d),
		/**��˾*/
		OZ(35273.96194958d),
		/**��*/
		LB(2204.62262185d),
		/**����*/
		DR(564383.39119329d)
		;

		private final double val;
		
		private Weight(double val) {
			this.val = val;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dfunc.infs.Valueable#doubleValue()
		 */
		@Override
		public double doubleValue() {
			return this.val;
		}

	}
	
	//���ܽ���ʵ����
	private UnitTrans() {}
}
