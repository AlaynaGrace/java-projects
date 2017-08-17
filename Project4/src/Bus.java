/**
 * Created by alayn on 11/28/2016.
 */
public class Bus {
    private int count;
    private Passenger[] passengers;
    private Stop stop;
    public Bus(int size, Stop stop){
        count = 0;
        this.stop = stop;
        passengers = new Passenger[size - 1];
    }
    public boolean addPassenger(Passenger p){
        if(count==passengers.length){
            return false;
        }
        else{
            passengers[count] = p;
            count++;
            return true;
        }
    }
    public Stop getStop(){
        return stop;
    }
    public Passenger[] getPassengers(){
        return passengers;
    }
    public int getCount(){
        return count;
    }
    public Passenger[] removePassengersAtStop(Stop stop){
        int j = 0;
        int c = 0;
        for(int i = 0; i<passengers.length; i++){
            if(passengers[i].getStop().equals(stop)){
                c++;
            }
        }
        Passenger[] p = new Passenger[c];
        for(int i = 0; i<passengers.length; i++){
            if(passengers[i].getStop().equals(stop)){
                p[j] = passengers[i];
                passengers[i] = null;
                count--;
                j++;
            }
        }
        Passenger[] temp = new Passenger[passengers.length];
        j = 0;
        for(int i = 0; i<passengers.length; i++){
            if(passengers[i]!=null){
                temp[j] = passengers[i];
                j++;
            }
        }
        passengers = temp;

        return p;
    }
    public boolean isFull() {
        if(count == passengers.length){
            return true;
        }
        else{
            return false;
        }
    }
}
