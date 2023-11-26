package Backend;

import DBConfig.DBHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Penggajian implements IQueryMethod {
    private int idPenggajian;
    private String tglPenggajian;
    private int totalGaji;
    private int gajiPokok;
    
    private Pegawai pegawai = new Pegawai();

    public Penggajian() {}

    public Penggajian(Pegawai pegawai,  String tglPenggajian, int totalGaji, int gajiPokok) {
        this.tglPenggajian = tglPenggajian;
        this.totalGaji = totalGaji;
        this.gajiPokok = gajiPokok;
        
        this.pegawai = pegawai;
        
    }

    public int getIdPenggajian() {
        return idPenggajian;
    }

    public void setIdPenggajian(int idPenggajian) {
        this.idPenggajian = idPenggajian;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }
     public void setTglPenggajian(String tglPenggajian) {
        this.tglPenggajian = tglPenggajian;
    }

    public String getTglPenggajian() {
        return tglPenggajian;
    }

    public int getTotalGaji() {
        return this.totalGaji;
    }

    public void setTotalGaji(int totalGaji) {
        this.totalGaji = totalGaji;
    }

    public int getGajiPokok() {
        return this.gajiPokok;
    }

    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }
    
    @Override
    public Penggajian getByid(int id) {
        Penggajian penggajian = new Penggajian();
        
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "pj.id_penggajian AS id_penggajian, "
                + "p.id_pegawai AS id_pegawai, "
                + "pj.gaji_pokok AS gaji_pokok, "
                + "pj.tgl_penggajian AS tgl_penggajian, "
                + "pj.total_gaji AS total_gaji "
                + "FROM penggajian AS pj "
                + "LEFT JOIN pegawai AS p ON p.id_pegawai = pj.id_pegawai "
                + "WHERE id_penggajian = '" + id + "'");
        
        try {
            while(rs.next()) {
                penggajian = new Penggajian();
                
                penggajian.setIdPenggajian(rs.getInt("id_penggajian"));
                penggajian.getPegawai().setIdPegawai(rs.getInt("id_pegawai"));
                penggajian.setGajiPokok(rs.getInt("gaji_pokok"));
                penggajian.setTglPenggajian(rs.getString("tgl_penggajian"));
                penggajian.setTotalGaji(rs.getInt(("total_gaji")));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return penggajian;
    }
    
    @Override
    public ArrayList<Penggajian> getAll() {
        ArrayList<Penggajian> listPenggajian = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "pj.id_penggajian AS id_penggajian, "
                + "p.id_pegawai AS id_pegawai, "
                + "p.nip AS nip, "
                + "p.nama AS nama, "
                + "pj.gaji_pokok AS gaji_pokok, "
                + "pj.tgl_penggajian AS tgl_penggajian, "
                + "pj.total_gaji AS total_gaji "
                + "FROM penggajian AS pj "
                + "LEFT JOIN pegawai AS p ON p.id_pegawai = pj.id_pegawai;");
        
        try {
            while(rs.next()) {
                Penggajian penggajian = new Penggajian();
                
                penggajian.setIdPenggajian(rs.getInt("id_penggajian"));
                penggajian.getPegawai().setIdPegawai(rs.getInt("id_pegawai"));
                penggajian.getPegawai().setNama(rs.getString("nama"));
                penggajian.getPegawai().setNip(rs.getString("nip"));
                penggajian.setGajiPokok(rs.getInt("gaji_pokok"));
                penggajian.setTglPenggajian(rs.getString("tgl_penggajian"));
                penggajian.setTotalGaji(rs.getInt("total_gaji"));
                
                listPenggajian.add(penggajian);
            }
        } catch(Exception e) {
          e.printStackTrace();
        }
        
        return listPenggajian;
    }
    
    @Override
    public ArrayList<Penggajian> search(String keyword) {
        ArrayList<Penggajian> listPenggajian= new ArrayList();
 
        ResultSet rs = DBHelper.selectQuery("SELECT "
            + "pj.id_penggajian AS id_penggajian, "
            + "p.id_pegawai AS id_pegawai, "
            + "p.nip AS nip,"
            + "pj.gaji_pokok AS gaji_pokok, "
            + "pj.tgl_penggajian AS tgl_penggajian, "
            + "pj.total_gaji AS total_gaji "
            + "FROM penggajian AS pj "
            + "LEFT JOIN pegawai AS p ON p.id_pegawai = pj.id_pegawai "
            + "WHERE pj.gaji_pokok LIKE '%" + keyword + "%' "
            + "OR p.id_pegawai LIKE '%" + keyword + "%' "
            + "OR p.nip LIKE '%" + keyword + "%' "
            + "OR pj.tgl_penggajian LIKE '% " + keyword + "%' "
            + "OR pj.total_gaji LIKE '%" + keyword + "%';");
        
        try {
            while(rs.next()) {
                Penggajian penggajian = new Penggajian();
                Jabatan jabatan = new Jabatan();
                
                penggajian.setIdPenggajian(rs.getInt("id_penggajian"));
                penggajian.getPegawai().setIdPegawai(rs.getInt("id_pegawai"));
                penggajian.setGajiPokok(rs.getInt("gaji_pokok"));
                penggajian.setTglPenggajian(rs.getString("tgl_penggajian"));
                penggajian.setTotalGaji(rs.getInt("total_gaji"));
                
                listPenggajian.add(penggajian);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listPenggajian;
    }
    
    @Override
    public void save() { 
        if (getIdPenggajian() != 0) {
            System.out.println("Heloooooooooooo");
            String SQL = "INSERT INTO penggajian (id_pegawai, gaji_pokok, tgl_penggajian, total_gaji) VALUES ("
                    + "     '" + this.getPegawai().getIdPegawai() + "', "
                    + "     '" + this.gajiPokok + "', "
                    + "     '" + this.tglPenggajian + "', "
                    + "     '" + this.getPegawai().hitungTotalGaji() + "')";
            this.idPenggajian = DBHelper.insertQueryGetId(SQL);
        } else {
            System.out.println("Updateee");
            String SQL ="UPDATE penggajian SET "
                    + " tgl_penggajian = '" + this.tglPenggajian + "', "
                    + " total_gaji = '" + this.getPegawai().hitungTotalGaji() + "' "
                    + " WHERE id_penggajian = '" + this.idPenggajian + "'; ";
            DBHelper.executeQuery(SQL);
        }
    }
    
    @Override
    public void delete() {
        String SQL = "DELETE FROM penggajian WHERE id_penggajian = '" + this.idPenggajian + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public String getInfoPenggajian() {
        String totalPenggajian = "";
        
        ResultSet rs = DBHelper.selectQuery("SELECT COUNT(*) AS count FROM penggajian");
        
        try {
            while(rs.next()) {
                totalPenggajian = rs.getString("count");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error when getting information");
        }
        return totalPenggajian;
    }
   
}