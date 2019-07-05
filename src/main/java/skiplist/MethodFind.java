package skiplist;


public class MethodFind {

    public static void main(String[] args) {
        MerchantOther merchantOther = new VIPOnlyMerchant();
        merchantOther.actionPrice(80, new VIP());
        merchantOther.actionPrice(90, new NOT_VIP());

    }
}
