/**
 * Created by buyss025 on 11/6/2016.
 */
public class Restaurant extends Contact {
    private String name;
    private long phone;
    private String address;
    private String comments;
    private int rating;

    public Restaurant(String name, long phone, String address, String comments, int rating){
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.comments = comments;
        this.rating = rating;

    }
    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating = rating;
    }
    public String toString(){
        return name + "\n" + phone + "\n" + address + "\n" + comments + "\n" + rating;
    }
}
