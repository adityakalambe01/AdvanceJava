package Day02_BasicJDBC_ProductRetrieve;

import java.sql.*;

public class RetrieveProductsMain {
    public static Product getproducts(int pid) throws SQLException, ProductNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ministore","root","root");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from product where pid="+pid);
        if(rs.next()){
            return new Product(rs.getInt("pid"),
                    rs.getString("pnm"),
                    rs.getDouble("pcost"),
                    rs.getInt("pstock"));
        }else{
            throw new ProductNotFoundException("Record not found for the id "+pid);
        }


    }


    public static void main(String[] args) {

        try{
            Product product = RetrieveProductsMain.getproducts(1);
            System.out.println(product);
        }catch (SQLException | ProductNotFoundException e){
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
