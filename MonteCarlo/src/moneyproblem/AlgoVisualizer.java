package moneyproblem;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * @ClassName moneyproblem.AlgoVisualizer
 * @Author PerfySchu
 * @Date 2019/1/19 9:40
 * @Version 1.0
 **/
public class AlgoVisualizer {

    //现成暂停时间
    private static int DELAY = 10;

    //数据
    private int[] money;
    //视图
    private AlgoFrame frame;
    //TODO: 其他控制变量

    public AlgoVisualizer(int sceneWidth, int sceneHeight){
        //初始化数据
        money = new int[100];
        for(int i=0; i<money.length; i++){
            money[i] = 100;
        }

        //初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcom", sceneWidth, sceneHeight);
            //TODO: 根据需要添加键盘事件和鼠标事件监听器
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() ->{
                run();
            }).start();
        });
    }

    //动画逻辑
    private void run(){
        while (true){
            frame.render(money);
            AlgoVisHelper.pause(DELAY);

            for(int i=0; i<money.length; i++){
                if(money[i] > 0){
                    //某人随机给另一个人一块钱
                    int j = (int) (Math.random() * money.length);
                    money[i] -= 1;
                    money[j] += 1;
                }
            }
        }
    }

    //TODO:根据需要实现键盘交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{
        //Override 具体的方法
    }

    //TODO:根据需要实现鼠标交互事件监听器类
    private class AlgoMouseListener extends MouseAdapter{
        //Override 具体的方法
    }

    public static void main(String[] args) {
        int sceneWidth = 1000;
        int sceneHeight = 568;

        new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
