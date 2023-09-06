package BasicJDBC_02;

import java.sql.*;

public class RetriveProducts {
    public static Product getproducts(int pid) throws SQLException, ProductNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ministore","root","root");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from product where pid="+pid);
        if(rs.next()){
            return new Product(rs.getInt("pid"), rs.getString("pnm"), rs.getDouble("pcost"), rs.getInt("pstock"));
        }else{
            throw new ProductNotFoundException("Record not found for the id "+pid);
        }


    }


    public static void main(String[] args) {

        try{
            Product product = RetriveProducts.getproducts(101);
            System.out.println(product);
        }catch (SQLException | ProductNotFoundException e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
