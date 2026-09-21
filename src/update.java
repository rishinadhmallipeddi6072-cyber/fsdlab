import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update {

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

            // Update Query
            String sql = "UPDATE csed SET name = ?, branch = ?, age = ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            // Set values
            ps.setString(1, "Rishinadh");
            ps.setString(2, "CSE");
            ps.setInt(3, 22);
            ps.setInt(4, 101);

            // Execute update
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record Updated Successfully!");
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