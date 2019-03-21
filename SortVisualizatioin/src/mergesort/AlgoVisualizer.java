package mergesort;

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
    private MergeSortData data;

    private static int DELAY = 100;

    //视图
    private AlgoFrame frame;
    //TODO: 其他控制变量

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        //初始化数据
        data = new MergeSortData(N, sceneHeight-100);



        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Merge-Sort", sceneWidth, sceneHeight);

            new Thread(() ->{
                run();
            }).start();
        });
    }

    //动画逻辑
    private void run(){
        setData(0, -1,-1);
        //自顶向下
//        mergeSort(0, data.N() -1);
        //自底向上
        mergeSort2(data);

        setData(0, data.N()-1, data.N()-1);
    }

    private void mergeSort(int l, int r){
        if(l >= r){
            return;
        }
        setData(l, r, -1);
        int mid = (l+r)/2;
        mergeSort(l, mid);
        mergeSort(mid+1, r);
        merge(l, mid, r);
    }

    //自顶向下
    private void merge(int l, int mid, int r){
        //copyOfRange()方法左闭右开，实际复制范围是 l 到 r  不包含 r+1
        int[] aux = Arrays.copyOfRange(data.numbers, l, r+1);

        //初始化，i指向左半部分的起始索引位置l，j指向右半部分的起始索引位置 mid + 1
        int i = l, j = mid + 1;
        for(int k = l; k <= r; k++){
            if(i>mid){
                data.numbers[k] = aux[j-l];
                j++;
            }else if(j>r){
                data.numbers[k] = aux[i-l];
                i ++;
            }else if(aux[i-l] < aux[j-l]){
                data.numbers[k] = aux[i-l];
                i ++;
            }else{
                data.numbers[k] = aux[j-l];
                j ++;
            }
            setData(l, r, k);
        }
    }

    //自底向上
    private void mergeSort2(MergeSortData data){
        for(int sz=1; sz<data.N(); sz*=2){
            for(int i=0; i<data.N()-sz; i+=sz+sz){
                merge(i, i+sz-1, Math.min(i+sz+sz-1, data.N()-1));
            }
        }
    }

    private void setData(int l, int r, int mergeIndex){
        data.l = l;
        data.r = r;
        data.mergeIndex = mergeIndex;

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
