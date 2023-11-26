
package Backend;

import DBConfig.*;
import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Pegawai  implements IQueryMethod {
    
    private int idPegawai;
        
    private String nip;
    private String nama;
    private String email;
    private String alamat;
    private String noTelp;
    private String tanggalLahir;
    
    private Jabatan jabatan = new Jabatan();
    private Golongan golongan = new Golongan();

    public Pegawai() {}

    public Pegawai(Jabatan jabatan, Golongan golongan, String nip, String nama, String tanggalLahir, String noTelp, String email, String alamat, int jamKerja) {
        this.nip = nip;
        this.nama = nama;
        this.email = email;
        this.noTelp = noTelp;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        
        this.jabatan = jabatan;
        this.golongan = golongan;
    }

    public int getIdPegawai() {
        return idPegawai;
    }

    public String getNip() {
        return nip;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public Golongan getGolongan() {
        return golongan;
    }

    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    public void setGolongan(Golongan golongan) {
        this.golongan = golongan;
    }

    @Override
    public Pegawai getByid(int id) {
        Pegawai pegawai = new Pegawai();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.id_pegawai AS id_pegawai, "
                + "p.nip AS nip, "
                + "p.nama AS nama, "
                + "p.id_jabatan AS id_jabatan, "
                + "p.id_golongan AS id_golongan, "
                + "j.jabatan AS jabatan, "
                + "g.golongan AS golongan, "
                + "j.tunjangan_jabatan AS tunjangan_jabatan, "
                + "g.tunjangan_umum AS tunjangan_umum, "
                + "p.tanggal_lahir AS tanggal_lahir, "
                + "p.no_telp AS no_telp, "
                + "p.email AS email, "
                + "p.alamat AS alamat "
                + "FROM pegawai AS p "
                + "LEFT JOIN golongan AS g ON p.id_golongan = g.id_golongan " 
                + "LEFT JOIN jabatan AS j ON p.id_jabatan = j.id_jabatan "
                + "WHERE id_pegawai = '" + id + "';");

        try {
            while (rs.next()) {
                pegawai = new Pegawai();
                pegawai.setIdPegawai(rs.getInt("id_pegawai"));
                pegawai.getJabatan().setIdJabatan(rs.getInt("id_jabatan"));
                pegawai.getGolongan().setIdGolongan(rs.getInt("id_golongan"));
                pegawai.setNip(rs.getString("nip"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.getJabatan().setJabatan(rs.getString("jabatan"));
                pegawai.getGolongan().setGolongan(rs.getString("golongan"));
                pegawai.setTanggalLahir(rs.getString("tanggal_lahir"));
                pegawai.setNoTelp(rs.getString("no_telp"));
                pegawai.setEmail(rs.getString("email"));
                pegawai.setAlamat(rs.getString("alamat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pegawai;
    }
    
    @Override
    public ArrayList<Pegawai> getAll() {
        Pegawai pegawai = new Pegawai();
        ArrayList<Pegawai> ListPegawai = new ArrayList<Pegawai>();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.id_pegawai AS id_pegawai, "
                + "p.nip AS nip, "
                + "p.nama AS nama, "
                + "p.id_jabatan AS id_jabatan, "
                + "p.id_golongan AS id_golongan, "
                + "j.jabatan AS jabatan, "
                + "g.golongan AS golongan, "
                + "j.tunjangan_jabatan AS tunjangan_jabatan, "
                + "g.tunjangan_umum AS tunjangan_umum, "
                + "p.tanggal_lahir AS tanggal_lahir, "
                + "p.no_telp AS no_telp, "
                + "p.email AS email, "
                + "p.alamat AS alamat "
                + "FROM pegawai AS p "
                + "LEFT JOIN golongan AS g ON p.id_golongan = g.id_golongan " 
                + "LEFT JOIN jabatan AS j ON p.id_jabatan = j.id_jabatan;");

        try {
            while (rs.next()) {
                pegawai = new Pegawai();
                pegawai.setIdPegawai(rs.getInt("id_pegawai"));
                pegawai.getJabatan().setIdJabatan(rs.getInt("id_jabatan"));
                pegawai.getGolongan().setIdGolongan(rs.getInt("id_golongan"));
                pegawai.setNip(rs.getString("nip"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.getGolongan().setGolongan(rs.getString("golongan"));
                pegawai.getJabatan().setJabatan(rs.getString("jabatan"));
                pegawai.getJabatan().setTunjanganJabatan(rs.getInt("tunjangan_jabatan"));
                pegawai.getGolongan().setTunjanganUmum(rs.getInt("tunjangan_umum"));
                pegawai.setTanggalLahir(rs.getString("tanggal_lahir"));
                pegawai.setNoTelp(rs.getString("no_telp"));
                pegawai.setEmail(rs.getString("email"));
                pegawai.setAlamat(rs.getString("alamat"));
              
                ListPegawai.add(pegawai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPegawai;
    }
    
    public String toString() {
        return this.getNip();
    }
    
    @Override
    public ArrayList<Pegawai> search(String keyword) {
        ArrayList<Pegawai> ListPegawai = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "p.id_pegawai AS id_pegawai, "
                + "p.nip AS nip, "
                + "p.nama AS nama, "
                + "j.jabatan AS jabatan, "
                + "g.golongan AS golongan, "
                + "p.tanggal_lahir AS tanggal_lahir, "
                + "p.no_telp AS no_telp, "
                + "p.email AS email, "
                + "p.alamat AS alamat "
                + "FROM pegawai AS p "
                + "LEFT JOIN golongan AS g ON g.id_golongan = p.id_golongan "
                + "LEFT JOIN jabatan AS j ON j.id_jabatan = p.id_jabatan "
                + "WHERE p.nip LIKE '%" + keyword + "%' "
                + "OR p.nama LIKE '%" + keyword + "%' " 
                + "OR j.jabatan LIKE '%" + keyword + "%' "
                + "OR g.golongan LIKE '%" + keyword + "%';");


        try {
             while(rs.next()) {
                Pegawai pegawai = new Pegawai();
                pegawai.setIdPegawai(rs.getInt("id_pegawai"));
                pegawai.setNip(rs.getString("nip"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.getJabatan().setJabatan(rs.getString("jabatan"));
                pegawai.getGolongan().setGolongan(rs.getString("golongan"));  
                pegawai.setTanggalLahir(rs.getString("tanggal_lahir"));
                pegawai.setNoTelp(rs.getString("no_telp"));
                pegawai.setEmail(rs.getString("email"));
                pegawai.setAlamat(rs.getString("alamat"));

                ListPegawai.add(pegawai);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPegawai;
    }
    
    @Override
    public void save() {
            if (getIdPegawai() == 0) {
                String SQL = "INSERT INTO pegawai (id_jabatan, id_golongan, nip, nama, tanggal_lahir, no_telp, email, alamat) VALUES ("
                    + "'" + this.getJabatan().getIdJabatan() + "', "
                    + "'" + this.getGolongan().getIdGolongan() + "', "
                    + "'" + this.nip + "', "
                    + "'" + this.nama + "', "
                    + "'" + this.tanggalLahir +"', "
                    + "'" + this.noTelp + "', "
                    + "'" + this.email + "', "
                    + "'" + this.alamat + "' "
                    + ");";
                this.idPegawai = DBHelper.insertQueryGetId(SQL);
            } else {
                String SQL = "UPDATE pegawai SET "
                    + " id_jabatan  = '" + this.getJabatan().getIdJabatan() + "', "
                    + " id_golongan = '" + this.getGolongan().getIdGolongan() + "', "
                    + " nama = '" + this.nama + "', "
                    + " tanggal_lahir = '" + this.tanggalLahir + "', "
                    + " no_telp = '" + this.noTelp + "', "
                    + " email = '" + this.email + "', "
                    + " alamat = '" + this.alamat + "', "
                    + " WHERE id_pegawai = '" + this.idPegawai + "';";
                 DBHelper.executeQuery(SQL);
        }
    }
    
    @Override
    public void delete() {
        String SQL = "DELETE FROM pegawai WHERE id_pegawai='" + this.idPegawai + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public String getInfoPegawai() {
        String totalPegawai = "";
        
        ResultSet rs = DBHelper.selectQuery("SELECT COUNT(*) AS count FROM pegawai");
        
        try {
            while(rs.next()) {
                totalPegawai = rs.getString("count");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error when getting information");
        }
        return totalPegawai;
    }
    
    public int hitungTotalGaji() {
        Penggajian pj = new Penggajian();
        ArrayList<Penggajian> penggajian = pj.search(this.getNip());
        for (int i = 0; i < penggajian.size(); i++) {
            pj.setTotalGaji(jabatan.getTunjanganJabatan() + golongan.getTunjanganUmum() + penggajian.get(i).getGajiPokok());
        
        }
        return pj.getTotalGaji();
    }
}

    

