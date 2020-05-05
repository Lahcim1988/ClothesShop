package entity;

public class Product {

    public final static String PRODUCT_SEPARATOR = "#";

    private Long id;
    private String productName;
    private Double price;
    private Float weight;
    private String color;
    private Integer productCount;

    public Product(Long id, String productName, Double price, Float weight, String color, Integer productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Integer getProductCount() {
        return productCount;
    }

    @Override
    public String toString() {
        return id + PRODUCT_SEPARATOR +
                productName + PRODUCT_SEPARATOR +
                price + PRODUCT_SEPARATOR +
                weight + PRODUCT_SEPARATOR +
                color + PRODUCT_SEPARATOR +
                productCount;
    }
}
