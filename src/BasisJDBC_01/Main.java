package BasisJDBC_01;

import java.sql.*;

//import com.mysql.cj.jdbc.StatementImpl;

public class Main
{
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        // Class.forName() will execute static block of Driver class
        // where Driver class's object will be created

        System.out.println("Driver is registered");

        // SQL statement means SQL query

        // ArrayList arrayList=new ArrayList();

        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

        Statement statement=connection.createStatement();

        statement.executeUpdate("insert into employess values(101,'aditya',900000)");

        System.out.println("Done");

    }
}
