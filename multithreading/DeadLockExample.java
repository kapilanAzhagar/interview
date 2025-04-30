package multithreading;

/**
 * When two or more threads are waiting on each other to complete and release the lock.
 * T1 lock object A and wait for T2 to complete.
 * T2 lock the object and wait for T1 to complete
 * Avoid the nested synchronized blocks and create the lock with timeout.
 */
public class DeadLockExample {

    private static final Object object1 = new Object();
    private static final Object object2 = new Object();

    public static void main(String[] args) {
        Thread firstThread = new Thread(()->{
            synchronized (object1){
                System.out.println("Locking object1 :"+Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object2){
                    System.out.println("Locking object1 :"+Thread.currentThread().getName());
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread secondThread = new Thread(()->{
            synchronized (object2){
                System.out.println("Locking object1 :"+Thread.currentThread().getName());
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object1){
                    System.out.println("Locking object1 :"+Thread.currentThread().getName());
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        firstThread.start();
        secondThread.start();
    }

}
