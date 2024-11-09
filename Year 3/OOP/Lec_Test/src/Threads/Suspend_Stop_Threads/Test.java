package Threads.Suspend_Stop_Threads;

public class Test {
    public static void main(String[] args) {
        MyThread mythread = new MyThread();

        Thread t = new Thread(mythread);
        t.start();

        try{
            Thread.sleep(1000); // t is running

            mythread.mySuspend(); // suspend the thread
            System.out.println("Suspending thread");
            Thread.sleep(1000);

            mythread.myResume(); // resume the thread
            System.out.println("Resuming thread");
            Thread.sleep(1000);

            mythread.mySuspend(); // suspend again the thread
            System.out.println("Suspending thread");
            Thread.sleep(1000);

            mythread.myResume(); // resume the thread
            System.out.println("Resuming thread");
            Thread.sleep(1000);

            //stopping thread
            mythread.myStop();
        }
        catch(InterruptedException e){
            System.out.println("Main thread interrupted");
        }

        System.out.println("Main thread exiting");
    }


}
