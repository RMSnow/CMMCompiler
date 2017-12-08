package v2.gui;

import v2.lexer.Lexer;
import v2.parser.Parser;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.*;


/**
 * Created by snow on 02/12/2017.
 */
public class Index {
    private JPanel home;
    private JTextPane editTextPane;
    private JTextPane consoleTextPane;
    private JButton runButton;
    private JTextArea lineTextArea;

    public Index() {
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //控制台初始化
                initConsoleTextPane();

                //TODO: 设置token的颜色
//                Style normal = editTextPane.addStyle("normal",null);
//                Style redFont = editTextPane.addStyle("red",normal);
//                StyleConstants.setForeground(redFont, Color.red);
//
//                try {
//                    editTextPane.getDocument().insertString(editTextPane.getDocument().getLength(),
//                            "this is a normal token",editTextPane.getStyle("normal"));
//                    editTextPane.getDocument().insertString(editTextPane.getDocument().getLength(),
//                            "this is a focused token",editTextPane.getStyle("red"));
//                } catch (BadLocationException e1) {
//                    e1.printStackTrace();
//                }

                //进行解析
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
                if (editTextPane.getText().equals("Editor")) {
                    editTextPane.setText("");
                }

                //TODO: 采用多线程，检测焦点变化并改变行号

//                while (true) {
//                    int caretPosition = editTextPane.getCaretPosition();
//                    Element root = editTextPane.getDocument().getDefaultRootElement();
//
//                    int line = root.getElementIndex(caretPosition) + 1;
//                    lineTextArea.append(line + "\n");
//                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (editTextPane.getText().equals("")) {
                    editTextPane.setText("Editor");
                }
            }
        });
    }

    // 截获控制台信息并输出至consoleTextPane
    public void initConsoleTextPane() {
        try {
            final LoopedStreams ls;
            ls = new LoopedStreams();

            // 重定向System.out和System.err
            PrintStream ps = new PrintStream(ls.getOutputStream());
            System.setOut(ps);
            System.setErr(ps);

            InputStream inputStream = ls.getInputStream();
            final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            new Thread(new Runnable() {
                public void run() {
                    StringBuffer buffer = new StringBuffer();

                    try {
                        consoleTextPane.setText("");
                        String s;
                        while ((s = br.readLine()) != null) {
                            consoleTextPane.setText(consoleTextPane.getText() + s + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Index");
        frame.setContentPane(new Index().home);
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

        //TODO: 设置每个区域的大小

        frame.setVisible(true);
    }

}
