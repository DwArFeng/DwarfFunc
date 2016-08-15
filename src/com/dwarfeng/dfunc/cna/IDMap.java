package com.dwarfeng.dfunc.cna;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * ID��ӳ����ࡣ
 * <p>������Խ�һ��������Ψһ��һ��ID���������
 * ������<code>HashMap</code>�ķ�ʽʵ�֣�����װ���еķ�����
 * <p>��ӳ������ʵ��ע�Ṧ�ܣ���������ע��������ָ��ID�ţ���ID��ͨ�����������Զ����ɡ�Ҳ����ָ��ID�Ž���ע�ᣬ��ID��ͻʱ�����׳��쳣��
 * <br>ӳ����е�ID�Զ����ɷ�ʽ�����֣�һ���ǽ����ͣ�һ���������ͣ�
 * <br>�������͵�������ʽ�������ܵı�֤ID�������ԣ�һ��ӳ����е�ĳ��ӳ�䱻ɾ������ճ�����ID�ᱻ�Զ����䵽��һ��ע���С�����ע�᷽ʽ�ʺ�
 * ���ڶ������û��ʱ��Ҫ������֡�
 * <br>�������͵�������ʽ��֤ÿ��ע��ʱID�����ϸ������˳��������������ĳ��ӳ�䱻ɾ�������ID��Զ������ʹ�ã����ַ��䷽ʽͬʱ��֤�˿ռ��ʱ���Ψһ�ԡ�
 * @author DwArFeng
 * @since 1.8
 * @param <T> ����ķ��͡�
 * 
 */
public class IDMap<T> {
	
	/**
	 * ���Ա�ʾ
	 * @author DwArFeng
	 * @since 1.8
	 */
	public enum CodingType{
		/**��ʾ���뷽ʽΪ�����ͣ���ʱ�ı�������ѡ���ܹ�ʹ�õ���С���������б���*/
		COMPACT,
		/**��ʾ���뷽ʽΪ�����ͣ���ʱ�ı������ǵ����ģ�����ǰ���Ƿ��Ѿ���IdʧЧ*/
		INCREASE;
	}
	
	private Map<Integer, T> map;
	private CodingType codingType;
	
	/**
	 * ����һ��Ĭ�ϵģ�ʹ�����������ID��ӳ�����
	 */
	public IDMap(){
		this(CodingType.INCREASE);
	}
	
	/**
	 * ����һ������ָ��������ʽ��ID��ӳ�����
	 * @param codingType �������ʽ��
	 */
	public IDMap(CodingType codingType){
		//���ñ�ŷ�ʽ
		setCodingType(codingType);
		//��ʼ����Ա����
		this.map = new HashMap<Integer, T>();
	}
	
	/**
	 * ���ظ�IDӳ���ı�ŷ�ʽ��
	 * @return ��IDӳ���ı�ŷ�ʽ��
	 */
	public CodingType getNumberType(){return this.codingType;}
	
	/**
	 * ���ø�IDӳ���ı�ŷ�ʽ��
	 * @param codingType ���ı�ŷ�ʽ��
	 */
	public void setCodingType(CodingType codingType){
		this.codingType = codingType;
	}
	
	/**
	 * ����Idӳ������Ѿ�ע������е�Idֵ��<p>
	 * ��Щֵ������ķ�ʽ�������С�
	 * @return ����Id������ʽ������������顣
	 */
	public int[] getAllIDs(){
		Integer[] integers =  map.keySet().toArray(new Integer[0]);
		int[] is = new int[integers.length];
		for(int i = 0 ; i < is.length ; i++) is[i] = integers[i].intValue();
		Arrays.sort(is);
		return is;
	}
	
	/**
	 * ����ָ��idָʾ��Ԫ�ء�
	 * @param id ָ����id��
	 * @return ָ��idָ���Ԫ�أ����û�ж�Ӧ��Ԫ�أ��򷵻�null��
	 */
	public T get(int id){
		return map.get(new Integer(id));
	}
	
