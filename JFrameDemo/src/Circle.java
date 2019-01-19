import java.awt.*;

/**
 * @ClassName Circle
 * @Author PerfySchu
 * @Date 2019/1/18 12:56
 * @Version 1.0
 **/
public class Circle {
    public int x,y;
    private int r;
    public int vx, vy;
    public boolean isFilled = false;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR() {
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy, Circle[] circles){
        //圆之间的碰撞检测(未完成，会发生嵌套锁死)
//        for(Circle circle : circles){
//            if(circle != this){
//                if(isCollisionWithCircle(this.x, this.y, circle.x, circle.y, this.r, circle.getR())){
//                    int tempvx = this.vx;
//                    int tempvy = this.vy;
//                    this.vx = circle.vx;
//                    this.vy = circle.vy;
//                    circle.vx = tempvx;
//                    circle.vy = tempvy;
//                    this.isFilled = !this.isFilled;
//                    circle.isFilled = !circle.isFilled;
//                }
//            }
//        }

        x += vx;
        y += vy;
        checkCollision(minx, miny, maxx, maxy);
    }

    private void checkCollision(int minx, int miny, int maxx, int maxy){
        if(x - r < minx){
            x = r;
            vx = -vx;
        }
        if(x + r > maxx){
            x = maxx -r;
            vx = -vx;
        }

        if(y - r < miny){
            y = r;
            vy = -vy;
        }
        if(y + r > maxy){
            y = maxy -r;
            vy = -vy;
        }

    }

    /**
     * 圆形碰撞 检测
     *
     * @param x1
     *            圆形1的圆心X坐标
     * @param y1
     *            圆形2的圆心X坐标
     * @param x2
     *            圆形1的圆心Y坐标
     * @param y2
     *            圆形2的圆心Y坐标
     * @param r1
     *            圆形1的半径
     * @param r2
     *            圆形2的半径
     * @return
     */
    private boolean isCollisionWithCircle(int x1, int y1, int x2, int y2,
                                          int r1, int r2) {
        // Math.sqrt:开平方
        // Math.pow(double x, double y): X的Y次方
        //直角坐标系，依点1和点2做平行线，|x1-x2|为横向直角边，|y1-y2|为纵向直角边 依勾股定理 c^2=a^2+b^2
        if (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) <= r1 + r2) {
            // 如果两圆的圆心距小于或等于两圆半径和则认为发生碰撞
            return true;
        }
        return false;
    }

    public boolean contain(Point p){
        return  (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) <= r * r;

    }

}
