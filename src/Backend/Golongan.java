package Backend;

import DBConfig.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Golongan implements IQueryMethod { 
    
    private int idGolongan;
    private String golongan;
    private int tunjanganUmum;
    
    public Golongan() {}
    
    public Golongan(String golongan, int tunjanganUmum) { 
        this.golongan = golongan;
        this.tunjanganUmum = tunjanganUmum;
    }
    
    public int getIdGolongan() {
      return this.idGolongan;
    }
    
    public String getGolongan() {
        return this.golongan;
    }
    
    public int getTunjanganUmum() {
        return this.tunjanganUmum;
    }
    
    public void setIdGolongan(int idGolongan) {
        this.idGolongan = idGolongan;
    }
    
    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }
    
    public void setTunjanganUmum(int tunjanganUmum) {
        this.tunjanganUmum = tunjanganUmum;
    }

    @Override
    public Golongan getByid(int id) {
        Golongan golongan = new Golongan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM golongan WHERE id_golongan = '" + id + "';");

        try {
            while (rs.next()) {
                golongan = new Golongan();
                golongan.setIdGolongan(rs.getInt("id_golongan"));
                golongan.setGolongan(rs.getString("golongan"));
                golongan.setTunjanganUmum(rs.getInt("tunjangan_umum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return golongan;
    }
    
    @Override
    public ArrayList<Golongan> getAll() {
        ArrayList<Golongan> listGolongan = new ArrayList<Golongan>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM golongan;");

        try {
            while (rs.next()) {
                Golongan golongan = new Golongan();
                golongan.setIdGolongan(rs.getInt("id_golongan"));
                golongan.setGolongan(rs.getString("golongan"));
                golongan.setTunjanganUmum(rs.getInt("tunjangan_umum"));
                listGolongan.add(golongan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listGolongan;
    }
    
    public String toString() {
        return String.valueOf(this.idGolongan);
    }
    
    @Override
    public ArrayList<Golongan> search(String keyword) {
        ArrayList<Golongan> ListGolongan = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM golongan WHERE "
                + " id_golongan LIKE '%" + Integer.parseInt(keyword) + "%' "
                + " OR golongan LIKE '%" + keyword + "%' "
                + " OR tunjangan_umum LIKE '%" + Integer.parseInt(keyword) + "%' "
        );

        try {
            while (rs.next()) {
                Golongan golongan = new Golongan();
                golongan.setIdGolongan(rs.getInt("id_golongan"));
                golongan.setGolongan(rs.getString("golongan"));
                golongan.setTunjanganUmum(rs.getInt("tunjangan_umum"));

                ListGolongan.add(golongan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListGolongan;
    }
    
    @Override
    public void save() {
        if (getIdGolongan() == 0) {
            String SQL = "INSERT INTO golongan VALUES ("
                    + "     '" + this.golongan + "', "
                    + "     '" + this.tunjanganUmum + "', "
                    + " )";
            this.idGolongan = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE golongan SET "
                    + " id_golongan ='" + this.golongan + "', "
                    + " tunjangan_umum = '" + this.tunjanganUmum + "', "
                    + " WHERE id_golongan ='" + this.idGolongan + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    @Override
    public void delete() {
        String SQL = "DELETE FROM golongan WHERE id_golongan ='" + this.idGolongan + "'";
        DBHelper.executeQuery(SQL);
    }
     
}
