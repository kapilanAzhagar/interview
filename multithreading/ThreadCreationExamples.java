package multithreading;

import solidPrinciples.Order;

import java.util.concurrent.*;

public class ThreadCreationExamples {
    /****
     *  4 ways to create the thread
     *  1. extends Thread class
     *  2. Implementing the Runnable interface -  will not return anything
     *  3. Implementing the Callable interface with Future - will RETURN value
     *  4. using the ExecutorService connection pooling
     */


    static class OrderProcessingThread extends Thread{
        @Override
        public void run() {
            this.setName("OrderProcessingThread");
            System.out.println(Thread.currentThread().getName());
        }
    }

    static class PaymentProcessingThread implements Runnable{
        public void run() {
            Thread.currentThread().setName("PaymentProcessingThread");
            System.out.println(Thread.currentThread().getName());
        }
    }

    static class InventoryService implements Callable<String>{
        @Override
        public String call() throws Exception {
            Thread.currentThread().setName("InventoryService");
            System.out.println(Thread.currentThread().getName());
            return "hello kapilan";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread orderProcessingThread = new OrderProcessingThread();
        orderProcessingThread.start();

        Thread paymentProcessingThread = new Thread(new PaymentProcessingThread());
        paymentProcessingThread.start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> result = executorService.submit(new InventoryService());
        System.out.println(result.get());
        executorService.shutdown();

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(()-> System.out.println("Email set by "+ Thread.currentThread().getName()));
        service.shutdown();
    }


}
