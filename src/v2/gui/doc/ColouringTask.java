package v2.gui.doc;

import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 * 着色任务
 */
public class ColouringTask implements Runnable{
    private StyledDocument doc;
    private Style style;
    private int pos;
    private int len;

    public ColouringTask(StyledDocument doc, int pos, int len, Style style) {
        this.doc = doc;
        this.pos = pos;
        this.len = len;
        this.style = style;
    }

    public void run() {
        try {
            doc.setCharacterAttributes(pos, len, style, true);      //对字符进行着色
        } catch (Exception e) {
        }
    }
}
