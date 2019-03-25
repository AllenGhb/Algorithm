package sync.extthread.t7;

public class MyThread extends Thread {

    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.addNum();
    }

    public static void main(String[] args) {
        try{
            MyService service = new MyService();
            MyThread[] array = new MyThread[5];
            for(int i=0;i<array.length;i++){
                array[i] = new MyThread(service);
            }
            for(int i = 0;i< array.length;i++){
                array[i].start();
            }
            Thread.sleep(1000);
            System.out.println(service.aiRef.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
