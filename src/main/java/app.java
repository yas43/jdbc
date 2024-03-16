
import java.sql.*;

public class app {
    Connection connection;
    public static void main(String[] args)  {
        app my_app = new app();
        my_app.jdbcconection();
    }

   public void jdbcconection (){
       String sql = "SELECT postalcode FROM clientes WHERE country='india'";
       String url = "jdbc:postgresql://localhost:5432/test";
       String username = "yaser";
       String password = "123456";
       try {
            connection = DriverManager.getConnection(url,username,password);
           read_data();
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
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM clientes;");
            rs.next();
            String contact_name = rs.getString(1);
            System.out.println(contact_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void read_data(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM clientes");
            while (rs.next()){
                String contact_name = rs.getString(1);
                String address = rs.getString(2);
                String city = rs.getString(3);
                String postal_code = rs.getString(4);
                String country = rs.getString(5);
                System.out.println("contact_name = "+ contact_name+"address = "+address+"city = "+city+"\n"+
                        "postal_code = "+postal_code+"county = "+country );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
