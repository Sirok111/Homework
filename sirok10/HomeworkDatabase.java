package sirok10;

import java.sql.*;

public class HomeworkDatabase {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database_name";  // Змініть на ваше ім'я бази даних
        String username = "root";  // Ваше ім'я користувача
        String password = "password";  // Ваш пароль

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            // 1. Створення таблиці Homework (DDL)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Homework ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(255) NOT NULL, "
                    + "description TEXT)";
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(createTableSQL);
                System.out.println("Table 'Homework' created successfully.");
            }

            // 2. Вставка даних (DML - INSERT)
            String insertSQL = "INSERT INTO Homework (name, description) VALUES (?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
                pstmt.setString(1, "Math Homework");
                pstmt.setString(2, "Solve problems on algebra");
                pstmt.executeUpdate();
                System.out.println("Data inserted into 'Homework' table.");
            }

            // 3. Оновлення даних (DML - UPDATE)
            String updateSQL = "UPDATE Homework SET description = ? WHERE name = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
                pstmt.setString(1, "Solve advanced problems on algebra");
                pstmt.setString(2, "Math Homework");
                pstmt.executeUpdate();
                System.out.println("Data updated in 'Homework' table.");
            }

            // 4. Вибірка даних (DML - SELECT)
            String selectSQL = "SELECT * FROM Homework";
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    System.out.println("ID: " + id + ", Name: " + name + ", Description: " + description);
                }
            }

            // 5. Видалення записів (DML - DELETE)
            String deleteSQL = "DELETE FROM Homework WHERE name = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
                pstmt.setString(1, "Math Homework");
                pstmt.executeUpdate();
                System.out.println("Data deleted from 'Homework' table.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

