package com.dwarfeng.dfunc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.KeyStroke;

import com.dwarfeng.dfunc.infs.Buildable;

/**
 * �˵���Ŀ�����࣬�ø�����Կ��ٵĽ���һ������ָ�����ԵĲ˵���Ŀ��
 * <p> ���ڸ����Ѿ���ȫ�����<code>Action</code>���������ԣ���˸��಻�ܱ��̳С�
 * @author DwArFeng
 * @since 1.7
 */
public final class JMenuItemAction extends AbstractAction{

	private static final long serialVersionUID = 67574488277609694L;
	
	private ActionListener listener;
	
	/**
	 * �˵���Ŀ�����������ࡣ
	 * @author DwArFeng
	 * @since 1.8
	 */
	public static class Builder implements Buildable<JMenuItemAction>{
		
		private Icon icon = null;
		private String name = null;
		private String description = null;
		private KeyStroke keyStroke = null;
		private int mnemonic = 0;
		private ActionListener listener = null;
		
		/**
		 * �趨������ͼ�ꡣ
		 * @param val ������ͼ�ꡣ
		 * @return ����������
		 */
		public Builder icon(Icon val){
			this.icon = val;
			return this;
		}
		
		/**
		 * �趨���������ơ�
		 * @param val ���������ơ�
		 * @return ����������
		 */
		public Builder name(String val){
			this.name = val;
			return this;
		}
		
		/**
		 * �趨������������
		 * @param val ������������
		 * @return ����������
		 */
		public Builder description(String val){
			this.description = val;
			return this;
		}
		
		/**
		 * �趨��������ϼ���
		 * @param val �趨��������ϼ���
		 * @return ����������
		 */
		public Builder keyStorke(KeyStroke val){
			this.keyStroke = val;
			return this;
		}
		
		/**
		 * �趨���������Ƿ���
		 * @param val ���������Ƿ���
		 * @return ����������
		 */
		public Builder mnemonic(int val){
			this.mnemonic = val;
			return this;
		}
		
		/**
		 * �趨�����Ķ���������
		 * @param val �����Ķ���������
		 * @return ����������
		 */
		public Builder listener(ActionListener val){
			this.listener = val;
			return this;
		}
		
		/*
		 * (non-Javadoc)
		 * @see com.dwarfeng.dwarffunction.interfaces.Builder#build()
		 */
		@Override
		public JMenuItemAction build(){
			return new JMenuItemAction(icon, name, description, keyStroke, mnemonic, listener);
		}
	}
	
	private JMenuItemAction(Icon icon,String name,String description,KeyStroke keyStroke,int mnemonic,ActionListener listener ){
		if(listener != null) this.listener = listener;
		if(icon != null)putValue(SMALL_ICON,icon);
		if(name != null) putValue(NAME, name);
		if(description != null) putValue(SHORT_DESCRIPTION, description);
		if(keyStroke != null) putValue(ACCELERATOR_KEY,keyStroke);
		putValue(MNEMONIC_KEY, mnemonic);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(listener == null) return;
		listener.actionPerformed(e);
	}
}
