package multithreading;

public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()
                -> System.out.println("Current Thead: "+Thread.currentThread().getName()));
        System.out.println("Thread status: "+thread.getState());
        thread.start();
        System.out.println("Thread status : "+thread.getState());
        Thread.sleep(1000);
        System.out.println("Thread status: "+thread.getState());
        thread.join();
        System.out.println("Thread Status: "+thread.getState());


    }
}
