package threegates;

/**
 * @ClassName ThreeGatesExperiment
 * @Author PerfySchu
 * @Date 2019/1/23 13:23
 * @Version 1.0
 **/
public class ThreeGatesExperiment {
    private int N;

    public ThreeGatesExperiment(int N){
        if(N <= 0){
            throw new IllegalArgumentException( "N must be lager than zero");
        }

        this.N = N;
    }

    public void run(boolean changeDoor){
        int wins = 0;
        for(int i=0; i<N; i++){
            if(play(changeDoor)){
                wins ++;
            }
        }
        System.out.println(changeDoor?"change":"not change");
        System.out.println("winning rate : " + (double)wins/N);
    }

    private boolean play(boolean changeDoor){
        //Door 0, 1, 2
        int prizeDoor = (int)(Math.random() * 3);
        int playerChoice = (int)(Math.random() * 3);

        if(playerChoice == prizeDoor){
            return changeDoor?false:true;
        }else {
            return changeDoor?true:false;
        }
    }

    public static void main(String[] args) {
        int N = 1000000;
        ThreeGatesExperiment threeGatesExperiment = new ThreeGatesExperiment(N);
        threeGatesExperiment.run(true);
        System.out.println();
        threeGatesExperiment.run(false);
    }
}
