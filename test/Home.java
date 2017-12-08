package v2.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by snow on 05/12/2017.
 */
public class Home {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screeHeight = screenSize.height;

        frame.setTitle("Home");
        frame.setSize(new Double(screenWidth * 0.7).intValue(),
                new Double(screeHeight * 0.7).intValue());
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //toolPane
        JPanel toolPane = new JPanel();
        toolPane.add(new JButton("Run"));

        //editPane
//        JTextPane editPane = new JTextPane();
//        JTextArea defaultText = new JTextArea("Hello World");
//        editPane.add(defaultText);
//        editPane.add(new JButton("2"));
        JPanel editPane = new JPanel();
        editPane.add(new JButton("Run"));

        //consolePane
//        JTextPane consolePane = new JTextPane();
//        JTextArea outputText = new JTextArea("Loading...");
//        consolePane.add(outputText);
//        consolePane.add(new JButton("3"));
        JPanel consolePane = new JPanel();
        consolePane.add(new JButton("Run"));

        frame.getContentPane().add(toolPane, BorderLayout.NORTH);
        frame.getContentPane().add(editPane, BorderLayout.CENTER);
        frame.getContentPane().add(consolePane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

}
