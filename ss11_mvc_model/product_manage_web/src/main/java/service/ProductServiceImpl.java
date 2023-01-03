package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "car", 7200, "yelow", "Mazda"));
        productList.add(new Product(2, "moto", 200, "yelow", "Honda"));
        productList.add(new Product(3, "smart phone", 250, "yelow", "Apple"));
        productList.add(new Product(4, "laptop", 900, "yelow", "Asus"));
    }

    @Override
    public List<Product> showAllProducts() {
        return productList;
    }
    @Override
    public void createNewProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productList.add(product);
    }

    @Override
    public void deleteProduct(int id) {
        productList.remove(id);
    }

    @Override
    public Product showDetailProduct(int id) {
        return productList.get(id);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }
}
