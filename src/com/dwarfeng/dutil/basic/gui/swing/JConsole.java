package com.dwarfeng.dutil.basic.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import com.dwarfeng.dutil.basic.cna.ArrayUtil;
import com.dwarfeng.dutil.basic.gui.event.EventListenerWeakSet;
import com.dwarfeng.dutil.basic.num.NumTrans;

/**
 * swing����̨�ࡣ
 * <p>����ı�����Ϊ���ƿ���̨�������滻����֮ǰ�汾�Ĳ����ƵĿ���̨��������֮ǰ�汾�Ŀ���̨�����Ƴ���
 * <br> ��εĿ���̨������������<code>System.in</code>����ˣ������ٵ���ʹ�ÿ���̨֮��ͻ�ʧȥԭ�е�ϵͳ�������
 * ����̨��Ȼ�ṩһ������������û������¶��������ʱ�����Խ��ṩ��������ض���<code>System.in</code>�ϡ�
 * <br> ����̨�ṩ���µ�������֤���������ı��ﵽһ���������������ı�������������ʱ������̨�ᰴ��һ���ı���ɾ��
 * ���������һ�����������Կ����������������ֵ��
 * ��ɾ�������������Ϊ�ܱ���ʾ�������������������ڹ������б�ָ����һ����ָ���Ͳ��ܸ��ġ�
 * <br> ����̨�ṩ�����������������������������������̰߳�ȫ�ģ����Զ���߳�ͬʱ��������������ֽڣ��������������߳�
 * ����ȫ�ģ���ֻ�����ڵ��߳����룬�����ǲ��Ǽ������ⲿͬ�����ơ�
 * <br>��Ҫע����ǣ��˿���̨��Ч��ԶԶ����ϵͳ����̨����ͬ����������£��˿���̨�Ļ���ʱ���ԼΪϵͳ����̨��10����
 * 
 * @author DwArFeng
 * @since 1.8
 */
public class JConsole extends JPanel{
	
	private static final long serialVersionUID = 4394657761909015686L;
	
	/**�������*/
	protected final static int DEFAULT_MAX_LINE = 3000;
	/**��ɾ������*/
	protected final static int LINE_RATIO = 10;

	/**�ı���*/
	protected final JTextArea textArea;
	/**�����*/
	protected final JTextField inputField;
	
	/**�¼�����*/
	protected final EventListenerWeakSet eSet = new EventListenerWeakSet();
	
	/**�����ʾ����*/
	protected int maxLine = DEFAULT_MAX_LINE;
	/**�Ƿ���Ա��*/
	private boolean echoFlag = true;
	
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
		
		inputField = new JTextField();
		textArea = new JTextArea();
		
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
	private final InnerOutputStream outputStream = new InnerOutputStream();
	private final PrintStream printStream = new PrintStream(outputStream,true);
	
	public InputStream getIn(){
		return this.inputStream;
	}
	private final InnerInputStream inputStream = new InnerInputStream();
	
	/**
	 * �����̨�����ӿ���̨�����¼�������
	 * <p> ����ڲ���<code>e</code>Ϊ<code>null</code>��ʱ��ʲôҲ������
	 * @param e ����̨�����¼�������
	 */
	public void addConsoleInputEventListener(ConsoleInputEventListener e){
		if(e == null) return;
		eSet.add(e);
	}
	
	/**
	 * �����̨���Ƴ������¼�������
	 * @param e ָ���Ŀ���̨�����¼�������
	 * @return ���Ƴ������Ƿ�ɹ��Ƴ���ָ�����¼�������
	 */
	public boolean removeConsoleInputEventListener(ConsoleInputEventListener e){
		return eSet.remove(e);
	}
	
	/**
	 * �Ƴ����е��¼�������
	 */
	public void removeAllListeners(){
		eSet.clear();
	}
	
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
	 * ����������Ƿ����á�
	 * @return ������Ƿ����á�
	 */
	public boolean isInputFieldEnabled(){
		return inputField.isEnabled();
	}
	
	/**
	 * ����������Ƿ����á�
	 * @param flag ָ�������ñ�ʶ��
	 */
	public void setInputFieldEnabled(boolean flag){
		inputField.setEnabled(flag);
	}
	
	/**
	 * ����������Ƿ���ʾ��
	 * @return ������Ƿ���ʾ��
	 */
	public boolean isInputFieldVisible(){
		return inputField.isVisible();
	}
	
	/**
	 * ����������Ƿ���ʾ��
	 * @param flag ָ������ʾ��ʶ��
	 */
	public void setInputFieldVisible(boolean flag){
		inputField.setVisible(flag);
	}
	
	/**
	 * ����̨�����Ƿ���ԡ�
	 * @return ����̨�����Ƿ���ԡ�
	 */
	public boolean isEcho() {
		return echoFlag;
	}

	/**
	 * ���ÿ���̨�����Ƿ����
	 * @param echoFlag ����̨�����Ƿ���ԡ�
	 */
	public void setEcho(boolean echoFlag) {
		this.echoFlag = echoFlag;
	}

	/**
	 * �ṩ����ĳ�ʼ����
	 */
	private void init(){
		setLayout(new BorderLayout(0, 0));
		
		inputField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String inputedText = inputField.getText();
					inputStream.setText(inputedText + "\n");
					ConsoleInputEvent event = new ConsoleInputEvent(this, inputedText + "\n", getIn());
					fireConsoleInputEvent(event);
					if(echoFlag){
						printStream.println(inputedText);
					}
					inputField.setText("");
				}
			}
		});
		
		add(inputField, BorderLayout.SOUTH);
		inputField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
	
	protected void fireConsoleInputEvent(ConsoleInputEvent event) {
		for(ConsoleInputEventListener listener : eSet.subSet(ConsoleInputEventListener.class)){
			listener.onConsoleInput(event);
		}
	}
	
	
	private final class InnerInputStream extends InputStream{
		
		private int mark = 0;
		private int lastMark = 0;
		private byte[] bytesForString;
		private final Lock inLock = new ReentrantLock();
		
		public void setText(String text){
			inLock.lock();
			try{
				bytesForString = (text).getBytes();
				mark = 0;
				lastMark = 0;
			}finally{
				inputStream.inLock.unlock();
			}
		}
		
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
				if(available() == 0) return -1;
				return bytesForString[mark++];
			}finally{
				inLock.unlock();
			}
		}
		
	}
	
	private final class InnerOutputStream extends OutputStream{

		private final Lock outLock = new ReentrantLock();
		private final ArrayList<Byte> byteList = new ArrayList<Byte>();
		
		/*
		 * (non-Javadoc)
		 * @see java.io.OutputStream#flush()
		 */
		@Override
		public void flush(){
			outLock.lock();
			try{
				String str = new String(ArrayUtil.unpack(byteList.toArray(new Byte[0])));
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
				byteList.add(NumTrans.cutInt2Byte(b));
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
			textArea.setCaretPosition(textArea.getText().length());
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
	
	}
}