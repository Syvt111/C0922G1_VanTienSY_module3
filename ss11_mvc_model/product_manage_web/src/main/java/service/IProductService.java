package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAllProducts() ;
    void createNewProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id) ;
    Product showDetailProduct(int id) ;
    Product findById(int id);
}