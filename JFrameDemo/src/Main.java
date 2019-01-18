import javax.swing.*;
import java.awt.*;

/**
 * @ClassName Main
 * @Author PerfySchu
 * @Date 2019/1/18 10:04
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        int sceneWidth = 1024;
        int sceneHeight = 768;

        int N = 10;
        Circle[] circles = new Circle[N];
        int R = 50;

        for(int i=0; i<N; i++){
            int x = (int)(Math.random() * (sceneWidth-2*R)) + R;
            int y = (int)(Math.random() * (sceneHeight-2*R)) + R;
            int vx = (int)(Math.random() * 11) - 5;
            int vy = (int)(Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }

        EventQueue.invokeLater(() -> {
            AlgoFrame frame = new AlgoFrame("Welcom", sceneWidth, sceneHeight);

            new Thread(() ->{
                while (true){
                    frame.render(circles);
                    AlgoVisHelper.pause(20);

                    //更新数据
                    for(Circle circle : circles){
                        circle.move(0, 0, sceneWidth, sceneHeight, circles);
                    }
                }
            }).start();
        });
    }
}
