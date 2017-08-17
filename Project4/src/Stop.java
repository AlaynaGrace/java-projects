/**
 * Created by alayn on 11/17/2016.
 */
public class Stop {
    private N startE,startW,nE,nW;
    private int lengthE, lengthW;
    private String stopName;
    public Stop(String name){
        startE = new N();
        startW = new N();
        nE = startE;
        nW = startW;
        lengthE = 0;
        lengthW = 0;
        stopName = name;


    }
    public void add(Passenger p, String direction){
        if(p == null){
            throw new RuntimeException("Object is null");
        }
        else{
            if(direction.equals("eastbound")){
                nE.setNext(new N(p,null));
                nE = nE.getNext();
                lengthE++;
            }
            else{
                nW.setNext(new N(p,null));
                nW = nW.getNext();
                lengthW++;
            }
        }
    }
    public Passenger remove(String direction){
        if(direction.equals("eastbound")){
            if(lengthE == 0){
                throw new RuntimeException("East line is empty");
            }
            else{
                N temp = startE.getNext();
                if(startE.getNext()!= null) {
                    startE.setNext(startE.getNext());
                }//Null pointer exception
                else{
                    startE.setNext(null);
                }
                return (Passenger) temp.getData();
            }
        }
        else{
            if(lengthW == 0){
                throw new RuntimeException("West line is empty");
            }
            else{
                N temp = startW.getNext();
                startW.setNext(startW.getNext());
                return (Passenger) temp.getData();
            }
        }

    }
    public String getName(){
        return stopName;
    }
    public boolean isEastEmpty(){
        if(lengthE == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isWestEmpty(){
        if(lengthW == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
