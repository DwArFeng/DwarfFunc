package com.dwarfeng.dutil.develop.cfg;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.dwarfeng.dutil.basic.cna.ArrayUtil;

/**
 * Ĭ������ģ�͡�
 * @author  DwArFeng
 * @since 1.8
 */
public class DefaultConfigModel extends AbstractConfigModel {

	protected final Map<ConfigKey, String> currentValueMap = new HashMap<>();
	
	protected final Map<ConfigKey, ConfigFirmProps> firmPropsMap;
	
	/**
	 * ����һ����ָ��������Ŀ��ɵ�Ĭ������ģ�͡�
	 * @param configItems
	 */
	public DefaultConfigModel(ConfigItem[] configItems){
		this(ArrayUtil.array2Iterable(configItems));
	}
	
	/**
	 * 
	 * @param configItems
	 */
	public DefaultConfigModel(Iterable<ConfigItem> configItems) {
		//Map
	}
	
}
