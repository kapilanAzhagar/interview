package multithreading;



/***
 * Deadlock occurs, when two or more threads blocked forever, and waiting for each other
 * threads to release the lock they hold.
 */
class ReaderThread implements Runnable{

    private Object object1;
    private Object object2;

    ReaderThread(Object object1,Object object2){
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run() {
        synchronized (object1){

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (object2){

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}

class WriterThread implements Runnable{
    private Object object1;
    private Object object2;

    public WriterThread(Object writerObject,Object readerObject) {
        this.object1 = writerObject;
        this.object2 = readerObject;
    }

    @Override
    public void run() {
        synchronized (object2){

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (object1){

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

public class DLtest {


    public static void main(String[] args) {
        Object sharedObject1 = new Object();
        Object sharedObject2 = new Object();

        /*Thread reader = new Thread(new ReaderThread(sharedObject1,sharedObject2));
        Thread writer = new Thread(new WriterThread(sharedObject2,sharedObject1));

        reader.start();
        writer.start();*/

        Thread initialThread = new Thread(()->{
            synchronized (sharedObject1){
                try {
                    System.out.println("Locking the sharedObject1 with initialthread: "+Thread.currentThread().getName());
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (sharedObject2){
                    try {
                        System.out.println("Locking the sharedObject2 with initialthread: "+Thread.currentThread().getName());
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread secondThread = new Thread(()->{
            synchronized (sharedObject2){
                try {
                    System.out.println("Locking the sharedObject2 with initialthread: "+Thread.currentThread().getName());
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (sharedObject1){
                    try {
                        System.out.println("Locking the sharedObject1 with initialthread: "+Thread.currentThread().getName());
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        initialThread.start();
        secondThread.start();



    }
}
