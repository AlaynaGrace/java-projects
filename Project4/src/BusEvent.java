/**
 * Created by alayn on 11/28/2016.
 */
public class BusEvent implements Event {
    private Bus bus;
    private Stop stop;
    private int ind = 0;
    public BusEvent(Bus bus, Stop stop){
        this.bus = bus;
        this.stop = stop;
    }
    @Override
    public void run() {
        //Need to go westbound when going westbound and go eastbound when yeah
         //changes direction
        Stop s = stop;


        for(int i = 0; i<BusSim.stops.length; i++){
            if(s.equals(BusSim.s[i])){
                ind = i;
            }
        }
        if(BusSim.swap){

            while(!BusSim.s[ind].isEastEmpty() && !bus.isFull()){
                bus.addPassenger(BusSim.s[ind].remove("eastbound"));
            }
            for(int i = 0; i<bus.getPassengers().length; i++){
                if(bus.getPassengers()[i]!=null){
                    if(bus.getPassengers()[i].getStop() == stop){
                        bus.removePassengersAtStop(stop);
                    }
                }

            }

        }
        else{

            while(!BusSim.s[ind].isWestEmpty() && !bus.isFull()){
                bus.addPassenger(BusSim.s[ind].remove("westbound"));
            }
            for(int i = 0; i<bus.getPassengers().length; i++){
                if(bus.getPassengers()[i]!=null){
                    if(bus.getPassengers()[i].getStop() == stop){
                        bus.removePassengersAtStop(stop);
                    }
                }

            }
        }
        if(ind == 0){
            BusSim.swap = true;

        }
        if(ind == BusSim.s.length - 1){
            BusSim.swap = false;
        }
        if(BusSim.swap){
            ind++;
        }
        else{
            ind--;
        }
        s = BusSim.s[ind];
        BusSim.stat.maxQueue(bus.getCount());
    }
}
