package v2.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by snow on 02/12/2017.
 */
public class Index {
    private JPanel hello;
    private JTextPane editTextPane;
    private JTextPane consoleTextPane;
    private JButton runButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Index");
        frame.setContentPane(new Index().hello);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screeHeight = screenSize.height;

        frame.setTitle("Home");
        frame.setLocationByPlatform(true);
        frame.setBounds(new Double(screenWidth * 0.1).intValue(),
                new Double(screeHeight * 0.1).intValue(),
                new Double(screenWidth * 0.7).intValue(),
                new Double(screeHeight * 0.7).intValue());

        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
