package entity;

import enums.Color;
import enums.ProductSeparators;
import enums.SkinType;

public class Boots extends Product {

    private int size;
    private SkinType skinType;

    public Boots(long id, String productName, float price, float weight, Color color,
                 int productCount, int size, SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = skinType;
    }

    public Integer getSize() {
        return size;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID +
                ProductSeparators.PRODUCT_SEPARATOR.toString() +
                getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                size + ProductSeparators.PRODUCT_SEPARATOR.toString() + skinType;
    }
}
