package BasisJDBC_01;

import java.sql.*;
import java.util.ArrayList;

class ResultSetExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from students");
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("StudentName");
            studentsArrayList.add(new Student(id,name));
        }
        System.out.println(studentsArrayList);

    }
}