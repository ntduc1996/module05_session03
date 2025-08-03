package ra.session03_btvn.dao.imp;



import ra.session03_btvn.dao.StudentDAO;
import ra.session03_btvn.entity.Student;
import ra.session03_btvn.ulti.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImp implements StudentDAO {
    @Override
    public List<Student> getAllStudents() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> listStudent = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_student()}");
            ResultSet rs = callSt.executeQuery();
            listStudent = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentAge(rs.getInt("student_age"));
                student.setStudentAddress(rs.getString("student_address"));
                listStudent.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStudent;
    }

    @Override
    public Student getStudentById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Student student = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_student_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentAge(rs.getInt("student_age"));
                student.setStudentAddress(rs.getString("student_address"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return student;
    }

    @Override
    public boolean addStudent(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_student(?,?,?)}");
            callSt.setString(1, student.getStudentName());
            callSt.setInt(2, student.getStudentAge());
            callSt.setString(3, student.getStudentAddress());
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_student(?,?,?,?)}");
            callSt.setInt(1, student.getId());
            callSt.setString(2, student.getStudentName());
            callSt.setInt(3, student.getStudentAge());
            callSt.setString(4, student.getStudentAddress());
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_student(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
