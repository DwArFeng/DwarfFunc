package com.dwarfeng.dfunc.gui.swing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import com.dwarfeng.dfunc.cna.ArrayUtil;
import com.dwarfeng.dfunc.comp.ToStringComparator;

/**
 * �ɱ��б����<p>
 * ���б�̳�JList������ʹ�����Ԫ����ɾ�Ĺ��ܡ��ɱ��б��ṩ�˲���ʱ���Զ������ܣ������û�����ָ���Ƿ��ڲ���Ԫ��ʱ�Զ�����
 * �Ͳ���Ԫ��֮���Ƿ��Զ�ѡ����ЩԪ�ء�<br>
 * ���б��в��������nullԪ�أ���ͼ���������nullԪ�ػᱻ���ˡ�
 * @author DwArFeng
 * @since 1.7
 * @param <T> �б��д�ŵ�Ԫ�����͡�
 */
public class JMutableList<T> extends JList<T> {
	
	/**ָʾԪ�ز���ʱ����<code>toString()</code>�����������������ģʽ*/
	public static final int INSERT_SORT = 2;
	/**Ԫ�ز���ʱʹ��Ĭ�Ϸ�������*/
	public static final int INSERT_DEFAULT = 1;
	/**
	 * Ԫ���Զ�ѡ��ģʽ��<p>
	 * ����Ԫ��ʱ�Զ�ѡ�в����Ԫ�أ����������Ԫ�ض�ֻ��ѡ��һ��Ԫ�صĻ���ѡ��ͷһ��Ԫ�ء�
	 * ���ѡ�е�Ԫ�ر�ɾ���ˣ���ѡ�е�һ��Ԫ�أ�����ɾ����Ԫ�����б��е�Ψһһ��Ԫ�ء�
	 */
	public static final int SELECT_AUTO = 4;
	/**Ԫ��Ĭ��ѡ��ģʽ*/
	public static final int SELECT_DEFAULT = 3;
	private static final long serialVersionUID = -4522424887882987143L;
	
	private DefaultListModel<T> model;
	private int insertMode;
	private int selectMode;
	
	public JMutableList() {
		this(null,INSERT_SORT,SELECT_AUTO);
	}
	public JMutableList(T[] objects){
		this(objects,INSERT_SORT,SELECT_AUTO);
	}
	public JMutableList(T[] objects,int insertMode,int selectMode){
		super();
		this.model = new DefaultListModel<T>();
		setModel(model);
		setInsertMode(insertMode);
		setSelectMode(selectMode);
		if(objects != null){addElement(objects);}
	}
	
