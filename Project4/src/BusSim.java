/**
 * Created by alayn on 11/28/2016.
 */
public class BusSim {
    public static PQ agenda = new PQ();
    public static String[] stops = {"University Ave and 27th Street SE", "Raymond Ave Station",
            "University Ave and Fairview Ave", "University Ave and Snelling Ave",
            "University Ave and Lexington Parkway","University Ave and Dale Street",
            "University Ave and Marion Street", "Cedar Street and 5th Street",
            "Minnesota Street and 4th Street", "Union Depot"};
    public static Stop[] s = {new Stop(stops[0]), new Stop(stops[1]), new Stop(stops[2]),
                                new Stop(stops[3]), new Stop(stops[4]), new Stop(stops[5]),
                                new Stop(stops[6]), new Stop(stops[7]), new Stop(stops[8]),
                                new Stop(stops[9])};
    public static boolean swap = true;
    public static int busSize = 40;
    public static int numBuses = 2;
    public static Bus[] b = {new Bus(busSize,s[0]),new Bus(busSize,s[s.length-1]),new Bus(busSize,s[0])};
    public static Stat stat = new Stat();
    public static void main(String[] args) {
        PassengerEvent p0 = new PassengerEvent(s[0]);
        PassengerEvent p1 = new PassengerEvent(s[1]);
        PassengerEvent p2 = new PassengerEvent(s[2]);
        PassengerEvent p3 = new PassengerEvent(s[3]);
        PassengerEvent p4 = new PassengerEvent(s[4]);
        PassengerEvent p5 = new PassengerEvent(s[5]);
        PassengerEvent p6 = new PassengerEvent(s[6]);
        PassengerEvent p7 = new PassengerEvent(s[7]);
        PassengerEvent p8 = new PassengerEvent(s[8]);
        PassengerEvent p9 = new PassengerEvent(s[9]);

        BusEvent busEvent = new BusEvent(b[0],s[0]);
        BusEvent busEvent2 = new BusEvent(b[1],s[s.length-1]);
        BusEvent busEvent3 = new BusEvent(b[2], s[0]);
        agenda.add(busEvent3, 200);


        agenda.add(p0, 120);
        agenda.add(p1, 120);
        agenda.add(p2, 120);
        agenda.add(p3, 120);
        agenda.add(p4, 120);
        agenda.add(p5, 120);
        agenda.add(p6, 120);
        agenda.add(p7, 120);
        agenda.add(p8, 120);
        agenda.add(p9, 120);

        agenda.add(busEvent, 180);
        agenda.add(busEvent2, 180);

        while(agenda.getCurrentTime() <= 10000){
            agenda.remove().run();
        }
        Stat.displayStats();
    }
}
