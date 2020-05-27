package entity;

import enums.ColorEnum;
import enums.ProductSeparators;

public class Product {

/*    public final static String PRODUCT_SEPARATOR = "#";
    public final static char PRODUCT_TYPE = 'P';*/

    private Long id;
    private String productName;
    private Float price;
    private Float weight;
    private ColorEnum color;
    private Integer productCount;

    public Product(Long id, String productName, Float price, Float weight, ColorEnum color, Integer productCount) {
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

    public ColorEnum getColor() {
        return color;
    }

    public Integer getProductCount() {
        return productCount;
    }

    protected String getBasicProductString() {
        return id + ProductSeparators.PRODUCT_SEPARATOR.toString() + productName +
                ProductSeparators.PRODUCT_SEPARATOR.toString() +
                ProductSeparators.PRODUCT_SEPARATOR.toString() +
                ProductSeparators.PRODUCT_SEPARATOR.toString() +
                ProductSeparators.PRODUCT_SEPARATOR.toString();
    }

    @Override
    public String toString() {
        return id + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                productName + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                price + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                weight + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                color + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                productCount;
    }
}
