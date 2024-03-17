
import java.sql.*;


public class app {
    Connection connection;
    public static void main(String[] args)  {
        app my_app = new app();
        my_app.jdbcconection();
    }

   public void jdbcconection (){
       String sql = "SELECT * FROM student";
       String url = "jdbc:mysql://localhost:3306/openclassroom?useSSL=false";
       String username = "root";
       String password = "fa946342036ec59c2302";
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection(url,username,password);
           method();
       } catch (Exception e) {
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
            ResultSet rs = statement.executeQuery("SELECT * FROM student;");
            rs.next();
            String name = rs.getString(1);
            System.out.println(name);
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


    private void write_data(){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO clientes (contactname,address,city,postalcode,country) " +
                    "values ('jeferson','10 rue manson','rome','6215','italy')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update(){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE clientes SET city='rennes' WHERE contactname='keshtdar'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
