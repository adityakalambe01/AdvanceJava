package Day03_JDBC;

import java.sql.*;


import static Credentials.MySQL.*;

public class CallingProcedure {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(url+"db_function",username,password);
        CallableStatement cs=connection.prepareCall("{call addition_procedure(?,?,?)}");


        cs.registerOutParameter(3, Types.INTEGER);

        cs.setInt(1, 10);
        cs.setInt(2, 20);

        cs.execute();

        int sum=cs.getInt(3);

        System.out.println(sum);
    }
}
