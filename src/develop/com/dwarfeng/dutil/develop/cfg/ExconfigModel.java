package com.dwarfeng.dutil.develop.cfg;

import java.util.Collection;
import java.util.Set;

import com.dwarfeng.dutil.basic.prog.ObverserSet;
import com.dwarfeng.dutil.develop.cfg.obv.ExconfigObverser;
import com.dwarfeng.dutil.develop.cfg.struct.ExconfigEntry;
import com.dwarfeng.dutil.develop.cfg.struct.ValueParser;

/**
 * Ex����ģ�͡�
 * <p>
 * ������ģ���� {@link ConfigModel} ��ȣ� �����˶�ָ�������ü���Ӧ��ֱֵ�ӽ�����֧�֡� ͬʱ�� ģ�͵���ڽ����ӵĺ���
 * 
 * @author DwArFeng
 * @since 0.1.0-beta
 */
public interface ExconfigModel extends CurrentValueContainer, ObverserSet<ExconfigObverser> {

	/**
	 * �������ģ���е����м�¼����ѡ��������
	 * 
	 * @throws UnsupportedOperationException
	 *             ���������ģ�Ͳ�֧�ִ˲�����
	 */
	public void clear();

	/**
	 * �����ģ�Ͱ���ָ�����ü����򷵻� <code>true</code>��
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @return ������ģ���Ƿ����ָ�������ü���
	 */
	public boolean containsKey(ConfigKey configKey);

	/**
	 * ���������ģ���в������κμ�¼���򷵻� <code>true</code>��
	 * 
	 * @return ������ģ�����Ƿ񲻰����κμ�¼��
	 */
	public boolean isEmpty();

	/**
	 * ���ذ�����ģ�����ü���<code>Set</code>��ͼ��
	 * <p>
	 * �� <code>Set</code>��ͼ��ģ��֧�֣�����ģ���������ĸ��ľ������ڴ���ͼ�з�Ӧ������
	 * ��<code>Set</code>��ͼ��ֻ���ģ�������༭�������׳� {@link UnsupportedOperationException}��
	 * 
	 * @return ������ģ�����ü���<code>Set</code>��ͼ��
	 */
	public Set<ConfigKey> keySet();

	/**
	 * ���ģ�������ָ����������ڣ���ѡ��������
	 * <p>
	 * ��ָ����������ڲ�Ϊ <code>null</code>��������е�����ֵ����Ϊ
	 * <code>null</code>����Ч���Ҹ���������е����ü��������ڸ�ģ��ʱ���ɽ�����Ӳ���; ���򲻽����κβ�����
	 * 
	 * @param exconfigEntry
	 *            ָ����������ڡ�
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException
	 *             �������ģ�Ͳ�֧�ָò�����
	 */
	public boolean add(ExconfigEntry exconfigEntry);

	/**
	 * ���ģ�������ָ����������ڣ���ѡ��������
	 * <p>
	 * ��ָ����������ڲ�Ϊ <code>null</code>��������е�����ֵ����Ϊ
	 * <code>null</code>����Ч�Ҹ���������е����ü��������ڸ�ģ��ʱ���ɽ�����Ӳ���; ���򲻽����κβ�����
	 * <p>
	 * �÷�������ͼ��� Collection �����е�������ڡ�
	 * 
	 * @param exconfigEntries
	 *            ָ����������� Collection ��
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException
	 *             �������ģ�Ͳ�֧�ָò�����
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean addAll(Collection<ExconfigEntry> exconfigEntries);

	/**
	 * �Ƴ���ģ����ָ�������ü�����ѡ��������
	 * <p>
	 * ���ָ�������ü�Ϊ <code>null</code>�����߲��ڸ�ģ���У��򲻽����κβ�����
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException
	 *             �������ģ�Ͳ�֧�ָò�����
	 */
	public boolean remove(ConfigKey configKey);

	/**
	 * �Ƴ���ģ���е����ü�����ѡ��������
	 * <p>
	 * �÷�������ͼ�Ƴ�ָ�����ü� Collection �е��������ü���
	 * <p>
	 * ���ָ�������ü���Ϊ <code>null</code>���Ҳ��ڸ�ģ���У�������Ƴ�������
	 * 
	 * @param configKeys
	 *            ָ�������ü� Collection ��
	 * @return �ò����Ƿ��ģ�Ͳ����˱䡣
	 * @throws UnsupportedOperationException
	 *             �������ģ�Ͳ�֧�ָò�����
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean removeAll(Collection<ConfigKey> configKeys);

	/**
	 * �������� collection ����ЩҲ������ָ�� collection ��Ԫ�أ���ѡ�������� ���仰˵���Ƴ��� collection
	 * ��δ������ָ�� collection �е�����Ԫ�ء�
	 * 
	 * @param configKeys
	 *            ���������ڴ� collection �е�Ԫ�ص� collection ��
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException
	 *             �������ģ�Ͳ�֧�ָò�����
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public boolean retainAll(Collection<ConfigKey> configKeys);

	/**
	 * ���ظ�ģ���еļ�¼�����õĸ�����
	 * 
	 * @return ��ģ���м�¼�����õĸ�����
	 */
	public int size();

