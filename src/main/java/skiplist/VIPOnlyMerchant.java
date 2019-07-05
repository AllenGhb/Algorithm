package skiplist;

public  class VIPOnlyMerchant extends MerchantOther<VIP> {
    @Override
    public double actionPrice(double price, VIP customer) {
        return price * 0.07;
    }
}
