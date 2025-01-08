package ss16_text_file.mvc.controller;

import ss16_text_file.mvc.model.Student;
import ss16_text_file.mvc.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private StudentService studentService;
    private Scanner scanner;

    public StudentController() {
        studentService = new StudentService();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice = -1;
        do {
            System.out.println("----- Quản lý sinh viên -----");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn một chức năng: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    Student student = inputDataForStudent("add");
                    studentService.addStudent(student);
                    System.out.println("Thêm sinh viên thành công!");
                    break;
                case 2:
                    List<Student> list = studentService.getAllStudents();
                    displayStudent(list);
                    break;
                case 3:
                    int updateId = inputIdStudent("Nhập ID cần cập nhật: ");
                    Student stu = studentService.getStudentByID(updateId);
                    if (stu != null) {
                        Student newStudent = inputDataForStudent("update");
                        newStudent.setId(updateId);
                        studentService.updateStudent(newStudent);
                        System.out.println("Cập nhật sinh viên thành công!");
                    } else {
                        System.out.println("ID không tồn tại.");
                    }
                    break;
                case 4:
                    int id = inputIdStudent("Nhập ID cần xóa: ");
                    boolean isSuccess = studentService.deleteStudentByID(id);
                    if (isSuccess) {
                        System.out.println("Đã xóa sinh viên thành công.");
                    } else {
                        System.out.println("Không tìm thấy ID.");
                    }
                    break;
                case 5:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println();
        } while (choice != 5);
    }

    private Student inputDataForStudent(String type) {
        int id = -1;
        if (type.equals("add")) {
            id = inputIdStudent("Nhập ID sinh viên: ");
        }

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh sinh viên (dd/mm/yyyy): ");
        String dob = scanner.nextLine();
        System.out.print("Nhập chuyên ngành sinh viên: ");
        String major = scanner.nextLine();

        return new Student(id, name, dob, major);
    }

    private void displayStudent(List<Student> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            System.out.println("=== Danh sách sinh viên ===");
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }

    private int inputIdStudent(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Phải là một số nguyên.");
            }
        }
    }
}
