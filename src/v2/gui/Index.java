package v2.gui;

import v2.lexer.Lexer;
import v2.parser.Parser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

/**
 * Created by snow on 02/12/2017.
 */
public class Index {
    private JPanel hello;
    private JTextPane editTextPane;
    private JTextPane consoleTextPane;
    private JButton runButton;

    private boolean editTextPaneModified = false;

    public Index() {
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //consoleTextPane.setText("Hello World!");

                /*
                    对editTextPane中的文档进行parse
                 */

                Lexer lexer = new Lexer(editTextPane.getText());
                try {
                    Parser parser = new Parser(lexer);
                    parser.program();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });
        editTextPane.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (editTextPane.getText().equals("Editor")){
                    editTextPane.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (editTextPane.getText().equals("")){
                    editTextPane.setText("Editor");
                }
            }
        });
    }

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
