import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class deletePass extends JFrame {
    deletePass(int user_id){
        this.setSize(350, 300);

        databaseLogin login = new databaseLogin();
        JLabel label = new JLabel("Enter the passord ID");
        label.setBounds(100,70,160,30);
        this.add(label);
        JTextField tfi = new JTextField();
        tfi.setBounds(100,100,160,30);
        this.add(tfi);

        JButton save = new JButton("Delete");
        save.setBounds(135,200,90,30);
        this.add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    Statement stmt = login.con.createStatement();
                    String sql = "delete from user_data where pass_id='"+tfi.getText()+"'";
                    stmt.executeUpdate(sql);
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Delelted Successful");
                    login.con.close();
                    disposal();
                    mainPanel main = new mainPanel(user_id);


                }catch(Exception ae){
                    System.out.println(ae);
                }
            }
        });

        this.setLayout(null);
        this.setVisible(true);
    }
    void disposal(){
        this.dispose();
    }
   /* public static void main(String[] args){
        deletePass delete = new deletePass(2);
    }*/
}
