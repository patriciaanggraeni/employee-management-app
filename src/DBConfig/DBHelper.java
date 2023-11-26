package DBConfig;

import java.sql.*;
import javax.swing.JOptionPane;


public class DBHelper {
    
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/kepegawaian";
    private static final String DB_USER = "AnggaSusilo";
    private static final String DB_PASSWORD = "Anggara27042022";
    
    private static Connection koneksi;
    
    public static void connectToDatabase() {
        if (koneksi == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static int insertQueryGetId(String query) {
        connectToDatabase();
        int num = 0;
        int result = -1;

        try {
            Statement stmt = koneksi.createStatement();
            num = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                result = rs.getInt(1);
            }
            
            rs.close();
            stmt.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }
    
    public static boolean executeQuery(String query) {
        connectToDatabase();
        boolean result = false;

        try {
            Statement stmt = koneksi.createStatement();
            stmt.executeUpdate(query);

            result = true;

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet selectQuery(String query) {
        connectToDatabase();
        ResultSet rs = null;

        try {
            Statement stmt = koneksi.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}