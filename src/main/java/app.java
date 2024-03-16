
import java.sql.*;

public class app {
    Connection connection;
    public static void main(String[] args)  {

    }

   public void jdbcconection (){
       String sql = "SELECT postalcode FROM clientes WHERE country='india'";
       String url = "jdbc:postgresql://localhost:5432/test";
       String username = "yaser";
       String password = "123456";
       try {
           Connection connection = DriverManager.getConnection(url,username,password);
           method();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       finally {
           try {
               if(!connection.isClosed()){
                   connection.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }

   }

    private void method() {
    }


    private void readdata(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM student");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
