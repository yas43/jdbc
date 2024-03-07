
import java.sql.*;

public class app {
    public static void main(String[] args) throws Exception {
        String sql = "SELECT postalcode FROM clientes WHERE country='india'";
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "yaser";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);
         resultset.next();
        String postalcode = resultset.getString(1);
        System.out.println(postalcode);


    }
}
