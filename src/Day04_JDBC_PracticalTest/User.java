package Day04_JDBC_PracticalTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String username;
    private String password;
    private long mobileNumber;
    private String emailId;
    static final String jdbcURL = "jdbc:mysql://localhost:3306/tka";
    static final String jdbcUsername = "root";
    static final String jdbcPassword = "root";

    /*Constructor, getters, and setters for User class*/

    // Define a constructor for User
    public User(String username, String password, long mobileNumber, String emailId) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
    }

    // Getter and Setter methods for User class
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }

    // Method to insert a new user into the database
    public static void save(User user) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String insertQuery = "INSERT INTO users (username, password, mobileNumber, emailId) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getMobileNumber());
            preparedStatement.setString(4, user.getEmailId());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Method to retrieve a user by username
    public static User get(String username) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String selectQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String password = resultSet.getString("password");
                Long mobileNumber = resultSet.getLong("mobilenumber");
                String emailId = resultSet.getString("emailid");

                return new User(username, password, mobileNumber, emailId);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        User user1 = new User("aditya", "password123", 1234567890, "aditya@example.com");
        User.save(user1);

        User retrievedUser = User.get("aditya");
        if (retrievedUser != null) {
            System.out.printf("Username: %s\nMobile Number: %s\nEmail Id.: %s",retrievedUser.getUsername(),retrievedUser.getMobileNumber(),retrievedUser.getEmailId());
        } else {
            System.out.println("User not found.");
        }

    }
}
