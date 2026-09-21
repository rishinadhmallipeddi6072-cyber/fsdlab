import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete {

    public static void main(String[] args) {

        try {

            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to Database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/fsdlab",
                    "root",
                    "systemmanager"
            );

            System.out.println("Database Connected Successfully!");

            // Delete Query
            String sql = "DELETE FROM csed WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            // ID of record to delete
            ps.setInt(1, 101);

            // Execute Delete
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record Deleted Successfully!");
            } else {
                System.out.println("No record found with ID 101.");
            }

            // Close resources
            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {

            System.out.println("MySQL Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Database operation failed!");
            e.printStackTrace();
        }
    }
}