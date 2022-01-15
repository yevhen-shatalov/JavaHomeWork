package com.pb.shatalov.Test3.s02swing.layouts;

import javax.swing.*;
import java.awt.*;

/**
 * Если по каким либо причинам вам необходимо самостоятельно расположить компоненты,
 * то можно воспользоваться менеджером NullLayout установив в метод setLayout() значение null.
 */
public class S09NullLayoutDemo {
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(null);

        JButton b1 = new JButton("one");
        JTextArea t2 = new JTextArea("two");
        JTextField t3 = new JTextField("three");

        pane.add(b1);
        pane.add(t2);
        pane.add(t3);

        Insets insets = pane.getInsets();
        Dimension size = b1.getPreferredSize();
        b1.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
        size = t2.getPreferredSize();
        t2.setBounds(55 + insets.left, 40 + insets.top, size.width, size.height);
        size = t3.getPreferredSize();
        t3.setBounds(150 + insets.left, 15 + insets.top, size.width + 50, size.height + 20);
    }

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("AbsoluteLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());

        Insets insets = frame.getInsets();
        frame.setSize(300 + insets.left + insets.right, 125 + insets.top + insets.bottom);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
