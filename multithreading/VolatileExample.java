package multithreading;

public class VolatileExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread writerThread = new Thread(()->{
            try {
                Thread.sleep(1000);

                flag = true;
                System.out.println("Flag value changes in writerthread : "+flag);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread readerThread = new Thread(()->{
           while(!flag){
               System.out.println("Flag value in reader thread : "+flag);
           }
            System.out.println("Flag value in reader outside thread : "+flag);
        });



        writerThread.start();
        writerThread.join();
        readerThread.start();



    }
}
