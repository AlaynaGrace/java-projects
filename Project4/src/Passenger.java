/**
 * Created by alayn on 11/17/2016.
 */
public class Passenger {
    private double arrival;
    private Stop stop;
    private String direction;
    public Passenger(double arrival, Stop stop, String direction){
        this.arrival = arrival;
        this.direction = direction;

        int d = (int) Math.floor(Math.random() * BusSim.s.length);
        this.stop = BusSim.s[d];
    }
    public double getArrival(){
        return arrival;
    }
    public Stop getStop(){
        return stop;
    }
    public String getDirection(){
        return direction;
    }
    public double getServiceTime(double t){
        return t - arrival;
    }

}
