package selectionsort;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

/**
 * @ClassName AlgoVisualizer
 * @Author PerfySchu
 * @Date 2019/1/19 9:40
 * @Version 1.0
 **/
public class AlgoVisualizer {

    //数据
    private SelectionSortData data;

    private static int DELAY = 10;

    //视图
    private AlgoFrame frame;
    //TODO: 其他控制变量

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        //初始化数据
        data = new SelectionSortData(N, sceneHeight-100);



        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Selectiont-Sort", sceneWidth, sceneHeight);

            new Thread(() ->{
                run();
            }).start();
        });
    }

    //动画逻辑
    private void run(){
        setData(0, -1,-1);
        for (int i = 0; i < data.N(); i++) {
            //寻找 [i,N) 区间里的最小值的索引
            int minIndex = i;
            setData(i, -1, minIndex);
            for (int j = i + 1; j < data.N(); j++) {
                setData(i, j, minIndex);
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                    setData(i, j, minIndex);
                }
            }
            data.swap(i, minIndex);
            setData(i+1, -1, -1);
        }
        setData(data.N(), -1, -1);
    }

    private void setData(int orderedIndex, int currentCompareIndex, int currentMinIndex){
        data.orderedIndex = orderedIndex;
        data.currentCompareIndex = currentCompareIndex;
        data.currentMinIndex = currentMinIndex;

        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {
        int sceneWidth = 1366;
        int sceneHeight = 768;
        int N = 100;
        new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
