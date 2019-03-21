package quicksort;

import java.util.Arrays;

/**
 * @ClassName QuickSortData
 * @Author PerfySchu
 * @Date 2019/1/25 13:20
 * @Version 1.0
 **/
public class QuickSortData {

    public enum Type{
        Default,
        NearlyOrdered
    }

    public int[] numbers;
    public int l, r;
    public int curPivot;
    public int curElement;
    public boolean[] fixedPiovt;

    public QuickSortData(int N, int randomBound, Type dataType){
        numbers = new int[N];
        fixedPiovt = new boolean[N];

        for(int i=0; i<N; i++){
            //生成的数值大于0， 否则画出来看不到
            numbers[i] = (int)(Math.random()*randomBound) + 1;

            fixedPiovt[i] = false;
        }

        if(dataType == Type.NearlyOrdered){
            Arrays.sort(numbers);
            int swapTime = (int) (0.01*N);
            for (int i = 0; i < swapTime; i++) {
                int a = (int) (Math.random()*N);
                int b = (int) (Math.random()*N);
                swap(a, b);
            }
        }
    }

    public QuickSortData(int N, int randomBound){
        this(N, randomBound, Type.Default);
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
