package com.dwarfeng.dutil.develop.cfg.gui;

import java.util.Collection;
import java.util.List;

import com.dwarfeng.dutil.basic.prog.ObverserSet;
import com.dwarfeng.dutil.develop.cfg.ConfigEntry;
import com.dwarfeng.dutil.develop.cfg.ConfigKey;
import com.dwarfeng.dutil.develop.cfg.ConfigProperties;
import com.dwarfeng.dutil.develop.cfg.ConfigReflect;

/**
 * ������ͼģ�͡�
 * <p> ��ģ��ƫ����ͼ��������֪�ĵ���˳�򣬿���ע��������ͼ����������
 * <br> ��ģ������ɢ�ķ�ʽʵ�ֲ��� List ���ܣ������䱾������ List ��
 * @author  DwArFeng
 * @since 1.8
 */
public interface ConfigViewModel extends Iterable<ConfigEntry>, ConfigReflect, ObverserSet<ConfigViewObverser>{
	
	/**
	 * ��ģ����ָ��λ�õ�������ڡ�
	 * @param index ָ����λ�á�
	 * @return ָ��λ�ö�Ӧ��������ڡ�
	 * @throws IndexOutOfBoundsException λ��Խ�硣
	 */
	public ConfigEntry get(int index);
	
	/**
	 * ���ظ�ģ���еļ��б�
	 * <p> ���б��Ƿǿյģ����в����� <code>null</code>Ԫ�ء�
	 * <p> ���б���ֻ���ģ���������������޸ķ������׳� {@link UnsupportedOperationException}��
	 * @return �����б�
	 */
	public List<ConfigKey> keyList();
	
	/**
	 * ������ӳ���е�β�����һ��ӳ���ϵ����ѡ��������
	 * <p> �÷�������ͼ��ӳ�������ָ���Ĺ�ϵ����ӳ���ϵ����������������ʱ����ӳ���ϵ�ܹ����ɹ�����ӵ���ӳ���С�
	 * <pre>
	 * 1.  ��ӳ���ϵ�ļ���ֵ������ <code>null</code>�������ϸ���ֱ���׳� {@link NullPointerException}���������� <code>false</code>����
	 * 2.  ��ӳ���ϵ��ֵ���������ԣ��У�Ĭ��ֵҪͨ������ֵ������ļ�⡣
	 * </pre>
	 * @param configKey ָ�������ü���
	 * @param configProperties ָ�����������ԡ�
	 * @return �ò����Ƿ�Ը�����ӳ������˸ı䡣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws UnsupportedOperationException ������ӳ�䲻֧�ִ˲�����
	 * @throws IndexOutOfBoundsException λ��Խ�硣
	 */
	public boolean add(ConfigEntry entry);
	
	
	/**
	 * ������ӳ���е�ָ��λ�����һ��ӳ���ϵ����ѡ��������
	 * <p> �÷�������ͼ��ӳ�������ָ���Ĺ�ϵ����ӳ���ϵ����������������ʱ����ӳ���ϵ�ܹ����ɹ�����ӵ���ӳ���С�
	 * <pre>
	 * 1.  ��ӳ���ϵ�ļ���ֵ������ <code>null</code>�������ϸ���ֱ���׳� {@link NullPointerException}���������� <code>false</code>����
	 * 2.  ��ӳ���ϵ��ֵ���������ԣ��У�Ĭ��ֵҪͨ������ֵ������ļ�⡣
	 * </pre>
	 * @param index ָ����λ�á�
	 * @param configKey ָ�������ü���
	 * @param configProperties ָ�����������ԡ�
	 * @return �ò����Ƿ�Ը�����ӳ������˸ı䡣
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>��
	 * @throws UnsupportedOperationException ������ӳ�䲻֧�ִ˲�����
	 * @throws IndexOutOfBoundsException λ��Խ�硣
	 */
	public boolean add(int index, ConfigKey configKey, ConfigProperties configProperties);
	
	/**
	 * TODO ��ע��δ���ơ�
	 * @param entries
	 * @return
	 */
	public boolean addAll(Collection<ConfigEntry> entries);
	
	/**
	 * ����б����ָ����Ԫ�أ��򷵻� <code>true</code>��
	 * @param configKey ָ����Ԫ�ء�
	 * @return ����б����ָ����Ԫ�أ��򷵻� <code>true</code>��
	 */
	public boolean contains(ConfigKey configKey);
	
	/**
	 * ����б����ָ�� collection ������Ԫ�أ��򷵻� <code>true</code>��
	 * @param configKeys Ҫ���б��м��������Ե� collection 
	 * @return ����б����ָ�� collection ������Ԫ�أ��򷵻� <code>true</code>��
	 */
	public boolean containsAll(Collection<ConfigKey> c);
	
	/**
	 * �Ӹ�����ӳ�����Ƴ���һ�γ��ֵ�ָ���ļ��������Ӧ���������ԣ���ѡ��������
	 * @param configKey ָ�������ü���
	 * @return �ò����ǶԸ�����ӳ������˸ı䡣
	 * @throws UnsupportedOperationException ������ӳ�䲻֧�ִβ�����
	 */
	public boolean remove(ConfigKey configKey);
	
	/**
	 * �Ƴ�ָ��λ�õ��������ݡ�
	 * @param index ָ����λ�á�
	 * @return �ò����Ƿ�ı���ģ�͡�
	 * @throws IndexOutOfBoundsException λ��Խ�硣
	 */
	public boolean remove(int index);
	
	/**
	 * ����ָ�����ü��ĵ�ǰֵ��
	 * <p> ��������ñ���ģ�Ͳ�����ָ�������ü�����ôʲôҲ������
	 * @param key ָ�������ü���
	 * @param currentValue �µĵ�ǰֵ��
	 * @return �þٶ��Ƿ�����˶Թ۲�����֪ͨ��
	 * @throws NullPointerException ��ڲ���Ϊ <code>null</code>�� 
	 */
	public boolean set(ConfigKey configKey, String currentValue);
	
}
