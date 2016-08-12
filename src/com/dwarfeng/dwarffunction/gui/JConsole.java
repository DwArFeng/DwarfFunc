package com.dwarfeng.dwarffunction.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;
import javax.swing.text.BadLocationException;

import com.dwarfeng.dwarffunction.cna.ArrayPackFunction;
import com.dwarfeng.dwarffunction.debugtool.CodeTimer;
import com.dwarfeng.dwarffunction.gui.event.ConsoleInputEventListener;
import com.dwarfeng.dwarffunction.gui.event.EventListenerWeakSet;
import com.dwarfeng.dwarffunction.gui.event.ConsoleInputEvent;
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
	
	public static void main(String[] args) throws Exception{
//		JFrame jf = new JFrame();
//		jf.getContentPane().setLayout(new BorderLayout());
//		JConsole jc = new JConsole();
//		jf.getContentPane().add(jc,BorderLayout.CENTER);
//		jf.setSize(400, 300);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setVisible(true);
//		
//		jc.susFlag = true;
//		
//		System.setOut(jc.getOut());
//		System.setIn(jc.getIn());
//		
//		Scanner scanner = new Scanner(System.in);
//		CT.trace(scanner.nextLine());
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				JFrame jf = new JFrame();
				jf.getContentPane().setLayout(new BorderLayout());
				JConsole jc = new JConsole();
				jf.getContentPane().add(jc,BorderLayout.CENTER);
				jf.setSize(400, 300);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setVisible(true);
				
				jc.susFlag = true;
				
				System.setOut(jc.getOut());
				System.setIn(jc.getIn());
				
				Scanner scanner = new Scanner(System.in);
				CT.trace(scanner.nextLine());
			}
		};
		EventQueue.invokeLater(runnable);
	}
	
	//---��̬����
	private final static int DEFAULT_MAX_LINE = 3000;
	private final static int LINE_RATIO = 10;
	
	//---������йصı���
	private JTextArea textArea;
	private JTextField inputField;
	
	//---�¼�����
	private EventListenerWeakSet eSet = new EventListenerWeakSet();
	
	//---ͬ�����߳�
	private final Lock outLock = new ReentrantLock();
	private final Lock inLock = new ReentrantLock();
	private final Condition inCondition = inLock.newCondition();
	
	//---��������
	private boolean susFlag = false;
	private int maxLine = DEFAULT_MAX_LINE;
	private String inputString = null;
	private byte[] bytesForString;
	private int mark = 0;
	private int lastMark = 0;
	
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
		
		private final ArrayList<Byte> byteList = new ArrayList<Byte>();
		
		/*
		 * (non-Javadoc)
		 * @see java.io.OutputStream#flush()
		 */
		@Override
		public void flush(){
			outLock.lock();
			try{
				String str = new String(ArrayPackFunction.unpack(byteList.toArray(new Byte[0])));
				if(textArea != null){
					append(str);
				}
				byteList.clear();
				//������б��ͷŶ���Ŀռ䡣
				byteList.trimToSize();
			}finally{
				outLock.unlock();
			}
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.io.OutputStream#write(int)
		 */
		@Override
		public void write(int b) throws IOException {
			outLock.lock();
			try{
				byteList.add(NumberTransformer.cutInt2Byte(b));
			}finally{
				outLock.unlock();
			}
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
			if(line >= maxLine){
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
	};
	private final PrintStream printStream = new PrintStream(outputStream,true);
	
	public InputStream getIn(){
		return this.inputStream;
	}
	private final InputStream inputStream = new InputStream() {
		
		/*
		 * (non-Javadoc)
		 * @see java.io.InputStream#markSupported()
		 * ��������֧��mark/reset
		 */
		@Override
		public boolean markSupported(){
			return true;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.io.InputStream#mark(int)
		 */
		@Override
		public synchronized void mark(int readlimit) {
			int max = bytesForString == null ? 0 : bytesForString.length;
			int min = 0;
			readlimit = Math.max(min, readlimit);
			readlimit = Math.min(max, readlimit);
			lastMark = readlimit;
			mark = readlimit;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.io.InputStream#reset()
		 * �˴���reset������Զ�����׳��쳣��
		 */
		@Override
	    public synchronized void reset() throws IOException {
			mark = lastMark;
	    }
		
		/*
		 * (non-Javadoc)
		 * @see java.io.InputStream#available()
		 */
	    @Override
		public int available() throws IOException {
	        return bytesForString == null ? 0 : Math.max(0, bytesForString.length - mark);
	    }
		
		/*
		 * (non-Javadoc)
		 * @see java.io.InputStream#read()
		 */
		@Override
		public int read() throws IOException {
			inLock.lock();
			try{
				while(susFlag && available() == 0){
					try {
						inCondition.await();
					} catch (InterruptedException e) {}
				}
				susFlag = false;
				if(available() == 0) return -1;
				return bytesForString[mark++];
			}finally{
				inLock.unlock();
			}
		}
	};
	
	/**
	 * ��øÿ���̨��������塣
	 * @return ��õ����塣
	 */
	public Font getConsoleFont(){
		return this.textArea.getFont();
	}
	
	/**
	 * ���øÿ���̨��������塣
	 * @param font ָ�������塣
	 */
	public void setConsoleFont(Font font){
		this.textArea.setFont(font);
		this.inputField.setFont(font);
		this.repaint();
	}
	
	/**
	 * ���ؿ���̨��ʾ�����������
	 * @return ����̨��ʾ�����������
	 */
	public int getMaxLine(){
		return maxLine;
	}
	
	/**
	 * �ṩ����ĳ�ʼ����
	 */
	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		inputField = new JTextField();
		inputField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					inLock.lock();
					try{
						inputString = inputField.getText() + "\n";
						bytesForString = inputString.getBytes();
						mark = 0;
						lastMark = 0;
						inCondition.signalAll();
						ConsoleInputEvent event = new ConsoleInputEvent(this, inputString, getIn());
						fireConsoleInputEvent(event);
						inputField.setText("");
					}finally{
						inLock.unlock();
					}
				}
			}
		});
		
		add(inputField, BorderLayout.SOUTH);
		inputField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
	
	protected void fireConsoleInputEvent(ConsoleInputEvent event) {
		for(ConsoleInputEventListener listener : eSet.subSet(ConsoleInputEventListener.class)){
			listener.onConsoleInput(event);
		}
	}
}