	/**
	 * ��ѯָ�������idֵ��
	 * @param t ָ���Ķ���
	 * @return ָ�������idֵ�����ָ������û�б�ע�ᣬ�򷵻ظ�����
	 */
	public int serach(T t){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		while(iterator.hasNext()){
			Integer id = iterator.next();
			if(map.get(id).equals(t)) return id.intValue();
		}
		return -1;
	}
	
	/**
	 * ���IDӳ�����ע��һ�����󣬲�������������idֵ��
	 * @param t ��Ҫע��Ķ���
	 * @return �ö����idֵ������ö���֮ǰ�Ѿ�ע�ᣬ�򷵻ظ�ֵ��
	 */
	public int regist(T t){
		if(serach(t) >= 0) return -1;
		int id = nextID();
		map.put(new Integer(id), t);
		return id;
	}
	
	/**
	 * ���IDӳ�������Ӿ���ָ��ID�Ķ���
	 * <p> �÷�������ͼ��IDӳ��������ָ����ID��һ�����ָ�ID�Ѿ���ռ�ã�����׳��쳣��
	 * @param id ָ����ID�š�
	 * @param t ��ID��������Ķ���
	 * @throws DuplicateIdException ��ID���Ѿ�����ʱ�׳����쳣��
	 */
	public void put(int id,T t) throws DuplicateIdException{
		if(map.containsKey(new Integer(id))) throw new DuplicateIdException(id);
		map.put(new Integer(id), t);
	}
	
	/**
	 * ��IDӳ�����ǿ��д��ָ����ӳ�䣬����IDӳ�����ָ����ID�Ѿ�����ӳ��ʱ�����������ƻ�ԭʼӳ���
	 * ǿ�ƽ����µ�ӳ�䡣
	 * @param id ָ����ID��
	 * @param t  ��ID������Ķ���
	 * @return �µ�ӳ���Ƿ��ƻ���ԭ�е�ӳ�䡣
	 */
	public boolean forcePut(int id,T t){
		boolean flag = map.containsKey(new Integer(id));
		map.put(new Integer(id), t);
		return flag;
	}
	
	/**
	 * �Ӹ�IDӳ�����ɾ��ָ��ID��Ӧ��Ԫ�ء�
	 * <p>���ָ����ID����ע���б��У��򲻽��в�����
	 * @param id ָ����ID��
	 * @return ��ɾ����Ԫ�أ����û�У��򷵻�<code>null</code>��
	 */
	public T remove(int id){
		return map.remove(new Integer(id));
	}
	
	/**
	 * ��ͼ�Ӹ�IDӳ������Ƴ�ָ��Ԫ�ء�
	 * <p>���Ԫ�ش��ڵĻ������Ƴ�Ԫ�أ������ظ�Ԫ����֮��Ӧ��ID�����򣬷���<code>-1</code>���Ҳ�ִ���κ��Ƴ�������
	 * @param t ָ����Ԫ�ء�
	 * @return Ԫ�ض�Ӧ��ID����������ڣ��򷵻ظ�ֵ��
	 */
	public int remove(T t){
		int id = serach(t);
		if(id >= 0) map.remove(new Integer(id));
		return id;
	}
	
	/**
	 * ��ȡ��ӳ��������е�ֵ��
	 * @return ��ӳ������е�ֵ��ɵļ��ϡ�
	 */
	public Collection<T> getValues(){
		return map.values();
	}
	
	private int nextID(){
		int[] ids = getAllIDs();
		//���û���κ�idע�ᣬ��ֱ�ӷ���0
		if(ids.length == 0) return 0;
		switch (codingType) {
		case COMPACT:
			//���id��������С��һ����0���򷵻���С������Ҫ��С���Ǹ���
			if(ids[0] > 0) return ids[0] - 1;
			for(int i = 0 ; i < ids.length -1 ; i++){
				if(ids[i+1] - ids[i] > 1) return ids[i] + 1;
			}
			//��������м����������������ȷ��ضϵ�������
			return ids[ids.length] + 1;
		default:
			//���������Ǹ�
			return ids[ids.length-1] + 1;
		}
	}
}
