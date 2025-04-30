package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/***
 * Futuretask wrap the callable and runnable interface. (its a combineation)
 * Return the value using get after the task completed asynchronously.
 */
public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> task1 = ()->{
            System.out.println("Task1 executing.."+Thread.currentThread().getName());
            return "Hello Kapil";
        };

        Runnable task2 = ()->{
            System.out.println("Task2 executing.."+Thread.currentThread().getName());
        };

        FutureTask<String> result = new FutureTask<String>(task1);

        FutureTask<String> runnableResult = new FutureTask<String>(task2,"Response from runnable");

        Thread action = new Thread(result);
        action.start();

        Thread reaction = new Thread(runnableResult);
        reaction.start();

        System.out.println("Result: "+result.get());

        System.out.println("RunnableResult: "+runnableResult.get());

    }

}
