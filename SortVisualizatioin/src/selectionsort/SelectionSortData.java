package selectionsort;

/**
 * @ClassName SelectionSortData
 * @Author PerfySchu
 * @Date 2019/1/25 13:20
 * @Version 1.0
 **/
public class SelectionSortData {
    private int[] numbers;

    // [0,1,2,.....,orderedIndex) 已排好序的索引
    public int orderedIndex = -1;
    //当前找到的最小值索引
    public int currentMinIndex = -1;
    //当前扫描到的索引
    public int currentCompareIndex = -1;

    public SelectionSortData(int N, int randomBound){
        numbers = new int[N];

        for(int i=0; i<N; i++){
            //生成的数值大于0， 否则画出来看不到
            numbers[i] = (int)(Math.random()*randomBound) + 1;
        }
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
