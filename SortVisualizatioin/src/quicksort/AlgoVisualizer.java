package quicksort;

import java.awt.*;
import java.util.Arrays;

/**
 * @ClassName AlgoVisualizer
 * @Author PerfySchu
 * @Date 2019/1/19 9:40
 * @Version 1.0
 **/
public class AlgoVisualizer {

    //数据
    private QuickSortData data;

    private static int DELAY = 10;

    //视图
    private AlgoFrame frame;
    //TODO: 其他控制变量

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        //初始化数据
        data = new QuickSortData(N, sceneHeight-100);



        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Quick-Sort", sceneWidth, sceneHeight);

            new Thread(() ->{
                run();
            }).start();
        });
    }

    //动画逻辑
    private void run(){
        setData(-1, -1, -1, -1, -1);

        quickSor(0, data.N()-1);

        setData(-1, -1, -1, -1, -1);

    }

    private void quickSor(int l, int r){
        if(l > r){
            return;
        }
        if(l == r){
            setData(l, r, l, -1, -1);
            return;
        }

        setData(l, r, -1, -1, -1);
        int p = partition(l, r);
        quickSor(l, p-1);
        quickSor(p+1, r);
    }

    private int partition(int l, int r){
        int v = data.get(l);
        setData(l, r, -1, l, -1);

        int j = l;
        for(int i=l+1; i<=r; i++){
            setData(l, r, -1, l, i);
            if(data.get(i) < v){
                j ++;
                data.swap(j, i);
                setData(l, r, -1, l, i);
            }
        }
        data.swap(l, j);
        setData(l, r, j, -1, -1);
        return  j;
    }

    private void setData(int l, int r, int fixedPivot, int curPivot, int curElement){
        data.l = l;
        data.r = r;
        if(fixedPivot != -1){
            data.fixedPiovt[fixedPivot] = true;
        }
        data.curPivot = curPivot;
        data.curElement = curElement;

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
