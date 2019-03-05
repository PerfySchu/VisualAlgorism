package insertionsort;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @ClassName AlgoVisHelper
 * @Author PerfySchu
 * @Date 2019/1/18 11:20
 * @Version 1.0
 **/
public class AlgoVisHelper {
    //私有构造方法，无法从外部创建对象
    private AlgoVisHelper(){}

    //自定义颜色
    public static final Color Red = new Color(0xF44336);
    public static final Color Pink = new Color(0xE91E63);
    public static final Color Purple = new Color(0x9C27B0);
    public static final Color DeepPruple = new Color(0x673AB7);
    public static final Color Indigo = new Color(0x3F51F5);
    public static final Color Blue = new Color(0x2196F3);
    public static final Color LightBlue = new Color(0x03A9F4);
    public static final Color Cyan = new Color(0x00BCD4);
    public static final Color Teal = new Color(0x009688);
    public static final Color Green = new Color(0x4CAF50);
    public static final Color LightGreen = new Color(0x8BC34A);
    public static final Color Lime = new Color(0xCDDC39);
    public static final Color Yellow = new Color(0xFFEB3B);
    public static final Color Amber = new Color(0xFFC107);
    public static final Color Orange = new Color(0xFF9800);
    public static final Color DeepOrange = new Color(0xFF5722);
    public static final Color Brown = new Color(0x795548);
    public static final Color Grey = new Color(0x9E9E9E);
    public static final Color BlueGrey = new Color(0x607D8B);
    public static final Color Black = new Color(0x000000);
    public static final Color White = new Color(0xFFFFFF);

    /**
     * 设置线宽
     * @param graphics2D
     * @param w
     */
    public static void setStrokeWidth(Graphics2D graphics2D, int w){
        int strokeWidth = w;
        //线段平滑 CAP_ROUND, 线段拐点平滑 JOIN_ROUND
        graphics2D.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

    }

    /**
     * 指定位置 x,y 绘制一个半径为 r 的空心圆形
     * @param graphics2D
     * @param x x轴
     * @param y y轴
     * @param r 半径
     */
    public static void strokeCircle(Graphics2D graphics2D, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        graphics2D.draw(circle);
    }

    /**
     * 指定位置 x,y 绘制一个半径为 r 的实心圆形
     * @param graphics2D
     * @param x x轴
     * @param y y轴
     * @param r 半径
     */
    public static void fillCircle(Graphics2D graphics2D, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        graphics2D.fill(circle);
    }

    /**
     * 绘制空心矩形
     * @param graphics2D
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public static void strokeRectangel(Graphics2D graphics2D, int x, int y, int w, int h){
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        graphics2D.draw(rectangle);
    }

    /**
     * 绘制实心矩形
     * @param graphics2D
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public static void fillRectangel(Graphics2D graphics2D, int x, int y, int w, int h){
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        graphics2D.fill(rectangle);
    }

    /**
     * 设置颜色
     * @param graphics2D
     * @param color
     */
    public static void setColor(Graphics2D graphics2D, Color color){
        graphics2D.setColor(color);
    }

    /**
     * 现成暂停
     * @param t 毫秒数
     */
    public static void pause(int t){
        try{
            Thread.sleep(t);
        }catch (InterruptedException e){
            System.out.println("Error sleeping");
        }
    }

    /**
     * 绘制图案
     * @param graphics2D
     * @param x
     * @param y
     * @param imageURL
     */
    public static void putImage(Graphics2D graphics2D, int x, int y, String imageURL){
        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();

        graphics2D.drawImage(image, x, y, null);

    }

    /**
     * 以指定坐标为中心绘制字符
     * @param graphics2D
     * @param text
     * @param centerx
     * @param centery
     */
    public static void drawText(Graphics2D graphics2D, String text, int centerx, int centery){
        if(text ==  null){
            throw new IllegalArgumentException("Text is null in drawText function");
        }

        FontMetrics metrics = graphics2D.getFontMetrics();
        int w = metrics.stringWidth(text);
        int h = metrics.getDescent();
        graphics2D.drawString(text, centerx - w/2, centery + h);
    }

    public static void setFont(Graphics2D graphics2D, int fontSize, Color fontColor){
        Font font = new Font("微软雅黑", Font.BOLD, fontSize);
        graphics2D.setColor(fontColor);
        graphics2D.setFont(font);
    }
}
