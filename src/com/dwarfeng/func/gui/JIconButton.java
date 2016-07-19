package com.dwarfeng.func.gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * ����һ������ָ��ͼ��������ְ�ť��ͼ��һ��ָ�����������š�
 * @author DwArFeng
 * @since 1.7
 */
public class JIconButton extends JButton {
	
	private static final long serialVersionUID = 1708306634638895381L;
	private Image image;
	
	/**
	 * ����һ������Ĭ��ͼ��null��ͼ��ť
	 */
	public JIconButton(){
		this(null);
	}
	/**
	 * ����һ������ָ��ͼ��İ�ť��
	 * @param image ָ����ͼ��
	 */
	public JIconButton(Image image){
		super("");
		this.setImage(image);
	}
	
	/**
	 * ���ذ�ť��ͼ��
	 * @return ��ť��ͼ��
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * ���ð�ť��ͼ��
	 * @param image ָ����ͼ��
	 */
	public void setImage(Image image) {
		this.image = image;
		if(this.image == null) this.setIcon(null);
		else this.setIcon(new ImageIcon(image));
	}
	@Override
	public void setText(String str){
		super.setText("");
	}

}
