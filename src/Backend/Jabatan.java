package Backend;

import DBConfig.*;
import java.sql.*;
import java.util.ArrayList;

public class Jabatan implements IQueryMethod {
    
    private int idJabatan;
    private String jabatan;
    private int tunjanganJabatan ;

    public Jabatan() {} 

    public Jabatan(String jabatan, int tunjanganJabatan) {
        this.jabatan = jabatan;
        this.tunjanganJabatan = tunjanganJabatan;
    }

    public int getIdJabatan() {
        return this.idJabatan;
    }

    public String getJabatan() {
        return this.jabatan;
    }
    
    public int getTunjanganJabatan() {
        return this.tunjanganJabatan;
    }
    
    public void setIdJabatan(int idJabatan) {
        this.idJabatan = idJabatan;
    }
    
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    public void setTunjanganJabatan(int tunjanganJabatan) {
        this.tunjanganJabatan = tunjanganJabatan;
    }
    
    @Override
    public Jabatan getByid(int id) {
        Jabatan jabatan = new Jabatan();  
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM jabatan WHERE id_jabatan = '" + id + "'");
        
        try {
            while(rs.next()) {
                jabatan = new Jabatan();
                jabatan.setIdJabatan(rs.getInt("id_jabatan"));
                jabatan.setJabatan(rs.getString("jabatan"));
                jabatan.setTunjanganJabatan(rs.getInt("tunjangan_jabatan"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return jabatan;
    }
    
    public String toString() {
        return String.valueOf(this.idJabatan);
    }
    
    @Override
    public ArrayList<Jabatan> getAll() {
        ArrayList<Jabatan> listJabatan = new ArrayList<Jabatan>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM jabatan;");
        
        try {
            while(rs.next()) {
                Jabatan jabatan = new Jabatan();
                jabatan.setIdJabatan(rs.getInt("id_jabatan"));
                jabatan.setJabatan(rs.getString("jabatan"));
                jabatan.setTunjanganJabatan(rs.getInt("tunjangan_jabatan"));
                
                listJabatan.add(jabatan);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return listJabatan;
    }
   
    
    @Override
    public ArrayList<Jabatan> search(String keyword) {
        ArrayList<Jabatan> ListJabatan = new ArrayList<Jabatan>();
        
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM jabatan WHERE jabatan LIKE '%" + keyword + "%';");
        
        try {
            while(rs.next()) {
                Jabatan jabatan = new Jabatan();
                jabatan.setIdJabatan(rs.getInt("id_jabatan"));
                jabatan.setJabatan(rs.getString("jabatan"));
                jabatan.setTunjanganJabatan(rs.getInt("tunjangan_jabatan"));
                
                ListJabatan.add(jabatan);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return ListJabatan;
    }
    
    @Override
    public void save() {
        if(getIdJabatan() == 0) {
            String SQL = "INSERT INTO jabatan VALUES (" + "'" 
                    + this.jabatan + "'," 
                    + this.tunjanganJabatan 
                    + ")";
            this.idJabatan = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE jabatan SET "
                    + " jabatan ='" + this.jabatan + "' "
                    + " tunjangan_jabatan ='" + this.tunjanganJabatan + "' "
                    + " WHERE id_jabatan='" + this.idJabatan + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    @Override
    public void delete() {
        String SQL = "DELETE FROM jabatan WHERE id_jabatan='" + this.idJabatan + "'";
        DBHelper.executeQuery(SQL);
    }
}

    

