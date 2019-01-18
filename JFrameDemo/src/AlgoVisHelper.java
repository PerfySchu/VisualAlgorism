import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @ClassName AlgoVisHelper
 * @Author PerfySchu
 * @Date 2019/1/18 11:20
 * @Version 1.0
 **/
public class AlgoVisHelper {
    private AlgoVisHelper(){

    }

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

    public static void setColor(Graphics2D graphics2D, Color color){
        graphics2D.setColor(color);
    }

    public static void pause(int t){
        try{
            Thread.sleep(t);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
