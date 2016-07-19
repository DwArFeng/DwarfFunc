package com.dwarfeng.dwarffunction.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * ͼƬ�����࣬���ɵĽ��汻ָ����ͼƬ��䡣
 * @author ��Դ������
 * @since 1.7
 */
public class JImagePanel extends JPanel {	
	
	private static final long serialVersionUID = -7734848431940782655L;
	/**
	 * ����ͼƬ��
	 */
	private Image image = null;
	/**
	 * �Ƿ�����Ӧ��
	 */
	private boolean autoResize = false;	
	/**
	 * ����Ĭ�ϵ�ͼƬ����ʵ����û��ָ����ͼƬ����������Ӧ��
	 */
	public JImagePanel() {this(null, false);}
	/**
	 *����ͼƬ����ʵ����ָ���Ƿ�����Ӧ��
	 * @param autoResize �Ƿ�����Ӧ��
	 */
	public JImagePanel(boolean autoResize) {
		this(null, autoResize);
	}
	/**
	 * ���ɴ���ָ��ͼƬ��ͼƬ���档
	 * @param image ָ����ͼƬ��
	 */
	public JImagePanel(Image image) {this(image, false);}	
	/**
	 * ���ɾ���ָ��ͼƬ���Լ�ָ���Ƿ��������Ӧ��ͼƬ���档
	 * @param image ָ����ͼƬ��
	 * @param autoResize �Ƿ�����Ӧ��
	 */
	public JImagePanel(Image image, boolean autoResize) {
		super();
		this.autoResize = autoResize;
		this.image = image;
		repaint();
	}	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			if (autoResize) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			} else {
				g.drawImage(image, 0, 0, null);	}
		}
	}
	/**
	 * ���ر���ͼƬ��
	 * @return ����ͼƬ��
	 */
	public Image getImage() {return image;}
	/**
	 * ���ñ���ͼƬΪָ����ͼƬ��
	 * @param image ָ����ͼƬ��
	 */
	public void setImage(Image image) {
		this.image = image;
		repaint();
	}
	/**
	 * ����ͼƬ�Ƿ�����Ӧ��
	 * @return �Ƿ�����Ӧ��
	 */
	public boolean isAutoResize() {return autoResize;}
	/**
	 * ����ͼƬ�Ƿ�����Ӧ��
	 * @param autoResize �Ƿ�����Ӧ��
	 */
	public void setAutoResize(boolean autoResize) {
		this.autoResize = autoResize;
		repaint();
	}
}
