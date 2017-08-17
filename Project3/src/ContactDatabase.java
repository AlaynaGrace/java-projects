/**
 * Created by buyss025 on 11/1/2016.
 */
public class ContactDatabase {
    private List<Contact> list;

    public ContactDatabase(String type) {
        if (type.equals("array")) {//Checks to see which type of list to use
            list = new ArrayList();
        }
        if (type.equals("linked")) {
            list = new LinkedList();
        }
    }

    public boolean add(Contact c) {
        return list.add(c);
    }//Adds the element to the list

    public Contact find(String name) {
        Contact c = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {//Finds name by checking the contact name in each index spot
                c = list.get(i);
            }
        }
        return c;
    }

    public Contact remove(int index) {
        if (index >= list.size()) {
            return null;
        } else {
            Contact c = list.get(index);
            list.remove(index); //Uses previous remove function
            return c;
        }
    }

    public Contact get(int index) {
        if (index >= list.size()) {
            return null;
        } else {
            return list.get(index);//Gets contact at that index
        }
    }

    public void sort() {
        list.sort(true);
    }//Sorts alphabetically

    public Contact[] getContactsByType(String type) {
        Contact[] c = new Contact[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (type.equals("friend")) { //Checks what type of contact the programmer wants and then returns an array with all those contacts
                if (list.get(i) instanceof Friend) {
                    c[i] = list.get(i);
                }
            }
            if (type.equals("coworker")) {
                if (list.get(i) instanceof Coworker) {
                    c[i] = list.get(i);
                }
            }
            if (type.equals("restaurant")) {
                if (list.get(i) instanceof Restaurant) {
                    c[i] = list.get(i);
                }
            }
        }
        return c;
    }

    public Contact getOldestFriend() {
        Contact c = null;
        int b = 2016117; //Based off todays date
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Friend) {
                Friend f = (Friend) list.get(i);
                if (b > f.getBirthday()) {//Birthday should be larger if they are younger
                    b = f.getBirthday();
                    c = (Contact) f;
                }
            }
        }
        return c;
    }

    public String getMailToLink() {
        String full = "mailto:";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Coworker) {
                Coworker c = (Coworker) list.get(i);
                full += c.getEmail(); //puts all emails together
                if (i < list.size() - 1) {
                    full += ","; //makes sure there isn't a weird end comma
                }
            }
        }
        return full;
    }

    public Contact[] getTopKRestaurants(int k) {
        Contact[] c = null;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Restaurant) {
                count++; //Checks to see how many restaurants there are
            }
        }

        if (k >= count) {
            c = new Contact[count];
            int i = 0;
            int j = 0;
            while (i < c.length) { //Collect all of the restaurants into one array
                if (list.get(j) instanceof Restaurant) {
                    c[i] = list.get(j);
                    i++;
                }
                j++;
            }
        } else {
            c = new Contact[k];
            Contact[] temp = new Contact[count];
            int i = 0, j = 0, max;
            Restaurant r, rest;
            while (i < temp.length) { //Collect all of the restaurants into one array
                if (list.get(j) instanceof Restaurant) {
                    temp[i] = list.get(j);
                    i++;
                }
                j++;
            }
            //Selection sort
            for (i = 0; i < list.size() - 1; i++) {
                r = (Restaurant) temp[i];
                max = i;
                for (j = i + 1; j < temp.length; j++) {
                    rest = (Restaurant) temp[j];
                    if (rest.getRating() > r.getRating()) {
                        r = (Restaurant) temp[j];
                        max = j;
                    }
                }
                c[i] = temp[max];


            }

        }

        return c;
    }

    public static void main(String[] args) {
        ContactDatabase arrayList = new ContactDatabase("array");
        ContactDatabase linkedList = new ContactDatabase("linked");

        System.out.println("Add a contact (arrayList): " + arrayList.add(new Contact()));
        System.out.println("Add a contact (linkedList): " + linkedList.add(new Contact()));

        Contact c1 = new Contact();
        c1.setName("Me");
        arrayList.add(c1);
        linkedList.add(c1);
        System.out.println("Find me (array): " + arrayList.find("Me"));
        System.out.println("Find me (linked):" + linkedList.find("Me"));

        Friend f1 = new Friend("Friend", 6781234, "123 Main St", "None", 19951104);
        Friend f2 = new Friend("BFF", 6781244, "1234 Main St", "None", 19961104);
        arrayList.add(f1);
        linkedList.add(f1);
        arrayList.add(f2);
        linkedList.add(f2);

        Coworker cw1 = new Coworker("Coworker1", 6540987, "123 Main", "None", "coworker1@site.net");
        Coworker cw2 = new Coworker("Coworker2", 9840987, "1234 Main", "None", "coworker2@site.net");
        arrayList.add(cw1);
        linkedList.add(cw1);
        arrayList.add(cw2);
        linkedList.add(cw2);

        Restaurant r1 = new Restaurant("R1", 1234567, "Main st", "None",5);
        Restaurant r2 = new Restaurant("R2", 1234567, "Main st", "None",3);
        Restaurant r3 = new Restaurant("R3", 1234567, "Main st", "None",7);
        arrayList.add(r1);
        linkedList.add(r1);
        arrayList.add(r2);
        linkedList.add(r2);
        arrayList.add(r3);
        linkedList.add(r3);

        System.out.println("Get the third thing: " + arrayList.get(2));
        System.out.println("Get the third thing: " + linkedList.get(2));

        arrayList.sort();
        linkedList.sort();

        System.out.println("Friends:");
        Contact[] c = arrayList.getContactsByType("friend");
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]);
        }
        c = linkedList.getContactsByType("friend");
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]);
        }
        System.out.println("Coworkers:");
        c = arrayList.getContactsByType("coworker");
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]);
        }
        c = linkedList.getContactsByType("coworker");
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]);
        }
        System.out.println("Restaurants:");
        c = arrayList.getContactsByType("restaurant");
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]);
        }
        c = linkedList.getContactsByType("restaurant");
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]);
        }
        System.out.println();

        System.out.println("Oldest friend: " + arrayList.getOldestFriend());
        System.out.println("Oldest friend: " + linkedList.getOldestFriend());
        System.out.println();

        System.out.println("Mailto link: " + arrayList.getMailToLink());
        System.out.println("Mailto Link: " + linkedList.getMailToLink());
        System.out.println();

        System.out.println("Top restaurants:");
        c = arrayList.getTopKRestaurants(2);
        for(int i = 0; i<c.length;i++){
            System.out.println(c[i]);
        }
        c = linkedList.getTopKRestaurants(2);
        for(int i = 0; i<c.length;i++){
            System.out.println(c[i]);
        }
    }
}