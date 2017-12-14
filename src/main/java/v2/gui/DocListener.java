package v2.gui;

import v2.gui.conf.ColorInfo;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.util.Hashtable;

/**
 * 创建自己的文档监听器，完成：
 * （1）关键词高亮
 * （2）记录行号
 */
//TODO: (1)修改样式 (2)处理注释
public class DocListener implements DocumentListener {
    /*
        Token：
        (1) Symbol: ||, &&, ==, !=, >=, <=, +, -, *, /, ;
        (2) Type: int, float, real
        (3) Reserve Words: break, do, else, if, while, read, write
        (4) Constant: false, true, num
        (5) ID: identifiers
        (6) annotation
     */

    private Hashtable<String, Style> styleHashtable = new Hashtable<>();
    private Style symbolStyle;
    private Style basicTypeStyle;
    private Style definedWordsStyle;
    private Style constantsStyle;
    private Style idStyle;
    private Style annotationStyle;
    private Style normalStyle;
    private Style errorStyle;

    private Home home;

    public DocListener(JTextPane editor, Home home) {
        this.home = home;

        symbolStyle = ((StyledDocument) editor.getDocument()).addStyle("symbolStyle", null);
        basicTypeStyle = ((StyledDocument) editor.getDocument()).addStyle("basicTypeStyle", null);
        definedWordsStyle = ((StyledDocument) editor.getDocument()).addStyle("definedWordsStyle", null);
        constantsStyle = ((StyledDocument) editor.getDocument()).addStyle("constantsStyle", null);
        idStyle = ((StyledDocument) editor.getDocument()).addStyle("idStyle", null);
        annotationStyle = ((StyledDocument) editor.getDocument()).addStyle("annotationStyle", null);
        normalStyle = ((StyledDocument) editor.getDocument()).addStyle("normalStyle", null);
        errorStyle = ((StyledDocument) editor.getDocument()).addStyle("errorStyle", null);

        //设置颜色
        StyleConstants.setForeground(symbolStyle, ColorInfo.symbolColor);
        StyleConstants.setForeground(basicTypeStyle, ColorInfo.basicTypeColor);
        StyleConstants.setForeground(definedWordsStyle, ColorInfo.defineWordsColor);
        StyleConstants.setForeground(constantsStyle, ColorInfo.constantsColor);
        StyleConstants.setForeground(idStyle, ColorInfo.idColor);
        StyleConstants.setForeground(annotationStyle, ColorInfo.annotationColor);
        StyleConstants.setForeground(normalStyle, ColorInfo.normalColor);
        StyleConstants.setForeground(errorStyle, ColorInfo.errorColor);

        //设置字体
        StyleConstants.FontConstants.setUnderline(errorStyle, true);
        StyleConstants.FontConstants.setItalic(errorStyle, true);
        StyleConstants.FontConstants.setItalic(annotationStyle, true);
        StyleConstants.FontConstants.setBold(definedWordsStyle, true);
        StyleConstants.FontConstants.setBold(basicTypeStyle, true);
        StyleConstants.FontConstants.setBold(constantsStyle, true);

        //Symbol
        styleHashtable.put("||", symbolStyle);
        styleHashtable.put("&&", symbolStyle);
        styleHashtable.put("==", symbolStyle);
        styleHashtable.put("!=", symbolStyle);
        styleHashtable.put(">=", symbolStyle);
        styleHashtable.put("<=", symbolStyle);
        styleHashtable.put(">", symbolStyle);
        styleHashtable.put("<", symbolStyle);
        styleHashtable.put("+", symbolStyle);
        styleHashtable.put("-", symbolStyle);
        styleHashtable.put("*", symbolStyle);
        styleHashtable.put("/", symbolStyle);
        styleHashtable.put(";", symbolStyle);
        styleHashtable.put(",", symbolStyle);

        //BasicType
        styleHashtable.put("int", basicTypeStyle);
        styleHashtable.put("float", basicTypeStyle);
        styleHashtable.put("real", basicTypeStyle);

        //Reserve Words
        styleHashtable.put("break", definedWordsStyle);
        styleHashtable.put("if", definedWordsStyle);
        styleHashtable.put("else", definedWordsStyle);
        styleHashtable.put("while", definedWordsStyle);
        styleHashtable.put("do", definedWordsStyle);
        styleHashtable.put("read", definedWordsStyle);
        styleHashtable.put("write", definedWordsStyle);

        //Constant
        styleHashtable.put("true", constantsStyle);
        styleHashtable.put("false", constantsStyle);

    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        try {
            colouring((StyledDocument) e.getDocument(), e.getOffset(), e.getLength());
            home.updateLineNum();
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        try {
            colouring((StyledDocument) e.getDocument(), e.getOffset(), 0);
            home.updateLineNum();
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }

    public void colouring(StyledDocument doc, int pos, int len) throws BadLocationException {
        // 取得插入或者删除后影响到的单词.
        // 例如"public"在b后插入一个空格, 就变成了:"pub lic", 这时就有两个单词要处理:"pub"和"lic"
        // 这时要取得的范围是pub中p前面的位置和lic中c后面的位置
        int start = indexOfWordStart(doc, pos);
        int end = indexOfWordEnd(doc, pos + len);

        char ch;
        while (start < end) {
            ch = getCharAt(doc, start);
            if (Character.isLetter(ch) || ch == '_') {      //处理Word
                // 如果是以字母或者下划线开头, 说明是单词
                // pos为处理后的最后一个下标

                //TODO: 标识符的定义
                start = colouringWord(doc, start);

            } else if (Character.isDigit(ch)) {      //处理数字
                start = colouringNum(doc, start);
            } else {
                SwingUtilities.invokeLater(new ColouringTask(doc, start, 1, normalStyle));
                ++start;
            }
        }
    }

    /**
     * 对单词进行着色, 并返回单词结束的下标.
     *
     * @param doc
     * @param pos
     * @return
     * @throws BadLocationException
     */
    public int colouringWord(StyledDocument doc, int pos) throws BadLocationException {
        int wordEnd = indexOfWordEnd(doc, pos);
        String word = doc.getText(pos, wordEnd - pos);

        if (styleHashtable.containsKey(word)) {
            // 如果是关键字, 就进行关键字的着色, 否则使用普通的着色.
            // 这里有一点要注意, 在insertUpdate和removeUpdate的方法调用的过程中, 不能修改doc的属性.
            // 但我们又要达到能够修改doc的属性, 所以把此任务放到这个方法的外面去执行.
            // 实现这一目的, 可以使用新线程, 但放到swing的事件队列里去处理更轻便一点.
            SwingUtilities.invokeLater(new ColouringTask(doc, pos, wordEnd - pos, styleHashtable.get(word)));
        } else {
            SwingUtilities.invokeLater(new ColouringTask(doc, pos, wordEnd - pos, normalStyle));
        }

        return wordEnd;
    }

    //TODO: 处理数字
    public int colouringNum(StyledDocument doc, int pos) throws BadLocationException {
        int numEnd = indexOfWordEnd(doc, pos);
        if (getCharAt(doc, numEnd) == '.') {
            numEnd = indexOfWordEnd(doc, numEnd + 1);
        }

        String num = doc.getText(pos, numEnd - pos);

        int index = 0;
        char c;
        do {
            c = num.charAt(index);
            index++;
        } while (Character.isDigit(c) && index < num.length());

        if (Character.isDigit(c) && index == num.length()) {
            SwingUtilities.invokeLater(new ColouringTask(doc, pos, numEnd - pos, constantsStyle));
            return numEnd;
        }

        //real num
        if (c == '.') {
            index++;
            for (; index < num.length(); index++) {
                c = num.charAt(index);
                if (!Character.isDigit(c)) {
                    SwingUtilities.invokeLater(new ColouringTask(doc, pos, numEnd - pos, errorStyle));
                    return numEnd;
                }
            }
            SwingUtilities.invokeLater(new ColouringTask(doc, pos, numEnd - pos, constantsStyle));
        } else {
            SwingUtilities.invokeLater(new ColouringTask(doc, pos, numEnd - pos, errorStyle));
        }

        return numEnd;
    }

    /**
     * 取得在文档中下标在pos处的字符.
     * <p>
     * 如果pos为doc.getLength(), 返回的是一个文档的结束符, 不会抛出异常. 如果pos<0, 则会抛出异常.
     * 所以pos的有效值是[0, doc.getLength()]
     *
     * @param doc
     * @param pos
     * @return
     * @throws BadLocationException
     */
    public char getCharAt(Document doc, int pos) throws BadLocationException {
        return doc.getText(pos, 1).charAt(0);
    }

    /**
     * 取得下标为pos时, 它所在的单词开始的下标. Â±wor^dÂ± (^表示pos, Â±表示开始或结束的下标)
     *
     * @param doc
     * @param pos
     * @return
     * @throws BadLocationException
     */
    public int indexOfWordStart(Document doc, int pos) throws BadLocationException {
        for (; pos > 0 && isWordCharacter(doc, pos - 1); --pos) ;

        return pos;
    }

    /**
     * 取得下标为pos时, 它所在的单词结束的下标. Â±wor^dÂ± (^表示pos, Â±表示开始或结束的下标)
     *
     * @param doc
     * @param pos
     * @return
     * @throws BadLocationException
     */
    public int indexOfWordEnd(Document doc, int pos) throws BadLocationException {
        for (; isWordCharacter(doc, pos); ++pos) ;

        return pos;
    }

    /**
     * 如果一个字符是字母, 数字, 下划线, 则返回true.
     *
     * @param doc
     * @param pos
     * @return
     * @throws BadLocationException
     */
    public boolean isWordCharacter(Document doc, int pos) throws BadLocationException {
        char ch = getCharAt(doc, pos);
        if (Character.isLetter(ch) || Character.isDigit(ch) || ch == '_') {
            return true;
        }
        return false;
    }
}