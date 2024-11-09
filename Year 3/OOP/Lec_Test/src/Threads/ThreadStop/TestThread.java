package Threads.ThreadStop;

public class TestThread {
    public static void main(String[] args) throws InterruptedException{
        ThreadToStop thread = new ThreadToStop();
        thread.start();
        Thread.sleep(1000);
        thread.stopThread();
    }
}
