package getPi.withoutRendering;

import java.awt.*;
import java.util.LinkedList;

/**
 * @ClassName MonteCarloPiData
 * @Author PerfySchu
 * @Date 2019/1/20 18:32
 * @Version 1.0
 **/
public class MonteCarloPiData {
    //数据
    private Circle circle;
    private int insideCicle = 0;
    private LinkedList<Point> points;

    public MonteCarloPiData(Circle circle){
        this.circle = circle;
        points = new LinkedList<Point>();
    }

    public Circle getCircle() {
        return circle;
    }

    public Point getPoint(int i){
        if(i < 0 || i >= points.size()){
            throw new IllegalArgumentException("out of bounds in getPoint");
        }
        return points.get(i);
    }

    public int getPointsNumber(){
        return points.size();
    }

    public void addPoint(Point p){
        points.add(p);
        if(circle.contain(p)){
            insideCicle ++;
        }
    }

    /**
     * 估算 π 值
     * @return
     */
    public double estimatePi(){
        if(points.size() == 0){
            return 0.0;
        }
        int circleArea = insideCicle;
        int squareArea = points.size();
        return 4 * (double)circleArea / squareArea;
    }
}
