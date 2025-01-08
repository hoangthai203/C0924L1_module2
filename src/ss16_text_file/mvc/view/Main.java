package ss16_text_file.mvc.view;

import ss16_text_file.mvc.controller.StudentController;

public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        controller.showMenu();
    }
}

