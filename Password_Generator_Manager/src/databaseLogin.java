import java.sql.*;
public class databaseLogin {
    Connection con;
    databaseLogin() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(
                        //"jdbc:myqsl://localhost:3306/java","root","root"
                        "jdbc:mysql://localhost:3306/java?useSSL=false", "root", ""
                );
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
