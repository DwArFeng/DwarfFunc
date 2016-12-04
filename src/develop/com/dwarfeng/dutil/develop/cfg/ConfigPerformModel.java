package com.dwarfeng.dutil.develop.cfg;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.dwarfeng.dutil.basic.prog.ObverserSet;

/**
 * ���ñ���ģ�͡�
 * <p> ��ģ��ע�����ܣ���Ӧ�ٶȽϿ죬���ܹ�ע���Ա���Ϊ���Ĺ۲�����
 * <br> ��ģ������ɢ�ķ�ʽʵ�ֲ��� Map ���ܣ������䱾������ Map ��
 * <p> ����վ����������ӳ����ϵ�ĺ��ģ�����ӳ����ϵ�ڸýӿ��б�ʵ�֡�
 * <br> ���ñ���ģ�Ϳ��Է���ӳ����ϵ������ӳ�䣬������Щӳ�䲻�ɱ����ġ�
 * <p> ע�⣺���ñ���ģ�ͽ�ֹ null ���ü���������ͼʹ�� null ��Ϊ���ü��Ĵ���������Ϊ
 * ���ᵼ�� <code> NullPointException </code>��
 * @author DwArFeng
 * @since 1.8
 */
public interface ConfigPerformModel extends ConfigReflect, ObverserSet<ConfigPerformObverser>{
	
	/**
	 * ����վ�����Ƿ����ָ�������ü���
	 * <p> �����ڲ���Ϊ <code>null</code> �����᷵�� <code>false</code>��
	 * @param configKey ָ�������ü���
	 * @return �Ƿ������
	 */
	public boolean containsKey(ConfigKey configKey);
	
	/**
	 * ����ӳ���а���ӳ���ϵ��Set��ͼ��
	 * <p> ��Set��ͼ��ֻ���ģ�����Set�е������޸ķ��������׳� {@link UnsupportedOperationException}��
	 * @return ӳ���а���ӳ���ϵ��Set��ͼ��
	 */
	public Set<ConfigEntry> entrySet();
	
	/**
	 * ��ȡ���õļ����ϡ�
	 * <p> �ü����Ƿǿյģ����в����� <code>null</code>Ԫ�ء�
	 * <p> �ü�����ֻ���ģ���������������޸ķ������׳� {@link UnsupportedOperationException}��
	 * @return ���ü����ϡ�
	 */
	public Set<ConfigKey> keySet();
	
	/**
	 * ������ӳ�������һ��ӳ���ϵ����ѡ��������
	 * <p> �÷�������ͼ��ӳ�������ָ���Ĺ�ϵ����ӳ���ϵ����������������ʱ����ӳ���ϵ�ܹ����ɹ�����ӵ���ӳ���С�
	 * <pre>
	 * 1.  ��ӳ���ϵ�ļ���ֵ������ <code>null</code>�������ϸ���ֱ���׳� {@link NullPointerException}���������� <code>false</code>����
	 * 2.  ��ӳ���ϵ�ļ�ֵ��ӳ���в����ڡ�
	 * 3.  ��ӳ���ϵ��ֵ���������ԣ��У�Ĭ��ֵҪͨ������ֵ������ļ�⡣
	 * </pre>
	 * @param configKey ָ�������ü���
	 * @param configProperties ָ�����������ԡ�
	 * @return �ò����Ƿ�Ը�����ӳ������˸ı䡣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws UnsupportedOperationException ������ӳ�䲻֧�ִ˲�����
	 */
	public boolean add(ConfigEntry entry);
	
	/**
	 * �Ӹ�����ӳ�����Ƴ�ָ���ļ��������Ӧ���������ԣ���ѡ��������
	 * @param configKey ָ�������ü���
	 * @return �ò����ǶԸ�����ӳ������˸ı䡣
	 * @throws UnsupportedOperationException ������ӳ�䲻֧�ִβ�����
	 */
	public boolean remove(ConfigKey configKey);
	
	/**
	 * ����ָ�����ü��ĵ�ǰֵ��
	 * <p> ��������ñ���ģ�Ͳ�����ָ�������ü�����ôʲôҲ������
	 * @param key ָ�������ü���
	 * @param currentValue �µĵ�ǰֵ��
	 * @return �þٶ��Ƿ�����˶Թ۲�����֪ͨ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�� 
	 */
	public boolean set(ConfigKey configKey, String currentValue);
	
	/**
	 * �趨ָ����ǰֵӳ���е��������ü��ĵ�ǰֵ��
	 * <p> �÷��������ӳ���еļ�ֵ�����ĳ����ֵ�Ǹ����ñ���ģ���а����ģ���ô��������õ�ǰֵ������������
	 * @param currentValueMap ָ���ĵ�ǰֵӳ�䡣
	 * @return �þٶ��Ƿ�����һ�δ������Թ۲�����֪ͨ��
	 */
	public boolean setAll(Map<ConfigKey, String> currentValueMap);
	
	/**
	 *  ���ش�ӳ���а�����ֵ�� Collection ��ͼ��
	 *  <p> ��Collection ��ͼ���ɸ��ģ���������е��������޸ķ��������׳� {@link UnsupportedOperationException}��
	 * @return ��ӳ���а���ֵ�� Collection ��ͼ��
	 */
	public Collection<ConfigProperties> values();
	
}

