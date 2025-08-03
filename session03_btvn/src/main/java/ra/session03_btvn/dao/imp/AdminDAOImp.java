package ra.session03_btvn.dao.imp;




import ra.session03_btvn.dao.AdminDAO;
import ra.session03_btvn.entity.Admin;
import ra.session03_btvn.ulti.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class AdminDAOImp implements AdminDAO {
    @Override
    public Admin loginAdmin(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        Admin admin = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call login_admin(?, ?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                admin = new Admin(rs.getString("username"), rs.getString("password"));
                return admin;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return null;
    }
}
