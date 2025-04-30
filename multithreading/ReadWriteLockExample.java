package multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private static String configValue = "DefaultValues";
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String readLock() {
        try{
            readWriteLock.readLock().lock();
            System.out.println("Current Thread :"+Thread.currentThread().getName()+ " configValue: "+configValue);
            return configValue;
        }finally {
            readWriteLock.readLock().unlock();
        }

    }

    private String writeLock(String newConfig){
        try {
            readWriteLock.writeLock().lock();
            configValue = newConfig;
            System.out.println("Current Thread :" + Thread.currentThread().getName() + " newConfig: " + newConfig);
            return newConfig;
        }finally{
            readWriteLock.writeLock().unlock();
        }
    }



    public static void main(String[] args) {

        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();

        Runnable reader = ()->{
            readWriteLockExample.readLock();
        };

        Runnable writer = ()->{
            readWriteLockExample.writeLock("newConfig");
        };

        Thread reader1 = new Thread(reader);
        Thread reader2 = new Thread(reader);
        Thread writer1 = new Thread(writer);

        reader1.start();
        reader2.start();
        writer1.start();

    }
}
