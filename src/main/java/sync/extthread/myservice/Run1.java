package sync.extthread.myservice;

public class Run1 {

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        ThreadB b = new ThreadB(myService);
        b.setName("B");
        a.start();
        Thread.sleep(50);
        b.start();
    }

}
