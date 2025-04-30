package multithreading;

import java.util.concurrent.locks.ReentrantLock;

/*****
 * Synchronized and ReentrantLock perform locking and providing thread safety.
 * but this ReenetrantLock is a explicit one and having complete control with us
 * we can intrupt the lock if we want and need to be unlocked after the actual operation.
 *
 * In the synchronized, its a implicit locking process and we cant intrupt and then no need to
 * explicit un-locking required.
 */

public class ReentrantLockExample {

    private final ReentrantLock reentrantLock = new ReentrantLock();
    private int availableTickets = 2;

    public void bookTicket(int ticketCount){
        try{
                reentrantLock.lock();
                if(availableTickets>=ticketCount){
                    availableTickets-=ticketCount;
                    System.out.println(ticketCount + " Tickets are booked and remaining tickets are "+availableTickets);
                }else{
                    System.out.println("Tickets are NOT available");
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            reentrantLock.unlock();
        }


    }

    public static void main(String[] args) {
        ReentrantLockExample lockExample = new ReentrantLockExample();
        Runnable bookTicketTask = ()-> lockExample.bookTicket(1);

        Thread t1 = new Thread(bookTicketTask);
        Thread t2 = new Thread(bookTicketTask);
        Thread t3 = new Thread(bookTicketTask);
        Thread t4 = new Thread(bookTicketTask);

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

}
