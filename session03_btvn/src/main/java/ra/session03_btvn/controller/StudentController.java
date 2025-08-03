package ra.session03_btvn.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.session03_btvn.entity.Student;
import ra.session03_btvn.service.Imp.StudentServiceImp;
import ra.session03_btvn.service.StudentService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/StudentController")
public class StudentController extends HttpServlet {
    private StudentService studentService ;

    public StudentController() {
        studentService = new StudentServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("findAll")) {
            getAllStudent(req, resp);
        } else if (action.equals("initUpdate")) {
            int studentId = Integer.parseInt(req.getParameter("studentId"));
            Student student = studentService.getStudentById(studentId);
            req.setAttribute("student", student);
            req.getRequestDispatcher("views/updateStudent.jsp").forward(req, resp);
        } else if (action.equals("Delete")) {
            int studentId = Integer.parseInt(req.getParameter("studentId"));
            boolean result = studentService.deleteStudent(studentId);
            if (result) {
                getAllStudent(req, resp);
            } else {
                req.getRequestDispatcher("views/error.jsp").forward(req, resp);
            }
        }
    }
    public void getAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.getAllStudents();
        //add student vào request
        request.setAttribute("studentList", studentList);
        //Chuyển request và response sang view
        request.getRequestDispatcher("/views/Students.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action.equals("Create")) {
            //Thực hiện thêm mới
            //1. Lấy dữ liệu submit từ form trong request
            Student student = new Student();
            student.setStudentName(req.getParameter("studentName"));
            student.setStudentAge(Integer.parseInt(req.getParameter("studentAge")));
            student.setStudentAddress(req.getParameter("studentAddress"));
            //2. Gọi sang service thực hiện thêm mới
            boolean result = studentService.createStudent(student);
            //3. Xử lý kết quả service trả về
            if (result) {
                getAllStudent(req, resp);
            } else {
                req.getRequestDispatcher("views/error.jsp").forward(req, resp);
            }
        } else if (action.equals("Update")) {
            //Thực hiện cập nhật danh mục
            //1. Lấy dữ liệu trên form
            Student student = new Student();
            student.setId(Integer.parseInt(req.getParameter("studentId")));
            student.setStudentName(req.getParameter("studentName"));
            student.setStudentAge(Integer.parseInt(req.getParameter("studentAge")));
            student.setStudentAddress(req.getParameter("studentAddress"));
            //2. Gọi service thực hiện cập nhật
            boolean result = studentService.updateStudent(student);
            //3. Xử lý kết quả
            if (result) {
               getAllStudent(req, resp);
            } else {
                req.getRequestDispatcher("views/error.jsp").forward(req, resp   );
            }
        }

    }
}
