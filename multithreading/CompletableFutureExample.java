package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/***
 * Competeablefuture is a class and its part of concurrent from java-8.
 * it will not block the get call like Futuretask.
 * it will perform the tasks parallelly.
 * Like checkout page required- product details+inventory stock details+ dicount pricing details
 */
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> productDetails = CompletableFuture.supplyAsync(()-> {
            try {
                return fetchProductDetails("iphone");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<Boolean> inventoryStockAvailable = CompletableFuture.supplyAsync(()-> {
            try {
                return isStockAvailable();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<Integer> discountPercentage = CompletableFuture.supplyAsync(()-> {
            try {
                return fetchDiscountPercentage("iphone");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Void> combinedValues = CompletableFuture.allOf(productDetails,inventoryStockAvailable,discountPercentage);

        combinedValues.join();

        System.out.println("productDetails : "+productDetails.get());
        System.out.println("inventoryStockAvailable : "+inventoryStockAvailable.get());
        System.out.println("discountPercentage : "+discountPercentage.get());



    }

    private static Integer fetchDiscountPercentage(String iphone) throws InterruptedException {
        Thread.sleep(200);
        return 25;
    }

    private static Boolean isStockAvailable() throws InterruptedException {
        return null;
    }

    private static String fetchProductDetails(String product) throws InterruptedException {
        Thread.sleep(200);
        return "15 pro model is good";
    }
}
