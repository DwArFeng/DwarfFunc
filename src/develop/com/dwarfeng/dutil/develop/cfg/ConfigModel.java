package com.dwarfeng.dutil.develop.cfg;

import java.util.Collection;
import java.util.Set;

import com.dwarfeng.dutil.basic.prog.ObverserSet;

/**
 * ����ģ�͡�
 * 
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigModel extends ObverserSet<ConfigObverser>{
	
	/**
	 * �������ģ���е����м�¼����ѡ��������
	 * @throws UnsupportedOperationException ���������ģ�Ͳ�֧�ִ˲�����
	 */
	public void clear();
	
	/**
	 * �����ģ�Ͱ���ָ�����ü����򷵻� <code>true</code>��
	 * @param configKey ָ�������ü���
	 * @return ������ģ���Ƿ����ָ�������ü���
	 */
	public boolean containsKey(ConfigKey configKey);
	
	/**
	 * ��ȡ����ģ���еĵ�ǰֵ��
	 * <p> ��ǰֵ���ܺϷ���Ҳ���ܲ��Ϸ��������Ҫ���һ������ģ����ָ�����ü��ĺϷ�ֵ����ʹ�� {@link #getValidValue(ConfigKey)}��
	 * <p> �������ģ���в�����ָ�������ü�����������ü�Ϊ <code>null</code>���򷵻� <code>null</code>��
	 * @param configKey ָ�������ü���
	 * @return ģ����ָ�����ü���Ӧ�ĵ�ǰֵ��
	 */
	public String getCurrentValue(ConfigKey configKey);
	
	/**
	 * ���������ģ���в������κμ�¼���򷵻� <code>true</code>��
	 * @return ������ģ�����Ƿ񲻰����κμ�¼��
	 */
	public boolean isEmpty();
	
	/**
	 * ���ذ�����ģ�����ü���<code>Set</code>��ͼ��
	 * <p> �� <code>Set</code>��ͼ��ģ��֧�֣�����ģ���������ĸ��ľ������ڴ���ͼ�з�Ӧ������
	 * ��<code>Set</code>��ͼ��ֻ���ģ�������༭�������׳� {@link UnsupportedOperationException}��
	 * @return ������ģ�����ü���<code>Set</code>��ͼ��
	 */
	public Set<ConfigKey> configKeySet();
	
	/**
	 * ���ģ�������ָ����������Ŀ����ѡ��������
	 * <p> ��ָ����������Ŀ��Ϊ <code>null</code>�Ҹ�������Ŀ�е����ü��������ڸ�ģ��ʱ���ɽ�����Ӳ���;
	 * ���򲻽����κβ�����
	 * @param configItem ָ����������Ŀ��
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException �������ģ�Ͳ�֧�ָò�����
	 */
	public boolean add(ConfigItem configItem);
	
	/**
	 * ���ģ�������ָ����������Ŀ����ѡ��������
	 * <p> ��ָ����������Ŀ��Ϊ <code>null</code>�Ҹ�������Ŀ�е����ü��������ڸ�ģ��ʱ���ɽ�����Ӳ���;
	 * ���򲻽����κβ�����
	 * <p> �÷�������ͼ��� Collection �����е�������Ŀ��
	 * @param configItems ָ����������Ŀ Collection ��
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException �������ģ�Ͳ�֧�ָò�����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean addAll(Collection<ConfigItem> configItems);
	
	/**
	 * �Ƴ���ģ����ָ�������ü�����ѡ��������
	 * <p> ���ָ�������ü�Ϊ <code>null</code>�����߲��ڸ�ģ���У��򲻽����κβ�����
	 * @param configKey ָ�������ü���
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException �������ģ�Ͳ�֧�ָò�����
	 */
	public boolean remove(ConfigKey configKey);
	
	/**
	 * �Ƴ���ģ���е����ü�����ѡ��������
	 * <p> �÷�������ͼ�Ƴ�ָ�����ü� Collection �е��������ü���
	 * <p> ���ָ�������ü���Ϊ <code>null</code>���Ҳ��ڸ�ģ���У�������Ƴ�������
	 * @param configKeys ָ�������ü� Collection ��
	 * @return �ò����Ƿ��ģ�Ͳ����˱䡣
	 * @throws UnsupportedOperationException �������ģ�Ͳ�֧�ָò�����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean removeAll(Collection<ConfigKey> configKeys);
	
	/**
	 * �������� collection ����ЩҲ������ָ�� collection ��Ԫ�أ���ѡ��������
	 * ���仰˵���Ƴ��� collection ��δ������ָ�� collection �е�����Ԫ�ء� 
	 * @param configKeys ���������ڴ� collection �е�Ԫ�ص� collection ��
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException �������ģ�Ͳ�֧�ָò�����
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean retainAll(Collection<ConfigKey> configKeys);
	
	/**
	 * ���ظ�ģ���еļ�¼�����õĸ�����
	 * @return ��ģ���м�¼�����õĸ�����
	 */
	public int size();
	
	/**
	 * �ж�һ��ֵ���ڸ�ģ����˵�Ƿ�Ϸ���
	 * <p> ���ָ���ļ�Ϊ <code>null</code>������
	 * @param configKey ָ�������ü���
	 * @param value ָ����ֵ��
	 * @return ָ����ֵ�Ƿ����ָ�������ü���
	 */
	public boolean isValueValid(ConfigKey configKey, String value);
	
	/**
	 * ��ȡһ�����ü��ĺϷ���ֵ��
	 * <p> ���ָ�������ü��ڸ�ģ���д��ڣ���鿴�����ü��ĵ�ǰֵ�Ƿ�Ϸ���
	 * ����Ϸ����򷵻ص�ǰֵ��������Ϸ����򷵻�Ĭ��ֵ��
	 * <p> ���ָ�������ü��ڸ�ģ���в����ڣ��򷵻� <code>null</code>
	 * @param configKey ָ�������ü���
	 * @return �����ü��ĺϷ���ֵ��
	 */
	public String getValidValue(ConfigKey configKey);
	
	/**
	 * ��ȡһ�����ü���Ӧ�Ĺ̶����ԡ�
	 * <p> ��������ü������ڻ���Ϊ <code>null</code>���򷵻� <code>null</code>��
	 * @param configKey ָ�������ü���
	 * @return ָ�������ü���Ӧ�Ĺ̶����ԡ�
	 */
	public ConfigFirmProps getConfigFirmProps(ConfigKey configKey);
	
	/**
	 * ����ģ����ָ�����ü���Ӧ�Ĺ̶����ԣ���ѡ��������
	 * <p> ��ָ�������ü���Ϊ <code>null</code>���Ҵ����ڸ�����ģ����ʱ�����ɸ�����̶����ԡ�
	 * <br> ����������Ը��ģ���Ȼ���ü���Ӧ�ĵ�ǰֵ���ᷢ�����������������ֵ������ĸ��ģ���ֵ����Ч����Ȼ�п��ܷ����仯��
	 * <p> ��Ȼ����ģ����ӵ�и÷����������Ƽ�ʹ�ã���Ϊ�����ù̶����Ա����Ӧ���ǲ��ɱ�ġ�
	 * @param configKey ָ�������ü���
	 * @param configFirmProps ָ�������ù̶����ԡ�
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException ���ģ�Ͳ�֧�ָò�����
	 */
	public ConfigFirmProps setConfigFirmProps(ConfigKey configKey, ConfigFirmProps configFirmProps);
	
	/**
	 * ��һ��ָ�������ü���Ӧ�ĵ�ǰֵ����ΪĬ��ֵ��
	 * <p> ���ָ�������ü������ڻ���Ϊ <code>null</code>���򲻽����κβ�����
	 * @param configKey ָ�������ü���
	 * @return �÷����Ƿ�ı��˸�����ģ�͵Ľṹ��
	 */
	public boolean resetValue(ConfigKey configKey);
	
}
