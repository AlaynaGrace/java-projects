/**
 * buyss025
 * Credit: Stat by Dovolis
 */
public class Stat {

    private static int avgFull;
    private static int t;
    private static int fullCount;
    public static void full(int peopleCount){
        ++fullCount;
        t += peopleCount;
        avgFull = t/fullCount;
    }
    private static double maxWait = 0;
    public static void maxWait(double waitTime){
        if(waitTime>maxWait){
            maxWait = waitTime;
        }
    }
    private static int maxQueueLength = 0;
    public static void maxQueue(int queueLength){
        if(queueLength> maxQueueLength){
            maxQueueLength = queueLength;
        }
    }

    public static void displayStats(){
        System.out.println("Bus Simulation Results");
        System.out.println("Number of buses: " + BusSim.b.length);
        System.out.println("Size of buses: " + BusSim.busSize);
        System.out.println("Average fullness of buses: " + avgFull);
        System.out.println("Maximum wait time: " + maxWait);
        System.out.println("Max queue length: " + maxQueueLength);

    }
}
