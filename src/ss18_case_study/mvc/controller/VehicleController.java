package ss18_case_study.mvc.controller;

import ss18_case_study.mvc.model.Car;
import ss18_case_study.mvc.model.Motorcycle;
import ss18_case_study.mvc.model.Truck;
import ss18_case_study.mvc.model.Vehicle;
import ss18_case_study.mvc.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class VehicleController {
    private VehicleService vehicleService;
    private Scanner scanner;

    public VehicleController() {
        vehicleService = new VehicleService();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice = -1;
        do {
            System.out.println("----- Quản lý phương tiện giao thông -----");
            System.out.println("1. Thêm mới phương tiện.");
            System.out.println("2. Hiển thị phương tiện.");
            System.out.println("3. Xóa phương tiện.");
            System.out.println("4. Thoát.");
            System.out.print("Chọn một chức năng: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
                scanner.nextLine(); // Clear buffer
                continue;
            }

            switch (choice) {
                case 1:
                    addNewVehicle();
                    break;
                case 2:
                    displayVehicles();
                    break;
                case 3:
                    deleteVehicle();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println();
        } while (choice != 4);
    }

    private void addNewVehicle() {
        System.out.println("Chọn loại phương tiện:");
        System.out.println("1. Thêm xe tải");
        System.out.println("2. Thêm ôtô");
        System.out.println("3. Thêm xe máy");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addTruck();
                break;
            case 2:
                addCar();
                break;
            case 3:
                addMotorcycle();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    private void addTruck() {
        System.out.print("Nhập biển số xe tải: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập tải trọng (tấn): ");
        double loadCapacity = scanner.nextDouble();

        Truck truck = new Truck(licensePlate, manufacturer, year, owner, loadCapacity);
        vehicleService.addVehicle(truck);
    }

    private void addCar() {
        System.out.print("Nhập biển số ôtô: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập số ghế: ");
        int seatCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nhập loại xe (Sedan/SUV,...): ");
        String type = scanner.nextLine();

        Car car = new Car(licensePlate, manufacturer, year, owner, seatCount, type);
        vehicleService.addVehicle(car);
    }

    private void addMotorcycle() {
        System.out.print("Nhập biển số xe máy: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("Nhập công suất động cơ (mã lực): ");
        double enginePower = scanner.nextDouble();

        Motorcycle motorcycle = new Motorcycle(licensePlate, manufacturer, year, owner, enginePower);
        vehicleService.addVehicle(motorcycle);
    }

    private void displayVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void deleteVehicle() {
        System.out.print("Nhập biển số phương tiện cần xóa: ");
        String licensePlate = scanner.nextLine();
        boolean deleted = vehicleService.deleteVehicleByLicensePlate(licensePlate);
        if (deleted) {
            System.out.println("Đã xóa phương tiện.");
        } else {
            System.out.println("Không tìm thấy phương tiện với biển số đã nhập.");
        }
    }
}

