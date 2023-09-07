package Day03_JDBC;

import java.sql.*;
import static Credentials.MySQL.*;

public class CallingFunction {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(url+"db_function",username,password);

        CallableStatement callableStatement =connection.prepareCall("{?=call addition(?,?)}");
        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.setInt(2,25);
        callableStatement.setInt(3,25);
        callableStatement.execute();
        int result = callableStatement.getInt(1);
        System.out.println(result);
    }
}
