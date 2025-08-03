package ra.session03_btvn.service;


import ra.session03_btvn.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    boolean createStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
}
