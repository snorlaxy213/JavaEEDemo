package leetcode.DataStruct;

import java.util.ArrayList;
import java.util.List;

public class Queue{
    private List<Integer> queues;
    private int headpoint;

    public Queue() {
        queues = new ArrayList<>();
        headpoint = 0;
    }

    public boolean enqueue(Integer num){
        queues.add(num);
        return true;
    }
    
    public boolean dequeue(){
        if(isEmpty() == false){
            return false;
        }
        headpoint++;
        return true;
    }

    public int current(){
        return queues.get(headpoint);
    }

    public boolean isEmpty(){
        if(headpoint > queues.size()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);

        System.out.println(queue.current());

        queue.dequeue();
        System.out.println(queue.current());

    }

}