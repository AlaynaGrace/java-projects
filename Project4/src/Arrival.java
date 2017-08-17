/**
 * Created by alayn on 11/17/2016.
 */
public class Arrival {
    private int arrival;
    public int getArrival(){
        double[] a = {120+0.75 * 120, 120 + 0.75 * 120, 120 + 0.5 * 120, 120 + 0.5 * 120,
                120 + 0.5 * 120,120 + 0.2 * 120,120 + 0.2 * 120,120 + 0.2 * 120,120 + 0.2 * 120,
        120,120,120 - 0.2 * 120,120 - 0.2 * 120,120 - 0.2 * 120,120 - 0.2 * 120,
                120 - 0.5 * 120,120 - 0.5 * 120,120 - 0.5 * 120,120-0.75 * 120,
                120+0.75 * 120};

        int rand = (int) Math.floor(Math.random() * 20);
        arrival = (int) a[rand];
        return (int) a[rand];
    }


}
