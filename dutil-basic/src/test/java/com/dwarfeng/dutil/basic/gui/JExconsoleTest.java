package com.dwarfeng.dutil.basic.gui;

import com.dwarfeng.dutil.basic.gui.swing.JExconsole;
import com.dwarfeng.dutil.basic.gui.swing.SwingUtil;
import com.dwarfeng.dutil.basic.io.CT;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class JExconsoleTest {

    public static void main(String[] args) {
        JExconsole console = new JExconsole();
        // console.setLocale(Locale.US);
        ComponentTester tester = new ComponentTester(console);
        try {
            SwingUtil.invokeAndWaitInEventQueue(() -> tester.setVisible(true));
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
        }

        System.setIn(console.in);
        System.setOut(console.out);
        System.setErr(console.out);

        CT.trace("looooooooooooooooooooooooong looooooooooooooooooooooooong ago");
        CT.trace("The quick fox jumps over the lazy dog");
        CT.trace("中国智造，惠及全球");
        CT.trace("请说点什么");

        Scanner scanner = new Scanner(System.in);
        CT.trace("您说的是：" + scanner.nextLine());
        scanner.close();

        CT.trace("请说点什么x2");

        scanner = new Scanner(System.in);
        CT.trace("您说的是：" + scanner.nextLine());
        scanner.close();

        CT.trace("功能测试完毕！");
    }
}
