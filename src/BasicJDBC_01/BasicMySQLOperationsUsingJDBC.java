package BasicJDBC_01;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class BasicMySQLOperationsUsingJDBC {
    static Connection connection;
    static PreparedStatement ptmt;
    static Scanner myScanner = new Scanner(System.in);

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static PreparedStatement preparedStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    static Statement statement() throws SQLException{
        return connection.createStatement();
    }

    static ResultSet resultSet(String sql) throws SQLException{
        return statement().executeQuery(sql);
    }
    //update records
    static void updateStatement() throws SQLException{
        ptmt = BasicMySQLOperationsUsingJDBC.preparedStatement("update students set StudentName=? where id = ?");
        System.out.println("Enter id to change name: ");
        ptmt.setInt(2,myScanner.nextInt());
        myScanner.nextLine();
        System.out.println("Enter Name");
        ptmt.setString(1, myScanner.nextLine());
        ptmt.executeUpdate();
    }
    //delete records using id
    static void deleteStatement() throws SQLException{
        ptmt = BasicMySQLOperationsUsingJDBC.preparedStatement("delete from students where id=?;");
        System.out.print("Enter id to delete: ");
        ptmt.setInt(1,myScanner.nextInt());
        ptmt.executeUpdate();
    }
    //insert records into table
    static void insertStatement() throws SQLException{
        ptmt = BasicMySQLOperationsUsingJDBC.preparedStatement("insert into students(StudentName) values (?);");
        System.out.print("Enter name: ");
        ptmt.setString(1, myScanner.nextLine());
        ptmt.executeUpdate();
        System.out.println("Record Inserted");
    }
    //select statement
    static void selectStatement() throws SQLException{
        ResultSet rs = BasicMySQLOperationsUsingJDBC.resultSet("select * from students");
        ArrayList<Student> studArrayList = new ArrayList<>();
        System.out.println();
        while (rs.next()){
            studArrayList.add(new Student(rs.getInt("id"),rs.getString("StudentName")));
        }
        System.out.println(studArrayList);

    }
    //Main method
    public static void main(String[] args) throws SQLException {
        BasicMySQLOperationsUsingJDBC.updateStatement();

        BasicMySQLOperationsUsingJDBC.deleteStatement();

        BasicMySQLOperationsUsingJDBC.insertStatement();

        BasicMySQLOperationsUsingJDBC.selectStatement();

    }
}
