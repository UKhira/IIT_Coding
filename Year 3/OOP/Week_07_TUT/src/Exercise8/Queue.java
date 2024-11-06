package Exercise8;

import java.util.ArrayList;

public class Queue<T>{
    private int maxSize;
    private ArrayList<T> queue;

    public Queue(int size){
        this.maxSize = size;
    }

    public void enQueue(T value){
        this.queue.addLast(value);
    }

    public void deQueue(){
        this.queue.removeFirst();
    }

    public String toString(){
        return queue.toString();
    }
}
