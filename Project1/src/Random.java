import java.util.Scanner;

/**
 * Created by alayn on 9/27/2016.
 */
public class Random {
    private static int nextRand;
    private static int prevRand;
    private int mod;
    private int pp1;
    private int pp2;
    public Random(int p1, int p2, int m){
        prevRand = 0;
        mod = m;
        pp1 = p1;
        pp2 = p2;
        nextRand = ((pp1 * prevRand) + pp2) % mod;
    }
    public void setSeed(int seed){

        prevRand = seed;
    }
    public int getMaximum(){
        System.out.println(mod);
        return mod;
    }
    public int getRandom(){
        int newRand = ((pp1 * prevRand) + pp2) % mod;
        prevRand = nextRand;
        System.out.println(nextRand);
        return newRand;
    }
    public int getRandomInteger(int lower, int upper){
        int l = lower;
        int u = upper;
        if(lower > upper){
            l = upper;
            u = lower;
        }
        mod = u+2;
        nextRand =((pp1 * prevRand) + pp2 ) % mod;
//       while(nextRand < l || nextRand > u){
//            nextRand= 1 + -1 * ((pp1 * prevRand) + pp2) % mod;
//       }
        int t = getRandom();
        int nRand = 0;
        if(t%2 == 0){
            nRand = -1 * nextRand;
        }
        else{
            nRand = nextRand;
        }
        if(nRand == u+1){
            nRand = nRand - 1;
        }
        if(nRand == l-1){
            nRand += 1;
        }
        prevRand = nextRand;
        System.out.println(nRand);
        return nRand;
    }
    public boolean getRandomBoolean(){
        boolean tf = false;
        nextRand = ((pp1 * prevRand) + pp2) % mod;
        if(nextRand%2 == 0){
            tf = true;
        }
        else{
            tf = false;
        }
        return tf;
    }
    public int getRandomItem(int[] array){
        mod = array.length;
        nextRand = ((pp1 * prevRand) + pp2) % mod;
        return array[nextRand];
    }
    public int[] getRandomIntegerArray(int n, int lower, int upper){
        int l = lower;
        int u = upper;
        if(lower > upper){
            l = upper;
            u = lower;
        }
        mod = u;
        int[] array = new int[n];
        for(int i = 0; i<n; i++){
            nextRand = ((pp1 * prevRand) + pp2) % mod;
            array[i] = nextRand;
        }
        return array;
    }
    public double getRandomDouble(double lower, double upper){
        double l = lower;
        double u = upper;
        if(lower> upper){
            l = upper;
            u = lower;
        }
        double x = u;
        double newRand;
        newRand = ((pp1 * prevRand) + pp2) % x;
        return newRand;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a seed: ");
        String input = scanner.nextLine();
        Scanner s = new Scanner(input);
        int seed = s.nextInt();
        Prime p = new Prime();
        Random rand = new Random(p.getPrime(250),p.getPrime(450),5);
        rand.setSeed(seed);
        for(int i = 0;i<100; i++) {
            rand.getRandomInteger(-5,5);
        }
    }
}
