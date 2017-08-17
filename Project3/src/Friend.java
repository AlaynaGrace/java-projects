/**
 * Created by buyss025 on 11/6/2016.
 */
public class Friend extends Contact {
    private int birthday;
    private String name;
    private long phone;
    private String address;
    private String comments;

    public Friend(String name, long phone, String address, String comments, int birthday){
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.comments = comments;
        this.birthday = birthday;

    }
    public int getBirthday(){
        return birthday;
    }
    public void setBirthday(int birthday){
        this.birthday = birthday;
    }
    public String toString(){
        return name + "\n" + phone + "\n" + address + "\n" + comments + "\n" + birthday;
    }
}
