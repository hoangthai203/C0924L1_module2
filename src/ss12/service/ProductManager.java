package ss12.service;

import ss12.model.Product;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProductManager implements IProductService {
    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public boolean updateProduct(int id, String name, double price) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    @Override
    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public Product searchProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void sortProductsByPriceAscending() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
    }

    @Override
    public void sortProductsByPriceDescending() {
        products.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
    }
}

//public class ProductManager implements IProductService {
//    // B4: Sử dụng LinkedList thay vì ArrayList
//    private List<Product> products = new LinkedList<>();
//
//    @Override
//    public void addProduct(Product product) {
//        products.add(product);
//    }
//
//    @Override
//    public boolean updateProduct(int id, String name, double price) {
//        for (Product product : products) {
//            if (product.getId() == id) {
//                product.setName(name);
//                product.setPrice(price);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteProduct(int id) {
//        return products.removeIf(product -> product.getId() == id);
//    }
//
//    @Override
//    public void displayProducts() {
//        for (Product product : products) {
//            System.out.println(product);
//        }
//    }
//
//    @Override
//    public Product searchProductByName(String name) {
//        for (Product product : products) {
//            if (product.getName().equalsIgnoreCase(name)) {
//                return product;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void sortProductsByPriceAscending() {
//        products.sort(Comparator.comparingDouble(Product::getPrice));
//    }
//
//    @Override
//    public void sortProductsByPriceDescending() {
//        products.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
//    }
//}