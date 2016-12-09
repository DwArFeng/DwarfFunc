package com.dwarfeng.dutil.develop.cfg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

import com.dwarfeng.dutil.basic.DwarfUtil;
import com.dwarfeng.dutil.basic.StringFieldKey;
import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.develop.cfg.gui.ConfigViewModel;
import com.dwarfeng.dutil.develop.cfg.gui.ConfigViewObverser;

/**
 * ���ù��߰���
 * @author DwArFeng
 * @since 1.8
 */
public final class ConfigUtil {

	/**
	 * �������ñ���ģ�͡�
	 * <p> ���ɵ����ñ���ģ�͵����ü���Ĭ��ֵ��ֵ����������������ָ������ǰֵΪĬ��ֵ��
	 * <p> Ϊ�˷���ĳЩ������˳��Ĺ��ܣ�������վ�ķ��������з��ؿɵ�������ķ����ĵ���˳�����<code>entries</code>�ĵ���˳��һ�¡�
	 * @param entries ���е�������ڡ�
	 * @return ���ñ���ģ�͡�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ��������к��в��Ϸ�Ԫ�ء�
	 */
	public static MapConfigModel newConfigPerformModel(Iterable<ConfigElements> entries){
		Objects.requireNonNull(entries, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_0));
		checkValid(entries);
		return new InnerConfigPerformModel(entries);
	}
	
	/**
	 * �������ñ���ģ�͡�
	 * <p> ���ɵ����ñ���ģ�͵����ü���Ĭ��ֵ��ֵ����������������ָ������ǰֵΪĬ��ֵ��
	 * <p> Ϊ�˷���ĳЩ������˳��Ĺ��ܣ�������վ�ķ��������з��ؿɵ�������ķ����ĵ���˳�����<code>entries</code>��˳��һ�¡�
	 * @param entries ���е�������ڡ�
	 * @return ���ñ���ģ�͡�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ��������к��в��Ϸ�Ԫ�ء�
	 */
	public static MapConfigModel newConfigPerformModel(ConfigElements[] entries){
		Objects.requireNonNull(entries, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_0));
		return newConfigPerformModel(ArrayUtil.array2Iterable(entries));
	}
	
	private static final class InnerConfigPerformModel implements MapConfigModel{
		
		private final Set<ConfigPerformObverser> obversers = Collections.newSetFromMap(new WeakHashMap<>());
		private final Map<ConfigKey, ConfigProperties> map;
		
		public InnerConfigPerformModel(Iterable<ConfigElements> entries) {
			map = new HashMap<>();
			for(ConfigElements entry : entries){
				ConfigKey configKey = entry.getConfigKey();
				String defaultValue = entry.getDefaultValue();
				ConfigChecker checker = entry.getConfigChecker();
				map.put(configKey, new ConfigProperties(defaultValue, defaultValue, checker));
			}
		}
		
	}
	
	
	
	/**
	 * �������ñ���ģ�͡�
	 * <p> ���ɵ����ñ���ģ�͵����ü���Ĭ��ֵ��ֵ����������������ָ������ǰֵΪĬ��ֵ��
	 * <p> Ϊ�˷���ĳЩ������˳��Ĺ��ܣ�������վ�ķ��������з��ؿɵ�������ķ����ĵ���˳�����<code>entries</code>�ĵ���˳��һ�¡�
	 * @param entries ���е�������ڡ�
	 * @return ���ñ���ģ�͡�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ��������к��в��Ϸ�Ԫ�ء�
	 */
	public static ConfigViewModel newConfigViewModel(Iterable<ConfigElements> entries){
		Objects.requireNonNull(entries, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_0));
		checkValid(entries);
		return new InnerConfigViewModel(entries);
	}
	
	/**
	 * �������ñ���ģ�͡�
	 * <p> ���ɵ����ñ���ģ�͵����ü���Ĭ��ֵ��ֵ����������������ָ������ǰֵΪĬ��ֵ��
	 * <p> Ϊ�˷���ĳЩ������˳��Ĺ��ܣ�������վ�ķ��������з��ؿɵ�������ķ����ĵ���˳�����<code>entries</code>��˳��һ�¡�
	 * @param entries ���е�������ڡ�
	 * @return ���ñ���ģ�͡�
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws IllegalArgumentException ��������к��в��Ϸ�Ԫ�ء�
	 */
	public static ConfigViewModel newConfigViewModell(ConfigElements[] entries){
		Objects.requireNonNull(entries, DwarfUtil.getStringField(StringFieldKey.ConfigUtil_0));
		return newConfigViewModel(ArrayUtil.array2Iterable(entries));
	}
	
	private static final class InnerConfigViewModel implements ConfigViewModel {
		
		private final Set<ConfigViewObverser> obversers = Collections.newSetFromMap(new WeakHashMap<>());
		private final List<ConfigKey> ckList;
		private final List<ConfigProperties> cpList;

		public InnerConfigViewModel(Iterable<ConfigElements> entries) {
			this.ckList = new ArrayList<>();
			this.cpList = new ArrayList<>();
			for(ConfigElements entry : entries){
				ConfigKey configKey = entry.getConfigKey();
				String defaultValue = entry.getDefaultValue();
				ConfigChecker checker = entry.getConfigChecker();
				ckList.add(configKey);
				cpList.add(new ConfigProperties(defaultValue, defaultValue, checker));
			}
		}

	}
	
	

	
	
	private static void checkValid(Iterable<ConfigElements> entries){
		for(ConfigElements entry : entries){
			if(
					Objects.isNull(entry.getConfigKey()) || 
					Objects.isNull(entry.getConfigChecker()) ||
					entry.getConfigChecker().nonValid(entry.getDefaultValue())
			)
				throw new IllegalArgumentException(DwarfUtil.getStringField(StringFieldKey.ConfigUtil_1));
		}
	}
	
}
