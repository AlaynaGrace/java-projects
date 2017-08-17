/**
 * Created by buyss025 on 11/6/2016.
 */
public class Coworker extends Contact {
    private String email;
    private String name;
    private long phone;
    private String address;
    private String comments;

    public Coworker(String name, long phone, String address, String comments, String email){
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.comments = comments;
        this.email = email;

    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String toString(){
        return name + "\n" + phone + "\n" + address + "\n" + comments + "\n" + email;
    }
}
