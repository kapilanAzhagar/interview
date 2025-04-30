package multithreading;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(2,
                4,
                10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for(int i=1;i<=6;i++){
           final int taskId = i;
           executorService.submit(()->{
               System.out.println("Thread "+Thread.currentThread().getName() +" With task Id: "+taskId);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   throw new RuntimeException(e);
               }
           });

        }
        executorService.shutdown();
    }
}
