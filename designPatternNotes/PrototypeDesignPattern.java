package designPatterns;

interface PrototypeProduct{
    PrototypeProduct clone();
}

class Product implements PrototypeProduct{
    private String productName;
    private double productPrice;
    private String productDescription;

    public Product(String productName, double productPrice, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }

    @Override
    public PrototypeProduct clone() {
        return new Product(this.productName,this.productPrice,this.productDescription);
    }
}

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        Product product = new Product("waterbottle",40,"savewater");
        Product copied = (Product) product.clone();
        System.out.println("original product:"+product.hashCode());
        System.out.println("copied product:"+copied.hashCode());
        System.out.println("original product:"+product.toString());
        System.out.println("copied product:"+copied.toString());
    }


}
