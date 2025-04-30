package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class Counter{
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public int increment(){
        return atomicInteger.incrementAndGet();
    }

    public int getValue(){
        return atomicInteger.get();
    }
}

public class ThreadSafeCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable countTask = ()->{
            for(int i=1;i<=1000;i++){
                counter.increment();
            }
        };

        Thread thread1 = new Thread(countTask);
        Thread thread2 = new Thread(countTask);
        Thread thread3 = new Thread(countTask);

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        thread3.start();
        thread3.join();

        System.out.println("Current Value : "+ counter.getValue());

    }


}
