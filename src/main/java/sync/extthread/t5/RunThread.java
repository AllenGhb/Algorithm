package sync.extthread.t5;


public class RunThread extends Thread {

    volatile private  boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while(isRunning == true){
        }
        System.out.println("线程被停止了！");
    }

    public static void main(String[] args) {
        try{
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(2000);
            thread.setRunning(false);
            System.out.println("赋值为false");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
