package ra.session03_btvn.service.Imp;




import ra.session03_btvn.dao.StudentDAO;
import ra.session03_btvn.dao.imp.StudentDAOImp;
import ra.session03_btvn.entity.Student;
import ra.session03_btvn.service.StudentService;

import java.util.List;

public class StudentServiceImp implements StudentService {
    private StudentDAO studentDAO ;

    public StudentServiceImp() {
        studentDAO = new StudentDAOImp();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public boolean createStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDAO.deleteStudent(id);
    }
}
