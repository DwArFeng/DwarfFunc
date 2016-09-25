package com.dwarfeng.dfunc.num;

import com.dwarfeng.dfunc.infs.MusValueable;

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
	public static MusValueable trans(MusValueable val, MusValueable u1, MusValueable u2){
		
		return new MusValueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
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
	public static MusValueable trans(float val, MusValueable u1, MusValueable u2){
		
		return new MusValueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
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
	public static MusValueable trans(double val, MusValueable u1, MusValueable u2){
		
		return new MusValueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
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
	public static MusValueable trans(long val, MusValueable u1, MusValueable u2){
		
		return new MusValueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
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
	public static MusValueable trans(short val, MusValueable u1, MusValueable u2){
		
		return new MusValueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
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
	public static MusValueable trans(int val, MusValueable u1, MusValueable u2){
		
		return new MusValueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
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
	public static MusValueable trans(byte val, MusValueable u1, MusValueable u2){
		
		return new MusValueable() {
			/*
			 * (non-Javadoc)
			 * @see com.dwarfeng.dmath.algebra.Valable#value()
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
	public enum ANGLE implements MusValueable{
		
		/**�Ƕ�*/
		DEG(180),
		/**����*/
		RAD(Math.PI),
		/**�ٷֶ�*/
		GRAD(200),
		/**��*/
		MIN(10800),
		/**��*/
		SEC(648000),
		;
		
		
		private final double val;
		
		private ANGLE(double val){
			this.val = val;
		}

		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dmath.algebra.Valable#value()
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
	public enum Time implements MusValueable{
		
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
		 * @see com.dwarfeng.dmath.algebra.Valable#value()
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
	public enum Weight implements MusValueable{
		
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
		 * @see com.dwarfeng.dmath.algebra.Valable#value()
		 */
		@Override
		public double doubleValue() {
			return this.val;
		}

	}
	
	/**
	 * ���ݴ�Сö�١�
	 * @author DwArFeng
	 * @since 1.8
	 */
	public enum DataSize implements MusValueable{
		
		/**EB*/
		EB(1d),
		/**PB*/
		PB(1024d),
		/**TB*/
		TB(1048576d),
		/**GB*/
		GB(1073741824d),
		/**MB*/
		MB(1099511627776d),
		/**KB*/
		KB(1125899906842624d),
		/**BYTE*/
		BYTE(1152921504606846976d),
		/**BITS*/
		BITS(9223372036854775808d)
		;
		
		private final double val;
		
		private DataSize(double val) {
			this.val = val;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dmath.algebra.Valable#value()
		 */
		@Override
		public double doubleValue() {
			return this.val;
		}
	}
	//���ܽ���ʵ����
	private UnitTrans() {}
}
