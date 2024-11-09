package Threads.ThreadStop;

public class ThreadToStop extends Thread{
    private boolean exit = false;

    public void run(){
        while(!exit){
            System.out.println("Thrad is running...");
        }
        System.out.println("Thread is stopped!");
    }

    public void stopThread(){
        exit = true;
    }
}
