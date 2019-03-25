package sync.extthread.t6;

public class MyThread extends Thread{

     public static int count;

    synchronized private static void addCount(){
        System.out.println("start=" + Thread.currentThread().getName() + " " + count);
        for(int i=0;i<100;i++){
            count++;
        }
        System.out.println("end=" + Thread.currentThread().getName()  + " " + count);
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        MyThread[] myThreadArray = new MyThread[100];
        for(int i= 0; i< 100;i++){
            myThreadArray[i] = new MyThread();
        }
        for(int i=0;i<100;i++){
            myThreadArray[i].start();
        }
    }
}
