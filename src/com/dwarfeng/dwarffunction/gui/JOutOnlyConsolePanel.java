package com.dwarfeng.dwarffunction.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;

/**
 * ����̨��壬�ṩGUI�µĿ���̨���ÿ���ֻ̨������������ܽ������롣
 * @author DwArFeng
 * @since 1.7
 */
public class JOutOnlyConsolePanel extends JPanel{
	
	private static final long serialVersionUID = -1296130270677591061L;

	/**
	 * ����̨Ĭ�ϵ���ʾ������	
	 */
	public final static int DEFAULT_MAXLINE = 4096;
	/**
	 * ����̨��С����ʾ����,ע���ֵ����С��1
	 */
	public final static int DEFAULT_MINLINE = 10;
	
	private int maxLine;
	private JTextArea console;
	private Lock lock;
	
	/**
	 * ����һ��Ĭ�ϵĿ���̨����
	 */
	public JOutOnlyConsolePanel(){
		this(DEFAULT_MAXLINE);
	}
	/**
	 * ����һ������ָ������������Ŀ���̨��
	 * @param maxLine ָ�������������
	 */
	public JOutOnlyConsolePanel(int maxLine){
		this.maxLine = Math.max(maxLine,DEFAULT_MINLINE);
		init();
	}
	
	/**
	 * ��ȡ�ÿ���̨�б��������������
	 * @return ����̨�б��������������
	 */
	public int getMaxLine(){return this.maxLine;}
	/**
	 * ���ÿ���̨�б��������������
	 * @param maxLine ����̨�б��������������
	 */
	public void setMaxLine(int maxLine){this.maxLine = maxLine;}
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private void init(){
		lock = new ReentrantLock();
		
		PrintStream printStream = createPrintStream();
		System.setOut(printStream);
		System.setErr(printStream);
		
		setDoubleBuffered(true);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		console = new JTextArea();
		console.setEditable(false);
		scrollPane.setViewportView(console);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(console, popupMenu);
		
		popupMenu.add(new JMenuItemAction.Productor()
				.name("���")
				.keyStorke(KeyStroke.getKeyStroke(KeyEvent.VK_C , 0))
				.listener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						console.setText("");
					}
				})
				.product()
		);
		
		popupMenu.add(new JMenuItemAction.Productor()
				.name("ȫѡ")
				.keyStorke(KeyStroke.getKeyStroke(KeyEvent.VK_A , 0))
				.listener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						console.select(0, console.getText().length());
					}
				})
				.product()
		);
	}
	private void appendText(String str){
		lock.lock();
		try{
			console.append(str);
			try{
				while(console.getLineCount() > getMaxLine()){
					console.replaceRange(null, console.getLineStartOffset(0), console.getLineEndOffset(maxLine/10));
				}
				console.setCaretPosition(console.getText().length());
			}catch(BadLocationException e){
				e.printStackTrace();
			}
		}finally{
			lock.unlock();
		}
	}
	private PrintStream createPrintStream(){
		OutputStream outputStream = new OutputStream() {
			
			private List<Byte> list = new Vector<Byte>();
			
			@Override
			public void flush(){
				byte[] b = new byte[list.size()];
				for(int i = 0 ; i < b.length ; i ++){
					b[i] = list.get(i).byteValue();
				}
				appendText(new String(b));
				list.clear();
			}
			
			@Override
			public void write(int i) throws IOException {
				list.add(new Integer(i).byteValue());
			}
		};
		PrintStream pStream = new PrintStream(outputStream,true);
		return pStream;
	}
}
