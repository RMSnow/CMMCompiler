package v2.gui;

import v2.gui.conf.ColorInfo;
import v2.gui.conf.FontInfo;
import v2.gui.conf.SizeInfo;
import v2.lexer.Lexer;
import v2.parser.Parser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Home extends JFrame {
    private static final String title = "CMM";

    private JTextPane editTextPane;
    private JScrollPane editScrollPane;      //设置滚动面板
    private DefaultListModel lineList;

    private JTextPane consoleTextPane;
    private JScrollPane consoleScrollPane;

    public Home() {
        super(title);

        this.setBounds(SizeInfo.frameX, SizeInfo.frameY, SizeInfo.frameWidth, SizeInfo.frameHeight);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

//        this.setForeground(new Color(254, 244, 218));
//        this.setBackground(new Color(254, 244, 218));

        init();
    }

    private void init() {
        editTextPane = new JTextPane() {
            public boolean getScrollableTracksViewportWidth() {
                return false;
            }

            public void setSize(Dimension d) {
                if (d.width < getParent().getSize().width) {
                    d.width = getParent().getSize().width;
                }
                d.width += 100;
                super.setSize(d);
            }
        };
        editTextPane.setBackground(ColorInfo.editAreaColor);

        editScrollPane = new JScrollPane(editTextPane);

        lineList = new DefaultListModel();
        JList lineNumList = new JList(lineList);
        //lineNumList.setBorder(new LineBorder(new Color(152, 164, 155)));
        lineNumList.setFixedCellWidth(SizeInfo.lineCellWidth);
        lineNumList.setFixedCellHeight(SizeInfo.lineCellHeight);
        lineNumList.setBackground(ColorInfo.lineAreaColor);
        lineNumList.setFont(FontInfo.lineNumFont);

        editScrollPane.setRowHeaderView(lineNumList);
        this.add(editScrollPane, BorderLayout.CENTER);

        editTextPane.setFont(FontInfo.codeFont);
        editTextPane.getDocument().addDocumentListener(new DocListener(editTextPane, this));

        consoleTextPane = new JTextPane() {
            public boolean getScrollableTracksViewportWidth() {
                return false;
            }

            public void setSize(Dimension d) {
                if (d.width < getParent().getSize().width) {
                    d.width = getParent().getSize().width;
                }
                d.width += 50;
                super.setSize(d);
            }
        };
        consoleTextPane.setPreferredSize(SizeInfo.editPaneDimension);
        consoleTextPane.setFont(FontInfo.consoleFont);
        consoleTextPane.setBackground(ColorInfo.consoleAreaColor);
        consoleScrollPane = new JScrollPane(consoleTextPane);
        this.add(consoleScrollPane, BorderLayout.SOUTH);

        JButton runButton = new JButton("Run");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //控制台初始化
                initConsoleTextPane();

                Lexer lexer = new Lexer(editTextPane.getText());
                try {
                    Parser parser = new Parser(lexer);
                    parser.program();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.add(runButton, BorderLayout.NORTH);
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

    //行号更新
    public void updateLineNum() {
        int line = this.editTextPane.getDocument().getDefaultRootElement()
                .getElementCount();
        if (line == this.lineList.getSize()) {
            return;
        } else if (line > this.lineList.getSize()) {
            for (int i = this.lineList.getSize() + 1; i <= line; i++)
                this.lineList.addElement(i);
        } else {
            for (int i = this.lineList.getSize(); i > line; i--)
                this.lineList.removeElementAt(i - 1);
        }
    }

    public static void main(String[] args) {
        new Home().setVisible(true);
    }

}
