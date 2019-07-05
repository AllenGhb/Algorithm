package skiplist.pass;

public abstract class Passenger {

    abstract void passThroughImmigration();

    public static void main(String[] args) {
        Passenger a = new ChinesePassenger();
        Passenger b = new ForeignerPassenger();
        long current = System.currentTimeMillis();
        for (int i=1; i<=2000000000;i++){
            if(i%100000000 == 0){
                long temp = System.currentTimeMillis();
                System.out.println(temp-current);
                current = temp;
            }
            Passenger c = (i < 1000000000) ? a : b;
            c.passThroughImmigration();
        }
    }

}

class ChinesePassenger extends Passenger {

    @Override
    void passThroughImmigration() {

    }
    void visitDutyFreeShops(){
    }
}

class ForeignerPassenger extends Passenger {
    @Override
    void passThroughImmigration() {

    }
}