	/**
	 * �ж�һ��ֵ���ڸ�ģ����˵�Ƿ�Ϸ���
	 * <p>
	 * ���ָ���ļ�Ϊ <code>null</code>�����߸�ģ���в�����ָ�������ü����򷵻� <code>false</code>�� <br>
	 * ���ָ���� value Ϊ <code>null</code>���򷵻� <code>false</code>��
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param value
	 *            ָ����ֵ��
	 * @return ָ����ֵ�Ƿ����ָ�������ü���
	 */
	public boolean isValueValid(ConfigKey configKey, String value);

	/**
	 * ��ȡһ�����ü��ĺϷ���ֵ��
	 * <p>
	 * ���ָ�������ü��ڸ�ģ���д��ڣ���鿴�����ü��ĵ�ǰֵ�Ƿ�Ϸ��� ����Ϸ����򷵻ص�ǰֵ��������Ϸ����򷵻�Ĭ��ֵ��
	 * <p>
	 * ���ָ�������ü��ڸ�ģ���в����ڣ��򷵻� <code>null</code>
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @return �����ü��ĺϷ���ֵ��
	 */
	public String getValidValue(ConfigKey configKey);

	/**
	 * ��ȡһ�����ü���Ӧ�Ĺ̶����ԡ�
	 * <p>
	 * ��������ü������ڻ���Ϊ <code>null</code>���򷵻� <code>null</code>��
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @return ָ�������ü���Ӧ�Ĺ̶����ԡ�
	 */
	public ConfigFirmProps getConfigFirmProps(ConfigKey configKey);

	/**
	 * ����ģ����ָ�����ü���Ӧ�Ĺ̶����ԣ���ѡ��������
	 * <p>
	 * ��ָ�������ü���Ϊ <code>null</code>���Ҵ����ڸ�����ģ����ʱ�����ɸ�����̶����ԡ� <br>
	 * ����������Ը��ģ���Ȼ���ü���Ӧ�ĵ�ǰֵ���ᷢ�����������������ֵ������ĸ��ģ���ֵ����Ч����Ȼ�п��ܷ����仯��
	 * <p>
	 * ��Ȼ����ģ����ӵ�и÷����������Ƽ�ʹ�ã���Ϊ�����ù̶����Ա����Ӧ���ǲ��ɱ�ġ�
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param configFirmProps
	 *            ָ�������ù̶����ԡ�
	 * @return �ò����Ƿ��ģ�Ͳ����˱����
	 * @throws UnsupportedOperationException
	 *             ���ģ�Ͳ�֧�ָò�����
	 */
	public boolean setConfigFirmProps(ConfigKey configKey, ConfigFirmProps configFirmProps);

	/**
	 * ��һ��ָ�������ü���Ӧ�ĵ�ǰֵ����ΪĬ��ֵ��
	 * <p>
	 * ���ָ�������ü������ڻ���Ϊ <code>null</code>���򲻽����κβ�����
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @return �÷����Ƿ��ģ�Ͳ����˱����
	 */
	public boolean resetCurrentValue(ConfigKey configKey);

	/**
	 * ��ģ���е��������ü���Ӧ�ĵ�ǰֵ����ΪĬ��ֵ��
	 * 
	 * @return �÷����Ƿ��ģ�Ͳ����˱����
	 */
	public boolean resetAllCurrentValue();

	/**
	 * ��ȡ����ģ���е�ֵ��������
	 * <p>
	 * �������ģ���в�����ָ�������ü�����������ü�Ϊ <code>null</code>���򷵻� <code>null</code>��
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @return ָ�������ü���Ӧ��ֵ��������
	 */
	public ValueParser getValueParser(ConfigKey configKey);

	/**
	 * ����ģ����ָ�����ü���ֵ����������ѡ��������
	 * <p>
	 * ��ָ�������ü�Ϊ <code>null</code>����ָ�������ü��������ڵ�ǰ��ģ��ʱ���������κβ����� <br>
	 * ��ָ���� valueParser Ϊ <code>null</code>ʱ���������κβ�����
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param valueParser
	 *            ָ����ֵ��������
	 * @return �ò����Ƿ��ģ������˸ı䡣
	 */
	public boolean setValueParser(ConfigKey configKey, ValueParser valueParser);

	/**
	 * ��ȡģ����ָ�����ü��Ķ�Ӧ����Чֵ�Ľ���ֵ��
	 * 
	 * @param configKey
	 *            ָ�����ü���
	 * @return ָ�������ü���Ӧ����Чֵ�Ľ���ֵ��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 */
	public Object getParsedValue(ConfigKey configKey);

	/**
	 * ��ȡģ����ָ�����ü��Ķ�Ӧ����Чֵ�Ľ���ֵ��
	 * <p>
	 * �ý���ֵ����ת��Ϊָ�������͡�
	 * 
	 * @param configKey
	 *            ָ�������ü���
	 * @param clas
	 *            ָ�������͡�
	 * @param <T>
	 *            ֵ��Ҫ��ת���ɵ����͡�
	 * @return ��ת����ָ�����͵�ָ�������ü���Ӧ����Чֵ�Ľ���ֵ��
	 * @throws NullPointerException
	 *             ��ڲ���Ϊ <code>null</code>��
	 * @throws ClassCastException
	 *             ����ת���쳣��
	 */
	public <T> T getParsedValue(ConfigKey configKey, Class<T> clas);

}
