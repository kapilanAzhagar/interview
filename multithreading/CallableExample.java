package multithreading;

import java.util.SortedMap;
import java.util.concurrent.*;

/*****
 * Runnable - returns nothing and can not throw checked exceptions.
 * Callable - returns the value and can throw checked exeptions.
 * Both are functional interface.
 * Future used to get the value from the callable.
 */
public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> task = ()->{
            Thread.sleep(1000);
            return "Task completed";
        };

        Future<String> result = executorService.submit(task);
        System.out.println("Worker something");
        System.out.println("Worker something getting result: "+result.get());
        executorService.shutdown();*/











        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> task = () ->{
            return "Task completed";
        };
        Future<String> result = executorService.submit(task);
        System.out.println("result: "+result.get());















    }




}
