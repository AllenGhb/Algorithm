package sync.extthread.t2;

public class HasSelfPrivateNum {

    private int num = 0;
    public void addI(String username){
        try{
            if(username.equals("a")){
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            }else{
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" +num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA aThread = new ThreadA(numRef);
        aThread.start();
        ThreadB bThread = new ThreadB(numRef);
        bThread.start();

    }
}
