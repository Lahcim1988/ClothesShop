package serviceImpl;

import entity.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public int getCountProducts() {
        return products.size();
    }

    @Override
    public Product getProductByProductName(String productName) {
        for (Product product : products) {
            boolean isEqual = product.getProductName().equals(productName);
            if (isEqual) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductOnWarehouse(String productName) {
        for (Product product : products) {
            boolean isEqual = product.getProductName().equals(productName);
            if (isEqual) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        for (Product product : products) {
            boolean isEqual = product.getProductName().equals(productName);
            if (isEqual) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExist(long productId) {
        for (Product product : products) {
            boolean isEqual = product.getId() == productId;
            if (isEqual) {
                return true;
            }
        }
        return false;
    }
}
