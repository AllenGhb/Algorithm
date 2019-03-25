package sync.extthread.t4;


public class ThreadB extends Thread {

    private ObjectService objectService;

    public ThreadB(ObjectService objectService) {
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethod();
    }
}
