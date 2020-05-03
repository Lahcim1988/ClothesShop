package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;
import serviceImpl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    // getAllProducts
    @Test
    public void testGetAllProductsPositive() {

        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "t-shirt", 35.0f, 0.3f,
                "red", 4, "XL", "COTTON"));

        products.add(new Boots(1l, "boots", 35.9f, 0.3f,
                "brown", 4, 38, true));

        //than
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertEquals(products, productsFromTestClass);
    }

    @Test
    public void testGetAllProductsEmptyList() {

        //is
        List<Product> products = new ArrayList<Product>();

        //than
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertEquals(products, productsFromTestClass);
    }

    @Test
    public void testGetAllProductsNegative() {

        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f,
                "Black", 4, "XL", "COTTON"));
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f,
                "Black", 4, 38, true));

        //than
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Cloth(3l, "Spodnie", 44.f, 0.f,
                "White", 3, "S", "COTTON"));
        List<Product> productsFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertNotEquals(products, productsFromTestClass);
    }

    // GetCountProductsWithProducts
    @Test
    public void testGetCountProductsWithProducts() {

        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f,
                "Black", 4, "XL", "COTTON"));
        products.add(new Boots(2l, "Boots", 35.0f,
                0.3f, "Black", 4, 38, true));

        //than
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountProducts();

        //expected
        Assert.assertEquals(2, result);

    }

    @Test
    public void testGetCountProductsWithoutProducts() {

        //is

        //than
        ProductServiceImpl productService = new ProductServiceImpl();
        final int result = productService.getCountProducts();

        //expected
        Assert.assertEquals(0, result);

    }

    // GetProductByProductNameWhenExist
    @Test
    public void testGetProductByProductNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("T-SHIRT");

        Assert.assertEquals(cloth, product);
    }

    @Test
    public void testGetProductByProductNameWhenNoExist() {

        //is
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "T-SHIRT", 35.0f, 0.3f,
                "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f,
                "Black", 4, 38, true));

        //than
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("Jakis-produkt");

        //expected
        Assert.assertEquals(null, product);
    }

    //IsProductOnWareHouse
    @Test
    public void testIsProductOnWareHouseWhenIs() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f,
                0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isProductOnWarehouse("Boots");

        Assert.assertTrue(isProductOnWareHouse);
    }


    @Test
    public void testIsProductOnWareHouseWhenIsNot() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f,
                0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isProductOnWarehouse("Shorts");

        Assert.assertFalse(isProductOnWareHouse);
    }

    //IsProductExistByNameWhenExist
    @Test
    public void testIsProductExistByNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f,
                "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Boots");

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f,
                "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Inny produkt");

        Assert.assertFalse(isProductExist);
    }

    //IsProductExistById
    @Test
    public void testIsProductExistByIdWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f,
                "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(2l);

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f,
                "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(5l);

        Assert.assertFalse(isProductExist);
    }
}
