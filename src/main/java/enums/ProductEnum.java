package enums;

public enum  ProductEnum {

    PRODUCT_TYPE('P'),
    PRODUCT_SEPARATOR("#");

    private char product_type;
    private String product_separator;

    ProductEnum(char product_enum) {
        this.product_type = product_enum;
    }

    ProductEnum(String product_separator) {
        this.product_separator = product_separator;
    }

    public char getProduct_type() {
        return product_type;
    }

    public String getProduct_separator() {
        return product_separator;
    }
}
