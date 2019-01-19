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
    private Object data;
    public void render(Object data){
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

            Graphics2D g2d = (Graphics2D) g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            //具体绘制
            //TODO: 绘制自己的数据data
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWitdh, canvasHeight);
        }
    }
}
