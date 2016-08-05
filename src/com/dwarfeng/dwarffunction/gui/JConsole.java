package com.dwarfeng.dwarffunction.gui;

import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.dwarfeng.dwarffunction.str.CycledSlsBuffer;

/**
 * ����̨�ࡣ
 * <p>����ı�����Ϊ���ƿ���̨�������滻����֮ǰ�汾�Ĳ����ƵĿ���̨��������֮ǰ�汾�Ŀ���̨�����Ƴ���
 * <br> ��εĿ���̨������������<code>System.in</code>����ˣ������ٵ���ʹ�ÿ���̨֮��ͻ�ʧȥԭ�е�ϵͳ�������
 * ����̨��Ȼ�ṩһ������������û������¶��������ʱ�����Խ��ṩ��������ض���<code>System.in</code>�ϡ�
 * <br> �ÿ���̨������ʾһ���������ı��������ʾ�������Ѿ�������ָ������������ô�����������׷���µ��ı����ᵼ����ɵ��ı���
 * ��ɾ�������������Ϊ�ܱ���ʾ�������������������ڹ������б�ָ����һ����ָ���Ͳ��ܸ��ġ�
 * 
 * @author DwArFeng
 * @since 1.8
 */
public class JConsole extends JPanel{
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(new BorderLayout());
		JConsole jc = new JConsole();
		jf.add(jc,BorderLayout.CENTER);
		jf.setSize(400, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	//---��̬����
	private final static int BUFFER_CAPACITY = 3000;
	
	//---������йصı���
	private JTextArea textArea;
	private JAdjustableBorderPanel adjust;
	
	//---��������
	private final CycledSlsBuffer csb;
	private final ConsoleOutPutStream cops;
	
	
	public JConsole() {
		this(BUFFER_CAPACITY);
	}
	
	public JConsole(int maxLine){
		
		//��ʼ������
		this.csb = new CycledSlsBuffer(maxLine);
		
		//��ʼ������
		init();
	}
	
	public PrintStream getOut(){
		// TODO ������
		return null;
	}
	
	private final class ConsoleOutPutStream extends OutputStream{

		
		@Override
		public void write(int b) throws IOException {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private final OutputStream outputStream = new OutputStream() {
		
		/*
		 * (non-Javadoc)
		 * @see java.io.OutputStream#flush()
		 */
		@Override
		public void flush(){
			
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.io.OutputStream#write(int)
		 */
		@Override
		public void write(int b) throws IOException {
			// TODO Auto-generated method stub
			
		}
	};
	
	public InputStream getIn(){
		// TODO ������
		return null;
	}
	
	public Font getFont(){
		//TODO ������
		return null;
	}
	
	public void setFont(Font font){
		//TODO ������
	}
	
	/**
	 * ���ؿ���̨��ʾ�����������
	 * @return ����̨��ʾ�����������
	 */
	public int getMaxLine(){
		return this.csb.getCapacity();
	}
	
	private void append(String str){
		this.csb.append(str);
		textArea.setText(this.csb.toString());
	}
	
	
	/**
	 * �ṩ����ĳ�ʼ����
	 */
	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		adjust = new JAdjustableBorderPanel();
		adjust.setSeperatorThickness(5);
		adjust.setSouthEnabled(true);
		add(adjust);
		
		JTextField inputField = new JTextField();
		adjust.add(inputField, BorderLayout.SOUTH);
		inputField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		adjust.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

}
