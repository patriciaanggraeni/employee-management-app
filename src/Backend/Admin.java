
package Backend;

import DBConfig.DBHelper;
import Frontend.FormLogin;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Admin implements IQueryMethod {
    private int idAdmin;
    private String username;
    private String password;

    public Admin() {}

    public Admin(int idAdmin,String username, String password) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String  getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public Admin getByid(int id) {
        Admin admin = new Admin();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM user "+
                                            " WHERE id_user = '" + id + "'");
        
        try {
            while(rs.next()) {
                admin = new Admin();
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return admin;
    }
    
    @Override
    public ArrayList<Admin> getAll() {
        ArrayList<Admin> listUser = new ArrayList();
        
         ResultSet rs = DBHelper.selectQuery("SELECT * FROM user ");
         
         try {
             while(rs.next()) {
                 Admin admin = new Admin();
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                 
                 listUser.add(admin);
             }
         } catch(Exception e) {
             
         }
         
         return listUser;
    }
    
    @Override
    public ArrayList<Admin> search(String keyword) {
        ArrayList<Admin> listUser = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM admin " + 
                                            " WHERE username LIKE '%" + keyword + "%'" + 
                                            " OR password LIKE '%" + keyword + "%'");
        
        try {
            while(rs.next()) {
                Admin admin = new Admin();
                admin.setIdAdmin(rs.getInt("id_admin"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                
                listUser.add(admin);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }
    
    
    @Override
    public void save() {
        if (getIdAdmin() == 0) {
            String SQL = "INSERT INTO admin (username, password) VALUES ("
                    + "     '" + this.username + "', "
                    + "     '" + this.password + "' "
                    + " )";
            this.idAdmin = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE admin SET "
                    + " nip='" + this.username + "', "
                    + " password='" + this.password + "' "
                    + " WHERE id_admin='" + this.idAdmin + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    @Override
    public void delete() {
        String SQL = "DELETE FROM user WHERE id_admin='" + this.idAdmin + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public boolean login(String username, String password) {
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM admin " + 
                                            " WHERE username ='" + username + "'" + 
                                            " AND password ='" + password + "'");
        boolean result = false;
       
        try {
            
            if (rs.next()) { result = true; } 
            
            else {
                JOptionPane.showInternalMessageDialog(null, "Password atau Usename Salah!");
                result = false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public String getInfoAdmin() {
        String totalAdmin = "";
        
        ResultSet rs = DBHelper.selectQuery("SELECT COUNT(*) AS count FROM admin");
        
        try {
            while(rs.next()) {
                totalAdmin = rs.getString("count");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error when getting information");
        }
        return totalAdmin;
    }
}
