package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/****
 *   Threadsafety->
 *      use synchronized blocks or methods
 *      use atomic integer
 *      ues concurrent collections
 *      use ThreadLocal for per thread state
 */
public class ThreadSafetyExample {

    private int initialCount = 0;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void addcount(){
        atomicInteger.incrementAndGet();
    }

    public int getCount(){
        return atomicInteger.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafetyExample safetyExample = new ThreadSafetyExample();

        Runnable task1 = ()->{
            for(int i=0;i<1000;i++){
                safetyExample.addcount();
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task1);
        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.out.println("Total Count: "+safetyExample.getCount());
    }



}
