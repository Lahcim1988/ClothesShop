package dao;

import entity.Product;
import entity.ProductParser;
import service.ProductDao;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private final String fileName;
    private final String productType;

    public ProductDaoImpl(String fileName, String productType) {
        this.fileName = fileName;
        this.productType = productType;
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (Product product : products) {
            printWriter.write(product + "\n");
        }
        printWriter.close();
    }

    @Override
    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            boolean isProductExist = product.getId().equals(productId);
            if (isProductExist) {
                products.remove(product);
            }
        }
        saveProducts(products);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            boolean isProductExist = product.getProductName().equals(productName);
            if (isProductExist) {
                products.remove(product);
            }
        }
        saveProducts(products);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String readLine = reader.readLine();
        while (readLine != null) {
            Product product = ProductParser.stringToProduct(readLine, productType);
            if (product != null) {
                products.add(product);
            }
        }
        reader.close();
        return products;
    }

    @Override
    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            boolean isProductExist = product.getId().equals(productId);
            if (isProductExist) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            boolean isProductExist = product.getProductName().equals(productName);
            if (isProductExist) {
                return product;
            }
        }
        return null;
    }
}
