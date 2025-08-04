package ra.session03_btvn.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ra.session03_btvn.entity.Admin;
import ra.session03_btvn.service.AdminService;
import ra.session03_btvn.service.Imp.AdminServiceImp;

import java.io.IOException;

@WebServlet(name = "AdminController", value = "/AdminController")
public class AdminController extends HttpServlet {
    private AdminService adminService;

    public AdminController() {
        adminService = new AdminServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("login")) {
           Admin admin = new Admin();
           admin.setUsername(request.getParameter("username"));
           admin.setPassword(request.getParameter("password"));
           boolean result = adminService.loginAdmin(admin);
           if(result){
               response.sendRedirect("/StudentController?action=findAll");
           }else {
               request.getRequestDispatcher("views/error.jsp").forward(request, response);
           }
        }

    }
}