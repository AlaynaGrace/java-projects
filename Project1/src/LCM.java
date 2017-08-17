/**
 * Created by alayn on 9/27/2016.
 */
public class LCM {
    public static int lowest(int a, int b) {
        int lcm = 0;
        if(a<=0 || b<=0){
            System.out.println("Error. Please input positive nonzero numbers.");
            return 0;
        }
        if(a < b){
            for(int i = 1; i <= b*a; i++){
                if(i%a == 0 && i%b == 0){
                    lcm = i;
                    break;
                }
            }
        }
        if(a > b){
            for(int i = 1; i <= a*b; i++){
                if(i%a == 0 && i%b == 0){
                    lcm = i;
                    break;
                }
            }
        }
        if(a == b){
            lcm = a;
        }
        System.out.println(lcm);
        return lcm;
    }
    public static void main(String[] args){
        GCD g = new GCD();
        System.out.println("GCD: " + g.greatest(11,11) + " LCD: " + lowest(11,11));
        System.out.println("GCD: " + g.greatest(2,4) + " LCD: " + lowest(2,4));
        System.out.println("GCD: " + g.greatest(-1,0) + " LCD: " + lowest(-1,0));
        System.out.println("GCD: " + g.greatest(100,200) + " LCD: " + lowest(100,200));
        System.out.println("GCD: " + g.greatest(125,50) + " LCD: " + lowest(125,50));
    }
}
