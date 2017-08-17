/**
 * buyss025 on 12/12/2016.
 */
public class HashSet<T extends Comparable<T>> implements Set<T> {
    private T[][] buckets;
    private int count;

    public HashSet(){
        buckets = (T[][]) new Comparable[64][4];
        count = 0;
    }
    public HashSet(int nBuckets){
        buckets = (T[][]) new Comparable[nBuckets][4];
        count = 0;
    }
    private int getBucketIndex(T element){
        return Math.abs(element.hashCode() % buckets.length);
    }

    @Override
    public boolean add(T element) {
        /*Should use the getBucket function to determine which bucket the element
        * belongs in. It should attempt to find an empty slot (with null val) to
        * place the element in. If all the slots are non-null the bucket should
        * be resized to have twice as many slots so the element can be added*/
        if (element == null) {
            return false;
        }
        else {
            boolean t = false;
            for(int i = 0; i<buckets.length; i++){
                for(int j = 0; j<buckets[i].length; j++){
                    if(buckets[i][j]==element){
                        t = true;
                    }
                }
            }
            if(t){
                return false;
            }
            else {
                int ind = getBucketIndex(element);
                int index = buckets[ind].length;
                for(int j = 0; j<buckets[ind].length; j++){
                    if(buckets[ind][j] == null && j<index){
                        index = j;
                    }
                }
                if(index == buckets[ind].length){
                    T[][] temp = (T[][]) new Comparable[buckets.length][buckets[0].length * 2];
                    for(int i = 0; i<buckets.length; i++){
                        for(int j = 0; j<buckets[i].length; j++){
                            temp[i][j] = buckets[i][j];
                        }
                    }
                    buckets = temp;
                }
                buckets[ind][index] = element;
                count++;
                return true;
            }
        }
    }

    @Override
    public boolean remove(T element) {
        //should replace a null at the slot where the element was removed
        if(element == null){
            return false;
        }
        else{
            int ind1 = -1;
            int ind2 = -1;
            for(int i = 0; i<buckets.length; i++){
                for(int j = 0; j<buckets[i].length; j++){
                    if(element==buckets[i][j]){
                        ind1 = i;
                        ind2 = j;
                    }
                }
            }
            if(ind1 == -1 || ind2 == -1){
                return false;
            }
            else {
                buckets[ind1][ind2] = null;
                count--;
                return true;
            }
        }
    }

    @Override
    public void clear() {
        int i = buckets.length;
        int j = buckets[0].length;
        buckets = (T[][]) new Comparable[i][j];
        count = 0;
    }

    @Override
    public boolean contains(T element) {
        if (element == null){
            return false;
        }
        else {
            boolean t = false;
            for(int i = 0; i<buckets.length; i++){
                for(int j = 0; j<buckets[i].length; j++){
                    if(buckets[i][j] == element){
                        t = true;
                    }
                }
            }
            if(t){
                return true;
            }
            else {
                return false;
            }
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }
        else {
            return false;
        }
    }
    public String toString(){
        if(count == 0){
            return "{}";
        }
        if(count == 1){
            T element = null;
            for(int i = 0; i<buckets.length; i++){
                for(int j = 0; j<buckets[i].length; j++){
                    if(buckets[i][j] != null){
                        element = buckets[i][j];
                    }
                }
            }
            return "{" + element + "}";
        }
        else {
            String full = "{";
            String[] f = new String[count];
            int a = 0;
            for(int i = 0; i<buckets.length; i++){
                for(int j = 0; j<buckets[i].length; j++){
                    if(buckets[i][j] != null){
                        f[a++] = (String) buckets[i][j];
                    }
                }
            }
            for(int i = 0; i<f.length-1; i++){
                full += f[i] + "' ";
            }
            full += f[f.length - 1] + "}";
            return full;
        }
    }

    public static void main(String[] args) {
        HashSet hash = new HashSet();
        for(int i = 0; i < 6; i++){
        System.out.println("Add " + i + ": " + hash.add(i));
    }
        System.out.println("Add null: " + hash.add(null));
        System.out.println("Remove 2: " + hash.remove(2));
        System.out.println("Remove 10: " + hash.remove(10));
        System.out.println("Contains 1: " +  hash.contains(1));
        System.out.println("Contains 99: " + hash.contains(99));
        System.out.println("Size: " + hash.size());
        System.out.println("Is it empty?: " + hash.isEmpty());
        System.out.println("Clearing the HashSet");
        hash.clear();
        System.out.println("New size after clearing: " + hash.size());
        System.out.println("Now is it empty?: " + hash.isEmpty());

    }
}
