package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showAllProducts() ;
    void createNewProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id) ;
    Product showDetailProduct(int id) ;
    Product findById(int id);
}
