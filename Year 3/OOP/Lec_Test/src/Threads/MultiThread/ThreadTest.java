package Threads.MultiThread;

public class ThreadTest {
    public static void main(String[] args)
    {
        new A().start();
        new B().start();
        new C().start();
    }
}
