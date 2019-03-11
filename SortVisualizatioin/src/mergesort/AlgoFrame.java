package mergesort;

import javax.swing.*;
import java.awt.*;

/**
 * 视图层
 * @ClassName AlgoFrame
 * @Author PerfySchu
 * @Date 2019/1/18 10:33
 * @Version 1.0
 **/
public class AlgoFrame extends JFrame {

    private int canvasWitdh;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){
        super(title);

        this.canvasWitdh = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        this.setContentPane(canvas);
        pack();

        this.setLocation(300, 150);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    public AlgoFrame(String title){
        this(title, 1024, 768);
    }

    public int getCanvasWitdh() {
        return canvasWitdh;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    //TODO:设置自己的数据
    private MergeSortData data;
    public void render(MergeSortData data){
        this.data = data;
        this.repaint();
    }

    private class AlgoCanvas extends JPanel{
        public AlgoCanvas(){
            //开启双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g){

            super.paintComponent(g);

            Graphics2D graphics2D = (Graphics2D) g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.addRenderingHints(hints);

            //具体绘制
            int w = canvasWitdh / data.N();
            for(int i=0; i<data.N(); i++){
                if(i >= data.l && i<= data.r){
                    AlgoVisHelper.setColor(graphics2D, AlgoVisHelper.Green);
                }else{
                    AlgoVisHelper.setColor(graphics2D, AlgoVisHelper.Grey);
                }
                if(i >= data.l && i <= data.mergeIndex){
                    AlgoVisHelper.setColor(graphics2D, AlgoVisHelper.Red);
                }

                AlgoVisHelper.fillRectangel(graphics2D, i * w, canvasHeight - data.get(i), w - 1, data.get(i));
//                String desc = "当前已排完【"+data.orderedIndex+"】\n 未排中最小【"+data.get(data.currentMinIndex)+"】\n 当前扫描值【"+data.get(data.currentCompareIndex)+"】";
//                AlgoVisHelper.setColor(graphics2D, AlgoVisHelper.Green);
//                AlgoVisHelper.setFont(graphics2D, 30, AlgoVisHelper.Teal);
//                AlgoVisHelper.drawText(graphics2D, desc, canvasWitdh/2 , 20);
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWitdh, canvasHeight);
        }
    }
}
