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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import com.dwarfeng.dwarffunction.cna.ArrayPackFunction;
import com.dwarfeng.dwarffunction.debugtool.CodeTimer;
import com.dwarfeng.dwarffunction.io.CT;
import com.dwarfeng.dwarffunction.numerical.NumberTransformer;

/**
 * ����̨�ࡣ
 * <p>����ı�����Ϊ���ƿ���̨�������滻����֮ǰ�汾�Ĳ����ƵĿ���̨��������֮ǰ�汾�Ŀ���̨�����Ƴ���
 * <br> ��εĿ���̨������������<code>System.in</code>����ˣ������ٵ���ʹ�ÿ���̨֮��ͻ�ʧȥԭ�е�ϵͳ�������
 * ����̨��Ȼ�ṩһ������������û������¶��������ʱ�����Խ��ṩ��������ض���<code>System.in</code>�ϡ�
 * <br> ����̨�ṩ���µ�������֤���������ı��ﵽһ���������������ı�������������ʱ������̨�ᰴ��һ���ı���ɾ��
 * ���������һ�����������Կ����������������ֵ��
 * ��ɾ�������������Ϊ�ܱ���ʾ�������������������ڹ������б�ָ����һ����ָ���Ͳ��ܸ��ġ�
 * 
 * @author DwArFeng
 * @since 1.8
 */
public class JConsole extends JPanel{
	
	public static void main(String[] args) throws IOException{
		JFrame jf = new JFrame();
		jf.getContentPane().setLayout(new BorderLayout());
		JConsole jc = new JConsole(6);
		jf.getContentPane().add(jc,BorderLayout.CENTER);
		jf.setSize(400, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		CodeTimer ct = new CodeTimer();
		
		System.setOut(jc.getOut());
		
		Thread t1,t2,t3;
		t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 200 ; i ++){
					CT.trace("t1---1000");
				}
			}
		});
		t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 200 ; i ++){
					CT.trace("t2---2000");
				}
			}
		});
		t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i < 200 ; i ++){
					CT.trace("t3---3000");
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		ct.start();
		while(t1.isAlive() || t2.isAlive() || t3.isAlive()){}
		ct.stopAndPrint();
		
	}
	
	//---��̬����
	private final static int DEFAULT_MAX_LINE = 3000;
	private final static int LINE_RATIO = 10;
	
	//---������йصı���
	private JTextArea textArea;
	
	//---��������
	private int maxLine = DEFAULT_MAX_LINE;
	private final Lock lock = new ReentrantLock();
	
	/**
	 * ����һ��Ĭ�ϵĿ���̨��
	 */
	public JConsole() {
		this(DEFAULT_MAX_LINE);
	}
	
	/**
	 * ����һ��ӵ����������Ŀ���̨.
	 */
	/**
	 *  ����һ��ӵ����������Ŀ���̨��
	 *  <p> ����̨���������Ϊ<code>maxLine</code>��1�����ֵ��
	 * @param maxLine ����������
	 */
	public JConsole(int maxLine){
		
		//��ʼ������
		this.maxLine = Math.max(maxLine, 1);
		
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
		
		private final ArrayList<Byte> listSource = new ArrayList<Byte>();
		private final List<Byte> byteList = Collections.synchronizedList(listSource);
		
		/*
		 * (non-Javadoc)
		 * @see java.io.OutputStream#flush()
		 */
		@Override
		public void flush(){
			String str = new String(ArrayPackFunction.unpack(byteList.toArray(new Byte[0])));
			if(textArea != null){
				append(str);
			}
			byteList.clear();
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
		return maxLine;
	}
	
	/**
	 * �����̨���������׷���ı���
	 * @param str ָ����׷���ı���
	 */
	private void append(String str){
		textArea.append(str);
		ensureMaxLine();
	}
	
	/**
	 * ȷ������С�
	 */
	private void ensureMaxLine(){
		int line = textArea.getLineCount();
		if(line >= this.maxLine){
			try{
				textArea.replaceRange(
						null, textArea.getLineStartOffset(0), 
						textArea.getLineEndOffset(line - maxLine + maxLine/LINE_RATIO)
				);
			}catch(BadLocationException e){
				//DO NOTHING
			}
		}
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
