package ss12.controller;

import ss12.model.Product;
import ss12.service.ProductManager;
import java.util.Scanner;

public class ProductManagerController {
    static ProductManager productManager = new ProductManager();
    static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        while (true) {
            System.out.println("""
                    1. Thêm sản phẩm
                    2. Sửa thông tin sản phẩm
                    3. Xoá sản phẩm
                    4. Hiển thị danh sách sản phẩm
                    5. Tìm kiếm sản phẩm theo tên
                    6. Sắp xếp sản phẩm theo giá tăng dần
                    7. Sắp xếp sản phẩm theo giá giảm dần
                    8. Thoát""");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    productManager.displayProducts();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    productManager.sortProductsByPriceAscending();
                    productManager.displayProducts();
                    break;
                case 7:
                    productManager.sortProductsByPriceDescending();
                    productManager.displayProducts();
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void addProduct() {
        System.out.println("Nhập id sản phẩm:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();

        System.out.println("Nhập giá sản phẩm:");
        double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(id, name, price);
        productManager.addProduct(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    private static void updateProduct() {
        System.out.println("Nhập id sản phẩm cần sửa:");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập tên mới:");
        String name = scanner.nextLine();

        System.out.println("Nhập giá mới:");
        double price = Double.parseDouble(scanner.nextLine());

        if (productManager.updateProduct(id, name, price)) {
            System.out.println("Cập nhật sản phẩm thành công!");
        } else {
            System.out.println("Sản phẩm không tồn tại!");
        }
    }

    private static void deleteProduct() {
        System.out.println("Nhập id sản phẩm cần xoá:");
        int id = Integer.parseInt(scanner.nextLine());

        if (productManager.deleteProduct(id)) {
            System.out.println("Xoá sản phẩm thành công!");
        } else {
            System.out.println("Sản phẩm không tồn tại!");
        }
    }

    private static void searchProductByName() {
        System.out.println("Nhập tên sản phẩm cần tìm:");
        String name = scanner.nextLine();

        Product product = productManager.searchProductByName(name);
        if (product != null) {
            System.out.println("Sản phẩm tìm thấy: " + product);
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }
}

