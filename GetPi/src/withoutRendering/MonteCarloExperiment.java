package withoutRendering;

import java.awt.*;

/**
 * shiyong
 * @ClassName MonteCarloExperiment
 * @Author PerfySchu
 * @Date 2019/1/22 13:16
 * @Version 1.0
 **/
public class MonteCarloExperiment {
    private int squareSide;
    private int N;
    private int interval = 100;

    public MonteCarloExperiment(int squareSide, int N){
        if(squareSide <=0 || N <= 0){
            throw new IllegalArgumentException("squareSide and N must larger than 0");
        }

        this.squareSide = squareSide;
        this.N = N;
    }

    public void setInterval(int interval){
        if(interval <= 0){
            throw new IllegalArgumentException("interval can not less than 0");
        }
        this.interval = interval;
    }

    public void run(){
        Circle circle = new Circle(squareSide/2, squareSide/2, squareSide/2);
        MonteCarloPiData data = new MonteCarloPiData(circle);

        for(int i=0; i<N; i++){
            if(i % interval == 0){
                System.out.println(data.estimatePi());
            }
            int x = (int) (Math.random() * squareSide);
            int y = (int) (Math.random() * squareSide);
            data.addPoint(new Point(x, y));
        }
    }

    public static void main(String[] args) {
        int squareSide = 100;
        int N = 1000000;

        MonteCarloExperiment experiment = new MonteCarloExperiment(squareSide, N);
        experiment.setInterval(1000);
        experiment.run();
    }
}
