package entity;

public class Product {

    public final static String PRODUCT_SEPARATOR = "#";
    public final static char PRODUCT_TYPE = 'P';

    private Long id;
    private String productName;
    private Float price;
    private Float weight;
    private String color;
    private Integer productCount;

    public Product(Long id, String productName, Float price, Float weight, String color, Integer productCount) {
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

    public Float getPrice() {
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

    protected String getBasicProductString() {
        return id + PRODUCT_SEPARATOR + productName +
                PRODUCT_SEPARATOR + price +
                PRODUCT_SEPARATOR + weight +
                PRODUCT_SEPARATOR + color +
                PRODUCT_SEPARATOR + productCount;
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
