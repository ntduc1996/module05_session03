package ra.session03_btvn.dao;


import ra.session03_btvn.entity.Admin;

public interface AdminDAO {
    Admin loginAdmin(String username, String password);

}
