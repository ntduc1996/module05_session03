package ra.session03_btvn.service.Imp;


import ra.session03_btvn.dao.AdminDAO;
import ra.session03_btvn.dao.imp.AdminDAOImp;
import ra.session03_btvn.entity.Admin;
import ra.session03_btvn.service.AdminService;

public class AdminServiceImp implements AdminService {
    private AdminDAO adminDAO;

    public AdminServiceImp() {
        adminDAO = new AdminDAOImp();
    }

    @Override
    public Admin loginAdmin(String username, String password) {
        return adminDAO.loginAdmin(username, password);
    }
}
