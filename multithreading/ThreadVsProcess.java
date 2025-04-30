package multithreading;

/****
 *  Thread - A thread is the smalest unit of java program
 *  process - A process is the independent unit to perform the tasks.
 *  A process will have n number of threads and shared same memory.
 */

class LoggingThread extends Thread{
    @Override
    public void run() {
        this.setName("LoggingThread");
        for(int i=0;i<10;i++){
            System.out.println(" i am in "+this.currentThread().getName() +"  "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


}


class BillingThread extends Thread{
    @Override
    public void run() {
        this.setName("BillingThread");
        for(int i=0;i<10;i++){
            System.out.println(" i am in "+this.currentThread().getName() +"  "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadVsProcess {

    public static void main(String[] args) {
        LoggingThread loggingThread = new LoggingThread();
        loggingThread.start();

        BillingThread billingThread = new BillingThread();
        billingThread.start();

    }
}
