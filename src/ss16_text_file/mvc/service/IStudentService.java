package ss16_text_file.mvc.service;

import ss16_text_file.mvc.model.Student;
import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    List<Student> getAllStudents();
    boolean deleteStudentByID(int id);
    void updateStudent(Student student);
    Student getStudentByID(int id);
}

