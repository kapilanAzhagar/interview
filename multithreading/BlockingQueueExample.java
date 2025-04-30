package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer implements Runnable{
    private BlockingQueue<Integer> queue;
    Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int value = 0;
        while (true){
            value++;
            System.out.println(Thread.currentThread().getName() + " Producer thread " +
                    "producing the data : "+value);
            try {
                queue.put(value);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

    }
}

class Consumer implements Runnable{
    private final BlockingQueue<Integer> consumerQueue;

    Consumer(BlockingQueue<Integer> consumerQueue) {
        this.consumerQueue = consumerQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Integer removedValue = consumerQueue.take();
                System.out.println(Thread.currentThread().getName() + "Polled the value : "+removedValue);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

        }

    }
}

public class BlockingQueueExample {

    public static void main(String[] args) {

        BlockingQueue<Integer> source = new ArrayBlockingQueue<>(5);

        Producer producer = new Producer(source);
        Consumer consumer = new Consumer(source);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer,"ConsumerThread");

        producerThread.start();
        consumerThread.start();

    }
}
