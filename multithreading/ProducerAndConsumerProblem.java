package multithreading;


import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumerProblem {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int CAPACITY = 5;
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (buffer.size() == CAPACITY) {
                    lock.wait(); // Buffer is full, producer waits
                }
                buffer.offer(value);
                System.out.println("Produced: " + value);
                value++;
                lock.notifyAll(); // Notify consumer
            }
            Thread.sleep(500); // Slow down production for demo
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (buffer.isEmpty()) {
                    lock.wait(); // Buffer empty, consumer waits
                }
                int removedValue = buffer.poll();
                System.out.println("Consumed: " + removedValue);
                lock.notifyAll(); // Notify producer
            }
            Thread.sleep(500); // Slow down consumption for demo
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerProblem pc = new ProducerAndConsumerProblem();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

