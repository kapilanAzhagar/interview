package multithreading;

import java.io.Serializable;

class SingleTonPool implements Cloneable, Serializable {
    private static volatile SingleTonPool poolInstance = null;

    private SingleTonPool(){
        System.out.println("Connectionpool created.....");
    }

    public static SingleTonPool getInstance(){
        synchronized (SingleTonPool.class){
            if(poolInstance == null){
                System.out.println("Singlepool created.....");
                poolInstance = new SingleTonPool();
            }
        }
        return poolInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}

public class SingleTonThreadSafeDesign {

    public static void main(String[] args) {
        Runnable task = ()->{
            SingleTonPool connectionpool = SingleTonPool.getInstance();
            System.out.println("connectionpool task: "+connectionpool.hashCode());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }




}
