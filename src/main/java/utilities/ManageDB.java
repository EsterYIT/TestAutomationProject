package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps{

    public static void openConnection(String dbUrl, String user, String pass)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, user, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while connecting to DB: " + e);
        }
    }

    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while closing DB: " + e);
        }
    }
}
