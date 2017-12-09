package v2.gui;

import v2.lexer.Lexer;
import v2.parser.Parser;

import javax.swing.*;
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
    private JTextArea lineTextArea;
    private JButton runButton;

    public Index(int frameWidth, int frameHeight) {
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

        //TODO: 设置每个区域的大小
        double editPaneWidthScale = 0.9;
        double editPaneHeightScale = 0.7;

//        editTextPane.setSize((int) (frameWidth * editPaneWidthScale),
//                (int) (frameHeight * editPaneHeightScale));
//        consoleTextPane.setSize((int) (frameWidth * 1.0),
//                (int) (frameHeight * (1 - editPaneHeightScale)));
//        lineTextArea.setSize((int) (frameWidth * (1 - editPaneWidthScale)),
//                (int) (frameHeight * editPaneHeightScale));

        editTextPane.setPreferredSize(new Dimension((int) (frameWidth * editPaneWidthScale),
                (int) (frameHeight * editPaneHeightScale)));
        consoleTextPane.setPreferredSize(new Dimension((int) (frameWidth * 1.0),
                (int) (frameHeight * (1 - editPaneHeightScale))));
        lineTextArea.setPreferredSize(new Dimension((int) (frameWidth * (1 - editPaneWidthScale)),
                (int) (frameHeight * editPaneHeightScale)));

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
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screeHeight = screenSize.height;

        //设置框架大小
        int x = (int) (screenWidth * 0.05);
        int y = (int) (screeHeight * 0.1);
        int width = (int) (screenWidth * 0.9);
        int height = (int) (screeHeight * 0.9);

        JFrame frame = new JFrame("Index") {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(width, height);
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Home");
        frame.setLocation(x, y);

        frame.setContentPane(new Index(width, height).home);
        frame.pack();

        frame.setVisible(true);
    }

}
