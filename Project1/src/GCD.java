/**
 * Created by alayn on 9/27/2016.
 */
public class GCD {
    private static int small;
    public static int greatest(int a, int b){
        int great;
        if(a<=0 || b<=0){
            System.out.println("Error. Please enter positive nonzero numbers.");
            return 0;
        }
        if(a == b){
            great = a;
        }

        great = 1;
        if(a > b){
            if(a%b == 0){
                great = b;
            }
            else{
                return greatest(a, b-1);
            }
        }
        if(a < b){
            if(b%a == 0){
                great = a;
            }
            else{
                return greatest(a-1, b);
            }
        }
        System.out.println(great);
        return great;
    }
    public static void main(String[] args){
        LCM l = new LCM();
        System.out.println("GCD: " + greatest(11,11) + " LCD: " + l.lowest(11,11));
        System.out.println("GCD: " + greatest(2,4) + " LCD: " + l.lowest(2,4));
        System.out.println("GCD: " + greatest(-1,0) + " LCD: " + l.lowest(-1,0));
        System.out.println("GCD: " + greatest(100,200) + " LCD: " + l.lowest(100,200));
        System.out.println("GCD: " + greatest(125,50) + " LCD: " + l.lowest(125,50));

    }
}
