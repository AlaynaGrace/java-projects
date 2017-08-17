/**
 * Created by alayn on 9/27/2016.
 */
public class Prime {
    public static boolean isPrime(int number){
        boolean tf = true;
        for(int i = 2; i<number; i++){
            if(number%i == 0){
                tf = false;
            }
            else{
                tf = true;
            }
        }
        return tf;
    }
    public static int getPrime(int n){
        int prime = 0;
        if(n==1){
            prime = 2;
            System.out.println(prime);
            return 2;
        }
        else {
            int count = 0;
            while (count<n) {
                for (int i = 2;; i++) {
                    int c2 = 0;

                    for (int j = 1; j < i; j++) {
                        if (i % j == 0) {
                            c2 += 1;
                        }
                    }
                    if(c2 == 1){
                        count += 1;
                        prime = i;
                        if(count == n){
                            break;
                        }
                    }

                }
            }
        }
        System.out.println(prime);
        return prime;
    }
    public static int[] getPrimeArray(int n){
        int[] a = new int[n];
        for(int i = 0; i<a.length; i++){
            a[i] = getPrime(n);
        }
        return a;
    }
    public static void main(String[] args){
        Prime p1 = new Prime();
        for(int i = 1; i<=100; i++){
            getPrime(i);
        }
    }
}