	/**
	 * ���б��в���ָ����Ԫ�ء�
	 * @param t ָ����Ԫ�ء�
	 */
	public void addElement(T t){
		if(insert(t) && getSelectMode() == SELECT_AUTO){
			setSelectedValue(t, true);
		}
	}
	/**
	 * ���б��в���ָ����Ԫ�ء�
	 * @param objectes ָ����Ԫ�����顣
	 */
	public void addElement(T[] objectes){
		if(objectes == null) return;
		//�ɹ���ӵĶ���������
		Vector<T> vec = new Vector<T>();
		for(T t:objectes){
			//ֻ�в���ɹ�������ѡ��ģʽΪ�Զ�ѡ��ʱ������vec�����Ԫ��
			if(insert(t) && getSelectMode() == SELECT_AUTO){
				vec.add(t);
			}
		}
		//Vec����0��ʱ����Ҫά��ѡ����
		if(vec.size() > 0){
			if(getSelectionMode() == ListSelectionModel.SINGLE_SELECTION){
				setSelectedValue(vec.elementAt(0), true);
			}else{
				int[] indices = new int[vec.size()];
				for(int i = 0 ; i < indices.length ; i ++){ indices[i] = model.indexOf(vec.elementAt(i));}
				setSelectedIndices(indices);
			}
		}

	}
	/**
	 * ���б���ɾ��ָ��Ԫ�أ����ָ����Ԫ�����б��в����ڵĻ����򲻽����κβ�����
	 * @param object ָ����Ԫ�ء�
	 */
	public void removeElement(T object){
		if(object == null) return;
		T t = getSelectedValue();
		model.removeElement(object);
		if(getSelectionMode() == ListSelectionModel.SINGLE_SELECTION && 
				getSelectMode() == SELECT_AUTO &&t != null && object == t){setSelectedIndex(0);}
	}
	/**
	 * ���б���ɾ��ָ��Ԫ�ؼ��ϡ�
	 * @param objects ָ����Ԫ�ؼ��ϡ�
	 */
	public void removeElement(T[] objects){
		if(objects == null) return;
		T t = getSelectedValue();
		for(T tt:objects){model.removeElement(tt);}
		if(getSelectionMode() == ListSelectionModel.SINGLE_SELECTION &&
				getSelectMode() == SELECT_AUTO && t != null && ArrayUtil.contains(objects, t)){setSelectedIndex(0);}
	}
	/**
	 * ���б���ɾ������Ԫ�ء�
	 */
	public void removeAllElements(){
		model.removeAllElements();
	}
	/**
	 * ���ظÿɱ��б����Ĳ���ģʽ��
	 * @return ����ģʽ��
	 */
	public int getInsertMode() {
		return insertMode;
	}
	/**
	 * ���ò���ģʽ��<p>
	 * �������ģʽ����ΪINSERT_SORT,������ģʽ�����Ѿ����ڵ�Ԫ�ؽ���һ������
	 * @param insertMode ָ���Ĳ���ģʽ��
	 * @see JMutableList#INSERT_DEFAULT
	 * @see JMutableList#INSERT_SORT
	 */
	@SuppressWarnings("unchecked")
	public void setInsertMode(int insertMode) {
		if(insertMode != INSERT_DEFAULT && insertMode != INSERT_SORT) 
			throw new IllegalArgumentException("insertMode����ΪINSERT_SORT����INSERT_DEFAULT");
		this.insertMode = insertMode;
		//���Ҫ�Զ��������Ȱ��Ѿ����ڵ�Ԫ������
		if(insertMode == INSERT_SORT){
			Object[] os = model.toArray();
			Arrays.sort(os,new ToStringComparator<Object>());
			model.clear();
			for(int i = 0 ; i < os.length ; i++){model.addElement((T) os[i]);}
		}
	}
	/**
	 * ���ظÿɱ��б��ѡ��ģʽ��
	 * @return ѡ��ģʽ��
	 */
	public int getSelectMode() {
		return selectMode;
	}
	/**
	 * ���øÿɱ��б��ѡ��ģʽ��
	 * @param selectMode �ÿɱ��б��ѡ��ģʽ��
	 */
	public void setSelectMode(int selectMode) {
		if(selectMode != SELECT_AUTO && selectMode != SELECT_DEFAULT)
			throw new IllegalArgumentException("selectMode����ΪSELECT_AUTO����SELECT_DEFAULT");
		this.selectMode = selectMode;
	}
	private boolean insert(T object){
		if(object == null) return false;
		//ʹ�����򷨲���Ԫ��
		Comparator<T> cp = new ToStringComparator<T>();
		//һЩ������������modal��û��Ԫ��ʱ��ֱ�Ӳ�����0λ
		if(model.size() == 0) {
			model.insertElementAt(object, 0);
			return true;
		}
		//һЩ������������modal��ֻ��1��Ԫ��ʱ��ѡ�������0������1λ��
		if(model.size() == 1){
			if(cp.compare(object, model.elementAt(0)) == -1) model.insertElementAt(object, 0);
			else model.insertElementAt(object, 1);
			return true;
		}
		//һ����������ø�Ԫ�����һ��Ԫ�رȽϣ�����ȵ�һ��Ԫ��С��ֱ�ӷ��ڵ�һλ
		if(cp.compare(object, model.elementAt(0)) == -1){
			model.insertElementAt(object, 0);
			return true;
		}
		//Ѱ�Һ��ʵĲ���λ��
		for(int i = 0 ; i < model.size() ; i ++){
			if(cp.compare(object, model.elementAt(i-1)) >= 0 && cp.compare(object, model.elementAt(i)) == -1){
				model.insertElementAt(object, i);
				return true;
			}
		}
		//���������������ʺϣ��������Ԫ��������Ϊֹ����Ԫ��������Ԫ��֮һ��Ӧ�ò��������
		model.insertElementAt(object, model.size());
		return true;
	}
}
