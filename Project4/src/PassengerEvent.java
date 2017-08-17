/**
 * Created by alayn on 11/28/2016.
 */
public class PassengerEvent implements Event {
    private Stop stop;
    public PassengerEvent(Stop stop){
        this.stop = stop;
    }

    @Override
    public void run() {
        String direction;
        Arrival a = new Arrival();
        double arrival = a.getArrival() + BusSim.agenda.getCurrentTime();
        int r = (int) Math.ceil(Math.random() * 2);
        if(r == 1){
            direction = "eastbound";
        }
        else{
            direction = "westbound";
        }
        Passenger p = new Passenger(arrival, stop, direction);
        double t = BusSim.agenda.getCurrentTime();
        int ind = -1;
        for(int i = 0; i<BusSim.s.length; i++){
            if(stop.equals(BusSim.s[i])){
                BusSim.s[i].add(p, direction);
                ind = i;
            }
        }
        PassengerEvent passengerEvent = new PassengerEvent(BusSim.s[ind]);
        Stat.maxWait(p.getServiceTime(t));

        BusSim.agenda.add(passengerEvent, t);
    }
}
