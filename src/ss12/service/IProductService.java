package ss12.service;

import ss12.model.Product;
import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    boolean updateProduct(int id, String name, double price);
    boolean deleteProduct(int id);
    void displayProducts();
    Product searchProductByName(String name);
    void sortProductsByPriceAscending();
    void sortProductsByPriceDescending();
}

