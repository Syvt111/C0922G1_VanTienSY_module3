package service;

import model.Product;
import repository.IProductRepository;
import repository.ipml.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> showAllProducts() {
        return iProductRepository.showAllProducts();
    }
    @Override
    public void createNewProduct(Product product) {

        iProductRepository.createNewProduct(product);
    }

    @Override
    public void updateProduct(int id, Product product) {

        iProductRepository.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(int id) {

        iProductRepository.deleteProduct(id);
    }

    @Override
    public Product showDetailProduct(int id) {
        return iProductRepository.showDetailProduct(id);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }
}
