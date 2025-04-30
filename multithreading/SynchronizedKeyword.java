package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*****
 * Synchronization is a keyword in multithreading, its make sure that only one thread access a critical section at time.
 * It prevents race condition.
 */
public class SynchronizedKeyword {

    private Integer accountBalance = 100;
    public synchronized void debitAmount(Integer debitAmount){
        if(accountBalance>=debitAmount){
            accountBalance = accountBalance - debitAmount;
            System.out.println("Remaining account balance: "+accountBalance);
        }else{
            System.out.println("Insufficient funds...");
        }
    }

    public static void main(String[] args) {

        SynchronizedKeyword synchronizedKeyword = new SynchronizedKeyword();

        Runnable debitTask = ()-> synchronizedKeyword.debitAmount(80);

        Thread worker1 = new Thread(debitTask);
        Thread worker2 = new Thread(debitTask);

        worker1.start();
        worker2.start();

        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(debitTask);
        service.shutdown();




    }
}
