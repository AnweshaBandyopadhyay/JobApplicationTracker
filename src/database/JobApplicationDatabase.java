package database;

import model.JobApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JobApplicationDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/job_tracker";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789"; // 🔁 Replace with your actual password

    public static boolean insertJob(JobApplication job) {
        String sql = "INSERT INTO job_applications (company, title, date, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, job.getCompany());
            stmt.setString(2, job.getTitle());
            stmt.setString(3, job.getDate().toString()); // assuming LocalDate
            stmt.setString(4, job.getStatus());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace(); // for now
            return false;
        }
    }
}
