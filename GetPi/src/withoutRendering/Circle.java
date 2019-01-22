package withoutRendering;

import java.awt.*;

/**
 * @ClassName Circle
 * @Author PerfySchu
 * @Date 2019/1/20 17:39
 * @Version 1.0
 **/
public class Circle {
    private int x, y, r;

    public Circle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    /**
     * 点 p 是否在圆内
     * @param p
     * @return
     */
    public boolean contain(Point p){
        return Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2) <= r * r;
    }
}
