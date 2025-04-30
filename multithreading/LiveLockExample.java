package multithreading;

/***
 *  Livelock is a condition, where threads are not blocked but keep re-trying the actions that fail competely.
 */

public class LiveLockExample {

    static class Values{
        volatile boolean flag = true;
    }

    public static void main(String[] args) {
        Values values = new Values();
        Thread readerThread = new Thread(()->{
            while(values.flag){
                System.out.println("Waiting for the flag to become false: "+Thread.currentThread().getName());
            }
        });

        Thread writerThread = new Thread(()->{
            while (values.flag){
                System.out.println("Waiting for the flag to become false: "+Thread.currentThread().getName());
                values.flag = true;
            }
        });

        readerThread.start();
        writerThread.start();


    }

}

