import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @ClassName AlgoVisualizer
 * @Author PerfySchu
 * @Date 2019/1/19 9:40
 * @Version 1.0
 **/
public class AlgoVisualizer {
    //TODO: 创建自己的数据
    //数据
    private Object data;
    //视图
    private AlgoFrame frame;
    //TODO: 其他控制变量

    public AlgoVisualizer(int sceneWidth, int sceneHeight){
        //初始化数据
        //TODO: 初始化数据 根据需要添加初始化参数


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

        //TODO: 编写自己的动画逻辑
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
        int sceneWidth = 1024;
        int sceneHeight = 768;

        new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
