package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

            for (int i = 1; i <= 5; i++) {
                int taskID = i;
                    executorService.submit(()->{
                        System.out.println("Task "+ taskID +" is executing with thread : "+Thread.currentThread().getName());
                    });
            }


        executorService.shutdown();


    }
}
