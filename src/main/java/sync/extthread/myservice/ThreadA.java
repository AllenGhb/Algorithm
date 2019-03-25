package sync.extthread.myservice;

public class ThreadA extends Thread {

    private  MyService service;

    public ThreadA(MyService myService){
        super();
        this.service = myService;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
