package com.dwarfeng.dutil.detool.gui.swing;

import java.awt.BorderLayout;
import java.util.Objects;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * �����������
 * <p> �õ�������һ�����ڣ����Դ���ָ����������������û��Ϳ����ڳ�������ʾ��������棬�Ӷ���������е����ˡ�
 * <br> �ý�����������ʹ�õ��� {@link BorderLayout}�������Ե����ʼ�մ��ڽ�����м䡣
 * <p> �õ��������ڰ��¹رհ�ť�����򼴽�����
 * @author DwArFeng
 * @since 0.0.2-beta
 */
public class JComponentTester extends JFrame {

	private static final long serialVersionUID = 2757822629350396907L;

	/**����ı��⡣*/
	public static final String TITLE = "dutil.detool.gui.swing.JComponentTester";
	
	/**���������*/
	protected final JComponent component;
	
	/**�������*/
	private final JPanel contentPane = new JPanel();
	
	/**
	 * ����һ��Ĭ�ϵ������������
	 */
	public JComponentTester() {
		this(null);
	}
	
	/**
	 * ����һ������ָ������������������������
	 * @param component ָ�������������Ϊ <code>null</code>��
	 */
	public JComponentTester(JComponent component){
		if(Objects.nonNull(component)){
			this.component = component;
		}else{
			JLabel label = new JLabel(TITLE);
			label.setHorizontalAlignment(JLabel.CENTER);
			this.component = label;
		}
		init();
	}
	
	
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle(TITLE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(component, BorderLayout.CENTER);
	}

	/**
	 * ��ȡ�õ������еĴ����������
	 * @return �����������
	 */
	public JComponent getComponent() {
		return component;
	}

}
