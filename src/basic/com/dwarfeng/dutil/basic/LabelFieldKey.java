package com.dwarfeng.dutil.basic;

/**
 * 这个工具包使用的标签文本字段。
 * <p> 与 {@link StringFieldKey} 不同的是，标签文本字段是有可能需要经常切换语言的。
 * <p> 此枚举是对内使用的，它的主要作用是返回程序中所需要的标签文本字段。
 * <br> 请不要在外部程序中调用此包的枚举，因为该包主要是对内使用，其本身不保证兼容性。
 * <p> <b>注意：</b> 该包在设计的时候不考虑兼容性，当发生不向上兼容的改动时，作者没有义务在变更日志中说明。
 * @author  DwArFeng
 * @since 1.8
 */
public enum LabelFieldKey {
	
	/**ConfigTablePanel类第0号文本字段*/
	ConfigTablePanel_0,
	/**ConfigTablePanel类第1号文本字段*/
	ConfigTablePanel_1,
	/**ConfigTablePanel类第2号文本字段*/
	ConfigTablePanel_2,

}
