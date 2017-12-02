package com.dwarfeng.dutil.basic.gui.awt;

import com.dwarfeng.dutil.basic.num.NumberValue;

/**
 * 二维尺寸接口。
 * 
 * <p>
 * 该接口表示事物具有二维尺寸。
 * 
 * @author DwArFeng
 * @since 0.1.5-beta
 */
public interface Size2D {

	/**
	 * 返回对象的高度。
	 * 
	 * @return 对象的高度。
	 */
	public NumberValue getHeight();

	/**
	 * 返回对象的宽度。
	 * 
	 * @return 对象的宽度。
	 */
	public NumberValue getWidth();

	/**
	 * 返回对象高度的int形式。
	 * 
	 * @return 对象高度的int形式。
	 */
	public default int getIntHeight() {
		return getHeight().intValue();
	}

	/**
	 * 返回对象宽度的int形式。
	 * 
	 * @return 对象宽度的int形式。
	 */
	public default int getIntWidth() {
		return getWidth().intValue();
	}

	/**
	 * 返回对象高度的double形式。
	 * 
	 * @return 对象高度的double形式。
	 */
	public default double getDoubleHeight() {
		return getHeight().doubleValue();
	}

	/**
	 * 返回对象宽度的double形式。
	 * 
	 * @return 对象宽度的double形式。
	 */
	public default double getDoubleWidth() {
		return getWidth().doubleValue();
	}

}
