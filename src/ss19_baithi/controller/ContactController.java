package ss19_baithi.controller;

import ss19_baithi.model.Contact;
import ss19_baithi.service.ContactService;

import java.util.*;
import java.util.regex.Pattern;

public class ContactController {
    private ContactService contactService;
    private Scanner scanner;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    loadContactsFromFile();
                    break;
                case 7:
                    saveContactsToFile();
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 8);
    }

    private void displayMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private void displayContacts() {
        List<Contact> contacts = contactService.getContacts();
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
        } else {
            int count = 0;
            for (Contact contact : contacts) {
                System.out.println(contact);
                count++;
                if (count % 5 == 0) {
                    System.out.print("Nhấn Enter để hiển thị tiếp...");
                    scanner.nextLine();
                }
            }
        }
    }

    private void addContact() {
        System.out.print("Số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhóm: ");
        String group = scanner.nextLine();
        System.out.print("Họ tên: ");
        String fullName = scanner.nextLine();
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Ngày sinh: ");
        String birthDate = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (!validateInput(phoneNumber, email)) {
            System.out.println("Dữ liệu không hợp lệ. Vui lòng thử lại.");
            return;
        }

        Contact newContact = new Contact(phoneNumber, group, fullName, gender, address, birthDate, email);
        contactService.addContact(newContact);
        System.out.println("Danh bạ đã được thêm.");
    }

    private void updateContact() {
        System.out.print("Nhập số điện thoại cần sửa: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = contactService.findContactByPhoneNumber(phoneNumber);
        if (contact != null) {
            // Cập nhật thông tin
            System.out.print("Nhóm mới: ");
            String group = scanner.nextLine();
            System.out.print("Họ tên mới: ");
            String fullName = scanner.nextLine();
            System.out.print("Giới tính mới: ");
            String gender = scanner.nextLine();
            System.out.print("Địa chỉ mới: ");
            String address = scanner.nextLine();
            System.out.print("Ngày sinh mới: ");
            String birthDate = scanner.nextLine();
            System.out.print("Email mới: ");
            String email = scanner.nextLine();

            if (!validateInput(phoneNumber, email)) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng thử lại.");
                return;
            }

            Contact updatedContact = new Contact(phoneNumber, group, fullName, gender, address, birthDate, email);
            contactService.updateContact(phoneNumber, updatedContact);
            System.out.println("Thông tin danh bạ đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy danh bạ với số điện thoại trên.");
        }
    }

    private void deleteContact() {
        System.out.print("Nhập số điện thoại cần xoá: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = contactService.findContactByPhoneNumber(phoneNumber);
        if (contact != null) {
            System.out.print("Bạn có chắc chắn muốn xóa danh bạ này? (Y/N): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("Y")) {
                contactService.removeContact(phoneNumber);
                System.out.println("Danh bạ đã được xoá.");
            } else {
                System.out.println("Đã hủy thao tác xóa.");
            }
        } else {
            System.out.println("Không tìm thấy danh bạ với số điện thoại trên.");
        }
    }

    private void searchContact() {
        System.out.print("Nhập số điện thoại hoặc họ tên cần tìm: ");
        String searchTerm = scanner.nextLine();
        List<Contact> foundContacts = new ArrayList<>();
        for (Contact contact : contactService.getContacts()) {
            if (contact.getPhoneNumber().contains(searchTerm) || contact.getFullName().contains(searchTerm)) {
                foundContacts.add(contact);
            }
        }
        if (foundContacts.isEmpty()) {
            System.out.println("Không tìm thấy kết quả.");
        } else {
            for (Contact contact : foundContacts) {
                System.out.println(contact);
            }
        }
    }

    private void loadContactsFromFile() {
        System.out.print("Bạn có chắc chắn muốn tải lại danh bạ từ file? (Y/N): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")) {
            contactService.loadContactsFromFile("src/ss19_baithi/data/contacts.csv");
            System.out.println("Danh bạ đã được tải từ file.");
        } else {
            System.out.println("Đã hủy thao tác tải file.");
        }
    }

    private void saveContactsToFile() {
        System.out.print("Bạn có chắc chắn muốn lưu danh bạ vào file? (Y/N): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")) {
            contactService.saveContactsToFile("src/ss19_baithi/data/contacts.csv");
            System.out.println("Danh bạ đã được lưu vào file.");
        } else {
            System.out.println("Đã hủy thao tác lưu file.");
        }
    }

    private boolean validateInput(String phoneNumber, String email) {
        String phoneRegex = "^\\d{10}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);
        if (!phonePattern.matcher(phoneNumber).matches()) {
            System.out.println("Số điện thoại không hợp lệ.");
            return false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if (!emailPattern.matcher(email).matches()) {
            System.out.println("Email không hợp lệ.");
            return false;
        }

        return true;
    }
}
