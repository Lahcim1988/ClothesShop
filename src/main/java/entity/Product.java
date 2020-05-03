package entity;

public class Product {

    private int id;
    private String productName;
    private double price;
    private String weight;
    private String color;
    private int productCount;

    public Product(int id, String productName, double price, String weight, String color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    @Override
    public String toString() {
        return "pl.shop.entity.Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", weight='" + weight + '\'' +
                ", color='" + color + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}
