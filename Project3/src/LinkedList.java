/**
 * Created by buyss025 on 11/1/2016.
 */
public class LinkedList<T extends Comparable<T>> implements List<T> {
    private int index;
    private Node n, start;
    private int length;
    public LinkedList(){
        n = new Node();
        start = n;
        length = 0;
    }
    @Override
    public boolean add(T element) {
        if(element == null){
            return false;
        }
        else{
            Node node = new Node(element,null);//Adds new node in line with new element
            n.setNext(node);
            n = node;
            length++;
           return true;
        }
    }

    @Override
    public boolean add(int index, T element) {
        if(element == null || index>length || index<0) {
            return false;
        }
        else{
            int count = 0;
            n = start;
            while(count<index+1){
                n = n.getNext(); //Goes through the list index many times
                count++;
            }
            Node next = n.getNext();
            n.setNext(new Node(element,next));
            length++;
            return true;
        }
    }

    @Override
    public void clear() {
        length = 0;
        n = new Node(); //Starts everything over
        start = n;
    }

    @Override
    public boolean contains(T element) {
        int count = 0;
        boolean tf = false;
        n = start;
        while(count<length){
            n = n.getNext();
            if(n.getData() == element){//Indexes through list to find element
                tf = true;
            }
            else{
                tf = false;
            }
        }
        return tf;
    }

    @Override
    public T get(int index) {
        int count = 0;
        n = start;
        if(index<0 || index>length){
            return null;
        }
        else {
            while (count < index + 1) {
                n = n.getNext(); //Goes through index many times to find the element
            }
            return (T) n.getData();
        }
    }

    @Override
    public int indexOf(T element) {
        int index = -1;
        int count = 0;
        T data = null;
        n = start;
        while(count<=length || index<0){
            data = (T) n.getData();
            if(data == element){
                index = count; //counts how many times it needs to get check each thing in the list to find the index
            }
            else{
                n = n.getNext();
            }
            count++;
        }
        return index;
    }

    @Override
    public boolean isEmpty() {
        if(length == 0){//Checks length to see if it is empty
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int lastIndexOf(T element) {
        int index = -1;
        int count = 0;
        T data = null;
        n = start;
        while(count<=length){
            data = (T) n.getData();
            if(data == element){
                index = count;
                n = n.getNext();//Same as before but keeps updating count
            }
            else{
                n = n.getNext();
            }
            count++;
        }
        return index;
    }

    @Override
    public T set(int index, T element) {
        int count = 0;
        n = start;
        T data = null;
        if(index<0 || index>length || element == null){
            return null;
        }
        else {
            while(count<=index){
                n = n.getNext(); //Indexes through list and sets the data while holding onto the previous element that was there
            }
            data = (T) n.getData();
            n.setData(element);
            return data;
        }
    }

    @Override
    public int size() {
        return length; //The size is the length
    }

    @Override
    public void sort(boolean order) {
        T[] list = (T[]) new Comparable[length];
        n = start;
        n = n.getNext();
        for(int i = 0; i<length; i++){ //Put everything into an array to make things easier
            list[i] = (T) n.getData();
            n = n.getNext();
        }
        //Selection sort
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
        start = new Node();
        n = start;
        for(i = 0; i<length; i++){
            n.setNext(new Node(list[i])); //Takes everything out of array and makes a linked list out of it
            n = n.getNext();
        }

    }

    @Override
    public boolean remove(T element) {
        int count = 0;
        n = start;
        boolean b = false;
        while(count<=length){
            Node d = n;
            if(n.getNext().getData() == element){
                Node next = n.getNext(); //Finds element and removes it. Relinks everything
                d.setNext(next);
                count = length + 1;
                b = true;
            }
            else{
                count++;
                b = false;
            }
        }
        return b;
    }

    @Override
    public T remove(int index) {
        T data = null;
        int count = 0;
        n = start;
        if(index<0 || index>length){
            return null;
        }
        else {
            while(count<index){
                n = n.getNext();
            }
            data = (T) n.getNext().getData();
            Node d = n.getNext().getNext();
            n.setNext(d);
            return data;
        }
    }
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
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
        System.out.println("What is the size?: " + a.size());
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
