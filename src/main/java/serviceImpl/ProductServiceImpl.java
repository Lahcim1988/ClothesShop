package serviceImpl;

import dao.ProductDaoImpl;
import entity.Product;
import service.ProductDao;
import service.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {


    private static ProductServiceImpl instance = null;
    private ProductDao productDao = new ProductDaoImpl("products.data", "PRODUCT");

    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    @Override
    public Integer getCountProducts() throws IOException {
        return getAllProducts().size();
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        return productDao.getProductByProductName(productName);
    }

    @Override
    public boolean isProductOnWarehouse(String productName) {
        try {
            for (Product product : getAllProducts()) {
                //boolean isEqual = product.getProductName().equals(productName);
                if (isProductExist(productName) && product.getProductCount() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isProductExist(String productName) {
        Product product = null;
        try {
            product = productDao.getProductByProductName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return product != null;
    }

    @Override
    public boolean isProductExist(Long productId) {
        Product product = null;
        try {
            product = productDao.getProductById(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return product != null;
    }
}
