package multithreading;

/*****
 * thread intruption is the co-operative mechanism to gracefully stop the thread.
 * Thread.intrupt() Therad.intrupted() or isIntrupted() will help to identify the state.
 */
public class ThreadIntruptionExample {

    public static void main(String[] args) throws InterruptedException {

        Thread workerThread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Working...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted during sleep");
                    //Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Worker thread stopping");
        });

        workerThread.start();
        Thread.sleep(1000);
        workerThread.interrupt();

    }

}
