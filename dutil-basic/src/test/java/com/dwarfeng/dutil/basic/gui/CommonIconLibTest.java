package com.dwarfeng.dutil.basic.gui;

import com.dwarfeng.dutil.basic.gui.awt.CommonIconLib;
import com.dwarfeng.dutil.basic.gui.awt.ImageSize;
import com.dwarfeng.dutil.basic.gui.awt.ImageUtil;
import com.dwarfeng.dutil.basic.gui.swing.MuaListModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.EnumMap;

public class CommonIconLibTest extends JFrame {

    private static final long serialVersionUID = -2287413649866925157L;

    private final EnumMap<CommonIconLib, Icon> imageMap = new EnumMap<>(CommonIconLib.class);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CommonIconLibTest frame = new CommonIconLibTest();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public CommonIconLibTest() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JList<CommonIconLib> list = new JList<>();
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(0);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);

        list.setCellRenderer(new DefaultListCellRenderer() {

            private static final long serialVersionUID = 6442258817761011603L;

            @Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus
            ) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (imageMap.containsKey((CommonIconLib) value)) {
                    setIcon(imageMap.get(value));
                } else {
                    Icon icon = new ImageIcon(ImageUtil.getInternalImage((CommonIconLib) value,
                            ImageUtil.getDefaultImage(), ImageSize.ICON_LARGE));
                    imageMap.put((CommonIconLib) value, icon);
                    setIcon(icon);
                }

                setVerticalTextPosition(SwingConstants.BOTTOM);
                setHorizontalTextPosition(SwingConstants.CENTER);
                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }
        });

        MuaListModel<CommonIconLib> listModel = new MuaListModel<>();
        listModel.addAll(Arrays.asList(CommonIconLib.values()));

        list.setModel(listModel);
    }
}
