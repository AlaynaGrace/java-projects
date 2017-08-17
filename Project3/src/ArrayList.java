/**
 * Created by buyss025 on 11/1/2016.
 */
//use .equals instead of ==
public class ArrayList<T extends Comparable<T>> implements List<T> {
    private T[] list;
    public ArrayList(){
        list = (T[]) new Comparable[2];
    }
    private void grow(){
        T[] temp = (T[]) new Comparable[list.length * 2];
        for(int i = 0; i<list.length; i++){
            temp[i] = list[i];
        }
        list = temp;
    }
    @Override
    //always grows the array, causing memory error. Missing break in for loop.
    public boolean add(T element) {
        if(element == null){ //Checks to see if element is null
            return false;
        }
        else {
            int i;
            for(i = 0; i<list.length; i++){
                if(list[i] == null){
                    list[i] = element;
                }
            }

            if (i == list.length) {
                grow(); //grows list to be twice as long then adds element
                list[i] = element;
                return true;
            } else {
                list[i] = element;
                return true;
            }
        }
    }

    @Override
    //Causes incorrect size()
    public boolean add(int index, T element) {
        T temp;
        if(element == null || index<0){
            return false;
        }
        if(index>=list.length){ //One place said to return false and one place said to grow the list
            grow();
            list[index] = element;
            return true;
        }
        else{
            if(list[list.length - 1] != null){
                grow();
            }
            for(int i = index; i<list.length -1; i++){
                temp = list[i];
                list[i] = element;
                element = temp;
            }
            return true;
        }
    }

    @Override
    public void clear() {
        list = (T[]) new Comparable[2];
    } //Makes the list an empty array of length 2

    @Override
    //Contains(null) can be true
    public boolean contains(T element) {
        boolean tf = false;
        for(int i = 0; i<list.length; i++){
            if(list[i] == element){//checks everything to see if it is the element
                tf = true;
            }
        }
        return tf;
    }

    @Override
    public T get(int index) {
        if(index<0 || index>= list.length){
            return null;
        }
        else{
            return list[index]; //returns the value at the index if the index is valid
        }
    }

    @Override
    public int indexOf(T element) {
        int index = -1;
        for(int i = 0; i<list.length; i++){
            if(list[i] == element){
                if(index == -1){ //Used so that it only goes through once and not multiple times
                    index = i;
                }
            }
        }
        return index;
    }

    @Override
    public boolean isEmpty() {
        int count = 0;
        for(int i = 0; i<list.length; i++){
            if(list[i] != null){//Checks to see how many things are null
                count++;
            }
        }
        if (count > 0) {
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public int lastIndexOf(T element) {
        int index = -1;
        for(int i = 0; i<list.length; i++){
            if(list[i] == element){//Opposite of before. Keeps taking in the index of the element at each spot
                index = i;
            }
        }
        return index;
    }

    @Override
    public T set(int index, T element) {
        if(index<0 || index>=list.length){
            return null;
        }
        else{
            T prev = list[index]; //Holds onto previous value so that it can be returned
            list[index] = element;
            return prev;
        }
    }

    @Override
    public int size() {
        int count = 0;
        for(int i = 0; i<list.length; i++){
            if(list[i] != null){
                count++;
            }
        }
        return count; //Finds length without null items
    }

    @Override
    public void sort(boolean order) { //Uses selection sort
        T temp;
        int i,j,mIndex;
        if(order){
            for(i = 0; i<list.length -1; i++){
                mIndex = i;
                for(j=i+1; j<list.length; j++){
                    if(list[j].compareTo(list[mIndex]) < 0){
                        mIndex = j;
                    }
                }
                temp = list[mIndex];
                list[mIndex] = list[i];
                list[i] = temp;
            }

        }
        else{
            for(i = 0; i<list.length -1; i++) {
                mIndex = i;
                for (j = i + 1; j < list.length; j++) {
                    if (list[j].compareTo(list[mIndex]) > 0) {
                        mIndex = j;
                    }
                }
                temp = list[mIndex];
                list[mIndex] = list[i];
                list[i] = temp;
            }
        }
    }

    @Override
    public boolean remove(T element) {
        if(contains(element)){
            int index = indexOf(element);
            for(int i = index + 1; i<list.length; i++){
                list[i - 1] = list[i]; //Finds element and removes it while moving everything forward
            }
            list[list.length - 1] = null;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public T remove(int index) {
        T temp;
        if(index<0 || index >= list.length){
            temp = null;
        }
        else {
            temp = list[index]; //Same as before but finds the element using the index
            for (int i = index + 1; i < list.length; i++) {
                list[i - 1] = list[i];
            }
            list[list.length - 1] = null;
        }
        return temp;
    }

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        System.out.println("1st add 0: " + a.add(0));
        System.out.println("2nd add 1: " + a.add(1));
        System.out.println("Add null: " + a.add(null));
        System.out.println("3rd add 2: " + a.add(2));
        System.out.println();
        System.out.println("Add 3 at index 3: " + a.add(3,3));
        System.out.println("Add null to index 4: " + a.add(4,null));
        System.out.println();
        System.out.println("Is the list empty?: " + a.isEmpty());
        a.clear();
        System.out.println("Is it empty now?: " + a.isEmpty());
        System.out.println();
        System.out.println("Does the list contain 3?: " + a.contains(3));
        for(int i = 0; i<4; i++){
            a.add(i,i);
        }
        System.out.println("Now does the list contain 3?: " + a.contains(3));
        System.out.println();
        System.out.println("What is at index 2?: " + a.get(2));
        System.out.println();
        a.add(3,0);
        System.out.println("First time we see 0?: " + a.indexOf(0));
        System.out.println("Last time we see 0?: " + a.lastIndexOf(0));
        System.out.println();
        System.out.println("Replacing the first thing with 1");
        System.out.println("What was previously at index = 0?: " + a.set(0,1));
        System.out.println();
        System.out.println("What is the size?: " + a.size()); //There were 4 things but then I added 3 to the beginning so then the array doubled and now there are 5 things
        System.out.println();
        for(int i = 0; i<8; i++){
            a.set(i,i);
        }
        System.out.println("Current order:");
        for(int i = 0; i<8; i++){
            System.out.println(a.get(i));
        }
        System.out.println("Decreasing order:");
        a.sort(false);
        for(int i = 0; i<8; i++){
            System.out.println(a.get(i));
        }
        System.out.println("Increasing order:");
        a.sort(true);
        for(int i = 0; i<8; i++){
            System.out.println(a.get(i));
        }
        System.out.println("Remove 1: " + a.remove(1));
        System.out.println("Remove thing at index 7: " + a.remove(8));




    }
}
