package insertionsort;

import java.util.Arrays;

/**
 * @ClassName InsertionSortData
 * @Author PerfySchu
 * @Date 2019/1/25 13:20
 * @Version 1.0
 **/
public class InsertionSortData {
    private int[] numbers;

    // [0,1,2,.....,orderedIndex) 已排好序的索引
    public int orderedIndex = -1;
    //当前索引
    public int currentIndex = -1;

    public InsertionSortData(int N, int randomBound, AlgoVisualizer.Type dataType){
        numbers = new int[N];

        for(int i=0; i<N; i++){
            //生成的数值大于0， 否则画出来看不到
            numbers[i] = (int)(Math.random()*randomBound) + 1;
        }
        if(dataType == AlgoVisualizer.Type.NearlyOrdered){
            Arrays.sort(numbers);
            int swapTime = (int) (N * 0.02);
            for(int i=0; i<swapTime; i++){
                int a = (int) (Math.random() * N);
                int b = (int) (Math.random() * N);
                swap(a, b);
            }

        }
    }

    public InsertionSortData(int N, int randomBound){
       this(N, randomBound, AlgoVisualizer.Type.Default);
    }

    public int N(){
        return numbers.length;
    }

    public int get(int index){
        if(index<0 || index>=numbers.length){
            throw new IllegalArgumentException("Invalid index to access Sort Data");
        }

        return numbers[index];
    }

    /**
     * 交换第 i 和第 j 位的值
     * @param i
     * @param j
     */
    public void swap(int i, int j){
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
