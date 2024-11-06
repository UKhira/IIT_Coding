package Exercise8;

public class Main {
    public static <T> void main(String[] args) {
        Queue newQueue = new Queue<>(5);
        newQueue.enQueue("a");
        newQueue.enQueue("b");
        newQueue.enQueue("c");
        newQueue.enQueue("e");
        newQueue.enQueue("f");

        System.out.println((T) newQueue.toString());
    }
}
