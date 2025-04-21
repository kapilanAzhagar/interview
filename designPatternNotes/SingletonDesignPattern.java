package designPatterns;

import java.io.Serializable;

class ConnectionPool implements Serializable, Cloneable{
    private static volatile ConnectionPool connectionPool = null;

    private ConnectionPool(){
        if(connectionPool !=null){
            throw new IllegalArgumentException();
        }
    }

     public static ConnectionPool getInstance(){
        synchronized (ConnectionPool.class){
            if(connectionPool == null){
                connectionPool = new ConnectionPool();
            }
        }
        return connectionPool;
     }
    protected Object readResolve(){
        return connectionPool;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


enum SingletonEnum{
    INSTANCE;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int value = 1;

}

class OrderIdGenerator implements Serializable, Cloneable {
    private static volatile OrderIdGenerator orderIdGeneratorInstance = null;
    private int orderID = 1000;
    //private constructor
    private OrderIdGenerator(){
        if(orderIdGeneratorInstance != null){
            throw new IllegalArgumentException();
        }
    }
    //static method
    public static OrderIdGenerator getInstance(){
        synchronized (OrderIdGenerator.class){
            if(orderIdGeneratorInstance == null){
                orderIdGeneratorInstance = new OrderIdGenerator();
            }
        }
        return orderIdGeneratorInstance;
    }

    public synchronized int getOrderID(){
        return orderID++;
    }


    protected Object readResolve(){
        return orderIdGeneratorInstance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


//Bill paugh singleton

class BillpaughSingleton{
    private BillpaughSingleton(){

    }
    private static class Holder{
        private static final BillpaughSingleton instance = new BillpaughSingleton();
    }

    public static BillpaughSingleton getbpInstance(){
        return Holder.instance;
    }

}

public class SingletonDesignPattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        OrderIdGenerator orderIdGenerator = OrderIdGenerator.getInstance();
        System.out.println("Generated OrderID: "+orderIdGenerator.getOrderID()+" with hashcode:"+orderIdGenerator.hashCode());
        System.out.println("Generated OrderID: "+orderIdGenerator.getOrderID()+" with hashcode:"+orderIdGenerator.hashCode());
        System.out.println("Generated OrderID: "+orderIdGenerator.getOrderID()+" with hashcode:"+orderIdGenerator.hashCode());
        //orderIdGenerator = orderIdGenerator.clone();
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.setValue(5);
        System.out.println("enum values: "+singletonEnum.getValue());
    }





}
