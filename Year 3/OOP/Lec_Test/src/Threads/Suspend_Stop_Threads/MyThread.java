package Threads.Suspend_Stop_Threads;

public class MyThread implements Runnable{
    boolean stopped;
    boolean suspended;

    public MyThread(){
        this.stopped = false;
        this.suspended = false;
    }

    public void run(){
        System.out.println("My thread is starting");
        try{
            for(int i = 0; i < 1000; i++) {
                System.out.println(i);
                Thread.sleep(500);
                synchronized (this) {
                    while (suspended)
                        wait();
                }
                if (stopped)
                    break;
            }
        }
        catch (InterruptedException e){
            System.out.println("My thread is interrupted");
        }
        System.out.println("My thread is exiting");
    }

    synchronized void myStop(){
        stopped = true;
        suspended = false;
        notify();
    }

    synchronized void mySuspend(){
        suspended = true;
    }

    synchronized void myResume(){
        suspended = false;
        notify();
    }
}
