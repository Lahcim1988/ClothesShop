package service;

import entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    int getCountProducts();

    Product getProductByProductName(String productName);

    boolean isProductOnWarehouse(String productName);

    boolean isProductExist(String productName);

    boolean isProductExist(long productId);

}
