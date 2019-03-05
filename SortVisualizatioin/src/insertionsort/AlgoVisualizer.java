package insertionsort;

import java.awt.*;

/**
 * @ClassName AlgoVisualizer
 * @Author PerfySchu
 * @Date 2019/1/19 9:40
 * @Version 1.0
 **/
public class AlgoVisualizer {

    //数据
    private InsertionSortData data;

    private static int DELAY = 50;

    //视图
    private AlgoFrame frame;
    //TODO: 其他控制变量

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        //初始化数据
        data = new InsertionSortData(N, sceneHeight-100);



        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Insertion-Sort Visualization", sceneWidth, sceneHeight);

            new Thread(() ->{
                run();
            }).start();
        });
    }

    //动画逻辑
    private void run(){
        setData(0, -1);
        for (int i = 0; i < data.N(); i++) {
            setData(i, i);
            for (int j = i; j > 0 && data.get(j) < data.get(j-1); j--) {
                data.swap(j, j-1);
                setData(i+1, j-1);
            }
        }
        setData(data.N(),  -1);
    }

    private void setData(int orderedIndex, int currentIndex){
        data.orderedIndex = orderedIndex;
        data.currentIndex = currentIndex;

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        int sceneWidth = 1336;
        int sceneHeight = 768;
        int N = 100;
        new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
