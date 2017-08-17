/**
 * Created by alayn on 12/12/2016.
 */
public class TreeSet<T extends Comparable<T>> implements Set<T>{
    private TreeNode start,n,temp;
    int count;
    private String string;
    public TreeSet(){
        start = new TreeNode();
        n = start;
        temp = start;
        count = 0;
        string = "{";
    }
    private TreeNode helper(TreeNode t, T element){
        if(t.getLeftChild() == null || t.getRightChild() == null){
            return t;
        }
        if(element.compareTo((T) t.getData()) <= 0){
            return helper(t.getLeftChild(), element);
        }
        else{
            return helper(t.getRightChild(), element);
        }
    }
    @Override
    public boolean add(T element) {
        // Use recursion or tail recursion. May use helper function
        if(string.length() > 1){
            string += ", ";
        }
        if(count == 0){
            start = new TreeNode(element, null,null);
            n = start;
            temp = start;
            count++;
            return true;
        }
        if(element  == null || this.contains(element)){
            return false;
        }
        else{
            TreeNode t = helper(temp, element);
            if(t.getData().compareTo(element) >= 0){
                t.setLeftChild(new TreeNode(element));
            }
            else{
                t.setRightChild(new TreeNode(element));
            }
            string += element.toString();
            count++;
            return true;
        }
    }

    @Override
    public boolean remove(T element) {
        //Should be iterative not recursive
        if(element == null || !this.contains(element)){
            return false;
        }
        else{
            boolean set = false;
            temp = start;
            n = start;
            while(!set){
                if(temp.getData().equals(element)) {
                    if (temp.getLeftChild() != null && temp.getRightChild() == null) {
                        if (n.getLeftChild().equals(temp)) {
                            n.setLeftChild(temp.getLeftChild());
                        }
                        if (n.getRightChild().equals(temp)) {
                            n.setRightChild(temp.getLeftChild());
                        }
                    }
                    if (temp.getLeftChild() == null && temp.getRightChild() != null) {
                        if (n.getLeftChild().equals(temp)) {
                            n.setLeftChild(temp.getRightChild());
                        }
                        if (n.getRightChild().equals(temp)) {
                            n.setRightChild(temp.getRightChild());
                        }
                    }
                    if (temp.getLeftChild() != null && temp.getLeftChild() != null) {
                        if (n.getLeftChild().equals(temp)) {
                            n.setLeftChild(temp.getLeftChild());
                            n.getLeftChild().setRightChild(temp.getRightChild());
                        }
                        if (n.getRightChild().equals(temp)) {
                            n.setRightChild(temp.getRightChild());
                            n.getRightChild().setLeftChild(temp.getLeftChild());
                        }
                    }
                    if (temp.getLeftChild() == null && temp.getRightChild() == null) {
                        n.setRightChild(null);
                        n.setLeftChild(null);
                    }
                    set = true;
                    count--;
                }
                else{
                    if(element.compareTo((T) temp.getData()) == -1){
                        temp = temp.getLeftChild();
                    }
                    else{
                        temp = temp.getRightChild();
                }
//                    String t = "{";
//                    char[] s = string.toCharArray();
//                    for(int i = 0; i<s.length; i++){
//                        if(s[i] != (char) element && i<s.length - 1){
//                            t += (String) element + ", ";
//                        }
//                        if(s[i] != (char) element && i == s.length - 1){
//                            t += (String) element;
//                        }
//                    }
//                    string = t;
                    count--;
                }
                if(element.compareTo((T) temp) == -1 && temp.getLeftChild()!= null){
                    n = temp;
                    temp = temp.getLeftChild();
                }
                if(element.compareTo((T) temp) == 1 && temp.getRightChild() != null){
                    n = temp;
                    temp = temp.getRightChild();
                }
            }
            return true;
        }
    }

    @Override
    public void clear() {
        start = new TreeNode();
        n = start;
        count = 0;
        string = "{";
    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            return false;
        }
        if (n.equals(element)) {
            return true;
        } else {
            boolean eq = false;
            while (!n.equals(element) || n.getLeftChild() != null || n.getRightChild() != null) {
                if (element.compareTo((T) n.getData()) == -1) {
                    if (n.getLeftChild() != null) {
                        n = n.getLeftChild();
                    } else {
                        return false;
                    }
                } else {
                    if (n.getRightChild() != null) {
                        n = n.getRightChild();
                    } else {
                        return false;
                    }
                }
            }
            if (n.equals(element)) {
                return true;
            }
            else{
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
        return string;
    }
    public static void main(String[] args) {
        TreeSet tree = new TreeSet();
        for(int i = 0; i < 6; i++){
            System.out.println("Add " + i + ": " + tree.add(i));
        }
        System.out.println("Add null: " + tree.add(null));
        System.out.println("Remove 2: " + tree.remove(2));
        System.out.println("Remove 10: " + tree.remove(10));
        System.out.println("Contains 1: " +  tree.contains(1));
        System.out.println("Contains 99: " + tree.contains(99));
        System.out.println("Size: " + tree.size());
        System.out.println("Is it empty?: " + tree.isEmpty());
        System.out.println("Clearing the TreeSet");
        tree.clear();
        System.out.println("New size after clearing: " + tree.size());
        System.out.println("Now is it empty?: " + tree.isEmpty());

    }
}
