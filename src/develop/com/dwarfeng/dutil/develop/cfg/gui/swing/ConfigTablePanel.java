package com.dwarfeng.dutil.develop.cfg.gui.swing;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * ʹ�ñ������ñ༭��塣
 * @author  DwArFeng
 * @since 1.8
 */
public class ConfigTablePanel extends JPanel {
	
	/**���ñ��*/
	protected final JTable table;
	
	

	/**
	 * Create the panel.
	 */
	public ConfigTablePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	
	
	
	
	

}
