import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/fsdlab",
                    "root",
                    "systemmanager"
            );

            System.out.println("Database Connected Successfully!");

            con.close();

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}