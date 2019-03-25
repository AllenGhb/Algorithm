package sync.extthread.myservice;

public class ThreadB extends Thread {

    private  MyService service;

    public ThreadB(MyService myService){
        super();
        this.service = myService;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
