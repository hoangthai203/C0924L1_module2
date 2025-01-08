package ss16_text_file.mvc.service;

import ss16_text_file.mvc.model.Student;
import ss16_text_file.mvc.util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private final String FILE_PATH = "src/ss16_text_file/mvc/data/students.csv";

    @Override
    public void addStudent(Student student) {
        List<String> data = ReadAndWriteFile.readFile(FILE_PATH);
        data.add(student.toCSV());
        ReadAndWriteFile.writeFile(FILE_PATH, data, false);
    }

    @Override
    public List<Student> getAllStudents() {
        List<String> data = ReadAndWriteFile.readFile(FILE_PATH);
        List<Student> students = new ArrayList<>();
        for (String line : data) {
            Student student = Student.fromCSV(line);
            if (student != null) {
                students.add(student);
            }
        }
        return students;
    }

    @Override
    public boolean deleteStudentByID(int id) {
        List<Student> students = getAllStudents();
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            saveAll(students);
        }
        return found;
    }

    @Override
    public void updateStudent(Student student) {
        List<Student> students = getAllStudents();
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                found = true;
                break;
            }
        }

        if (found) {
            saveAll(students);
        }
    }

    @Override
    public Student getStudentByID(int id) {
        List<Student> students = getAllStudents();
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private void saveAll(List<Student> students) {
        List<String> data = new ArrayList<>();
        for (Student student : students) {
            data.add(student.toCSV());
        }
        ReadAndWriteFile.writeFile(FILE_PATH, data, false);
    }
}
