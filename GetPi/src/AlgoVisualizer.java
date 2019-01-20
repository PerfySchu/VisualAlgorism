import java.awt.*;
import java.util.LinkedList;

/**
 * @ClassName AlgoVisualizer
 * @Author PerfySchu
 * @Date 2019/1/19 9:40
 * @Version 1.0
 **/
public class AlgoVisualizer {
    //数据
    private MonteCarloPiData data;
    private int N;
    //视图
    private AlgoFrame frame;
    private static int DELAY = 20;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        if(sceneHeight != sceneWidth){
            throw new IllegalArgumentException("This demo must be run in a square!");
        }

        //初始化数据
        this.N = N;
        Circle circle = new Circle(sceneWidth/2, sceneHeight/2, sceneWidth/2);
        data = new MonteCarloPiData(circle);

        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Get π with Monte Carlo", sceneWidth, sceneHeight);

            new Thread(() ->{
                run();
            }).start();
        });
    }

    //动画逻辑
    private void run(){
        for(int i = 0; i < N; i++){
            if(i % 100 == 0) {
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
                System.out.println(data.estimatePi());
            }

            int x = (int) (Math.random() * frame.getCanvasWitdh());
            int y = (int) (Math.random() * frame.getCanvasHeight());

            data.addPoint(new Point(x, y));

        }
    }

    public static void main(String[] args) {
        int sceneWidth = 600;
        int sceneHeight = 600;

        new AlgoVisualizer(sceneWidth, sceneHeight, 10000);
    }
}
