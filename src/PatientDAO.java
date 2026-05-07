import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    
    // Add Patient
    public void addPatient(String name, int age, String disease, String phone) {
        String query = "INSERT INTO patients (name, age, disease, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, disease);
            stmt.setString(4, phone);
            stmt.executeUpdate();
            System.out.println("✅ Patient added successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // View All Patients
    public void viewPatients() {
        String query = "SELECT * FROM patients";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\n--- All Patients ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name") +
                        " | Age: " + rs.getInt("age") +
                        " | Disease: " + rs.getString("disease") +
                        " | Phone: " + rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Delete Patient
    public void deletePatient(int id) {
        String query = "DELETE FROM patients WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Patient deleted successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}