package demo.org.cmm.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

@SuppressWarnings("serial")
public class Editor extends JFrame implements ActionListener,
        UndoableEditListener {
    public static InterpretingThread runThread;
    private static final String version = "CMM";

    private final UndoManager undoMgr = new UndoManager();
    private String fileName = "";
    private boolean saved = true;

    private JScrollPane editSPane;
    private JPanel consolePanel;

    private Console console;
    private DefaultListModel lineNum;

    public JTextPane editPane = new JTextPane() {
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

    public Editor() {
        super(version);
        this.setBounds(250, 50, 900, 650);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(Editor.this,
                        "是否要退出？ ", "确认 ", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION)
                    if (e.getWindow() == Editor.this) {
                        System.exit(0);
                    } else {
                        return;
                    }
            }
        });
        init();
    }

    private void init() {
        editSPane = new JScrollPane(editPane);
        lineNum = new DefaultListModel();
        JList lineNumList = new JList(lineNum);
        lineNumList.setBorder(new EmptyBorder(3, 0, 0, 0));
        lineNumList.setFixedCellWidth(35);
        lineNumList.setFixedCellHeight(17);
        lineNumList.setForeground(new Color(120, 120, 120));
        lineNumList.setBackground(new Color(228, 228, 228));
        lineNumList.setFont(new Font("Courier New", Font.PLAIN, 14));
        editSPane.setRowHeaderView(lineNumList);
        this.add(editSPane, BorderLayout.CENTER);
        editPane.setFont(new Font("Courier New", Font.PLAIN, 14));
        editPane.getDocument().addDocumentListener(
                new SyntaxHighlighter(editPane, this));

        // console
        this.console = new Console();
        this.consolePanel = new JPanel();
        this.consolePanel.setLayout(new BorderLayout());
        this.consolePanel.setPreferredSize(new Dimension(800, 150));
        this.consolePanel.add(new JLabel("控制台窗口"), BorderLayout.NORTH);
        JScrollPane consolSPane = new JScrollPane(this.console);
        this.consolePanel.add(consolSPane, BorderLayout.CENTER);
        this.add(this.consolePanel, BorderLayout.SOUTH);

        this.editPane.getDocument().addUndoableEditListener(this);
        this.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


        runThread = new InterpretingThread(this);
    }

    public void undoableEditHappened(UndoableEditEvent evt) {
        // System.out.println(evt.getEdit().getPresentationName());
        if (evt.getEdit().getPresentationName().equals("风格变化"))
            return;
        undoMgr.addEdit(evt.getEdit());
    }


    public void lineNumRelist() {
        int line = this.editPane.getDocument().getDefaultRootElement()
                .getElementCount();
        if (line == this.lineNum.getSize()) {
            return;
        } else if (line > this.lineNum.getSize()) {
            for (int i = this.lineNum.getSize() + 1; i <= line; i++)
                this.lineNum.addElement(i);
        } else {
            for (int i = this.lineNum.getSize(); i > line; i--)
                this.lineNum.removeElementAt(i - 1);
        }
    }

    public void titleReset() {
        if (!this.saved)
            return;
        if (this.fileName.equals("")) {
            this.setTitle(version + " - 新建文件*");
        } else {
            this.setTitle(version + " - " + fileName + "*");
        }
    }

    public void setLookAndFeel(String lnf) {

        try {
            UIManager.setLookAndFeel(lnf);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read() {
        this.console.inputAcc();
    }

    public static void main(String[] args)
            throws UnsupportedLookAndFeelException {
        Editor w = new Editor();
        w.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
