package com.dwarfeng.dwarffunction.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.dwarfeng.dwarffunction.cna.ArrayPackFunction;
import com.dwarfeng.dwarffunction.io.CT;
import com.dwarfeng.dwarffunction.numerical.NumberTransformer;
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
	
	public static void main(String[] args) throws IOException{
		JFrame jf = new JFrame();
		jf.getContentPane().setLayout(new BorderLayout());
		JConsole jc = new JConsole();
		jf.getContentPane().add(jc,BorderLayout.CENTER);
		jf.setSize(400, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		System.setOut(jc.getOut());
		long l = -  System.currentTimeMillis();
		for(int i = 0 ; i < 100 ; i ++){
			CT.trace("GUI ����̨");
		}
		l += System.currentTimeMillis();
		CT.trace(l);
		
	}
	
	//---��̬����
	private final static int BUFFER_CAPACITY = 3000;
	
	//---������йصı���
	private JTextArea textArea;
	
	//---��������
	private final CycledSlsBuffer csb;
	
	
	public JConsole() {
		this(BUFFER_CAPACITY);
	}
	
	public JConsole(int maxLine){
		
		//��ʼ������
		this.csb = new CycledSlsBuffer(maxLine);
		
		//��ʼ������
		init();
	}
	
	/**
	 * ��ȡ�ÿ���̨���������
	 * @return �ÿ���̨���������
	 */
	public PrintStream getOut(){
		return printStream;
	}
	private final OutputStream outputStream = 
	/*
	 * ����������ࡣ
	 * �������������̨�������������������������д�����ݻ�ı����̨����ʾ���ݡ�
	 */
	new OutputStream() {
		
		
		private final CycledSlsBuffer csb = new CycledSlsBuffer(BUFFER_CAPACITY);
		private final ArrayList<Byte> listSource = new ArrayList<Byte>();
		private final List<Byte> byteList = Collections.synchronizedList(listSource);
		
		/*
		 * (non-Javadoc)
		 * @see java.io.OutputStream#flush()
		 */
		@Override
		public void flush(){
			String str = new String(ArrayPackFunction.unpack(byteList.toArray(new Byte[0])));
			int lastIndex = str.lastIndexOf("\n");
			if(lastIndex == -1){
				textArea.setText(csb.toString() + str);
			}else{
				byteList.clear();
				String str0 = str.substring(0, lastIndex);
				String str1 = "";
				if(lastIndex < str.length() - 1){
					str1 = str.substring(lastIndex + 1, str.length());
				}
				csb.add(str0);
				textArea.setText(csb.toString() + str1);
				byte[] bs = str1.getBytes();
				for(byte b : bs){
					byteList.add(b);
				}
			}
			textArea.setCaretPosition(textArea.getText().length());
			//������б��ͷŶ���Ŀռ䡣
			synchronized (listSource) {
				listSource.trimToSize();
			}
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.io.OutputStream#write(int)
		 */
		@Override
		public void write(int b) throws IOException {
			byteList.add(NumberTransformer.cutInt2Byte(b));
		}
	};
	private final PrintStream printStream = new PrintStream(outputStream,true);
	
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
		this.csb.add(str);
		textArea.setText(this.csb.toString());
	}
	
	
	/**
	 * �ṩ����ĳ�ʼ����
	 */
	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		JTextField inputField = new JTextField();
		add(inputField, BorderLayout.SOUTH);
		inputField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}

}
