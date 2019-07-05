package skiplist;

public class NOT_VIP implements Customer {
    @Override
    public String purchase() {
        return "VIP First !";
    }
}