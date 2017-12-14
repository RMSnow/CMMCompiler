package v2.gui.conf;

import java.awt.*;

/**
 * 控件尺寸信息
 */
public class SizeInfo {
    //frame
    public static int screenWidth;
    public static int screenHeight;
    public static int frameX;
    public static int frameY;
    public static double frameWidthScale = 0.9;
    public static double frameHeightScale = 0.9;
    public static int frameWidth;
    public static int frameHeight;

    //lineList
    public static int lineCellHeight = (int) (FontInfo.codeFont.getSize() * 1.35);
    public static int lineCellWidth = 40;

    //component
    public static Dimension editPaneDimension = new Dimension(800, 250);

    static {
        //frame
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        frameX = (int) (screenWidth * 0.05);
        frameY = (int) (screenHeight * 0.1);
        frameWidth = (int) (screenWidth * frameWidthScale);
        frameHeight = (int) (screenHeight * frameHeightScale);
    }
}
