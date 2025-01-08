package ss8_mvc.controller;

import ss8_mvc.model.Client;
import ss8_mvc.service.ClientService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClientController {
    static ClientService clientService = new ClientService();

    public static void displayClientMenu() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("""
                    Chọn chức năng\s
                    1. Xem danh sách
                    2. Thêm mới
                    3. Sửa
                    4. Xoá
                    5. Thoát""");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    Client[] clients = clientService.findAll();
                    for (Client client : clients) {
                        if (client != null) {
                            System.out.println(client);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Nhập id:");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.println("Nhập tên:");
                    String name = scanner.nextLine();

                    System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy):");
                    String dateInput = scanner.nextLine();
                    LocalDate birthDate;
                    try {
                        birthDate = LocalDate.parse(dateInput, formatter);
                    } catch (Exception e) {
                        System.out.println("Ngày tháng không hợp lệ. Vui lòng nhập lại theo định dạng dd/MM/yyyy.");
                        break;
                    }

                    System.out.println("Nhập địa chỉ:");
                    String address = scanner.nextLine();

                    Client client = new Client(id, name, birthDate, address);
                    clientService.addClient(client);
                    System.out.println("Thêm mới thành công!");
                    break;

                case 3:
                    System.out.println("Nhập id của khách hàng cần sửa:");
                    int updateId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Nhập tên mới:");
                    String newName = scanner.nextLine();

                    System.out.println("Nhập ngày tháng năm sinh mới (dd/MM/yyyy):");
                    LocalDate newBirthDate = LocalDate.parse(scanner.nextLine(), formatter);

                    System.out.println("Nhập địa chỉ mới:");
                    String newAddress = scanner.nextLine();

                    boolean updated = clientService.updateClient(updateId, newName, newBirthDate, newAddress);
                    if (updated) {
                        System.out.println("Cập nhật thành công!");
                    } else {
                        System.out.println("Không tìm thấy khách hàng có id: " + updateId);
                    }
                    break;

                case 4:
                    System.out.println("Nhập id của khách hàng cần xóa:");
                    int deleteId = Integer.parseInt(scanner.nextLine());

                    boolean deleted = clientService.deleteClient(deleteId);
                    if (deleted) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy khách hàng có id: " + deleteId);
                    }
                    break;

                case 5:
                    System.out.println("-------- Kết thúc chương trình --------");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}

