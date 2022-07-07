import java.sql.*;
import javax.swing.*;
public class dataBaseInsert {
    //public static void main(String[] args){
        dataBaseInsert(String name,String address,int number,String email,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =DriverManager.getConnection(
                 //"jdbc:myqsl://localhost:3306/java","root","root"
                    "jdbc:mysql://localhost:3306/java?useSSL=false", "root", ""
            );
            //System.out.println("Success");

            Statement stmt = con.createStatement();

            //String s = "hell";

            String sql = "INSERT INTO pass_gen VALUES(NULL,'"+name+"','"+address+"','"+number+"','"+email+"','"+password+"')";
            stmt.executeUpdate(sql);

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,"Registered Successfully");
            ResultSet rs = stmt.executeQuery("select * from pass_gen");
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "
                +rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
            }







            con.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }

}
