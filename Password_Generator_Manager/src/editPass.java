import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class editPass extends JFrame{
    editPass(int user_id){
        this.setSize(350, 300);

        databaseLogin login = new databaseLogin();

        JLabel id= new JLabel("ID");
        id.setBounds(20,30,80,30);
        this.add(id);

        JLabel service = new JLabel("Service");
        service.setBounds(20,70,80,30);
        this.add(service);

        JLabel password = new JLabel("Password");
        password.setBounds(20,110,80,30);
        this.add(password);

        JTextField tfid = new JTextField();
        tfid.setBounds(120,30,150,30);
        this.add(tfid);

        JTextField tfs = new JTextField();
        tfs.setBounds(120,70,150,30);
        this.add(tfs);

        JTextField tfp = new JTextField();
        tfp.setBounds(120,110,150,30);
        this.add(tfp);

        JButton save = new JButton("Save");
        save.setBounds(135,200,80,30);
        this.add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    Statement stmt = login.con.createStatement();
                    String sql = "UPDATE user_data SET pass_id='"+tfid.getText()+"',password='"+tfp.getText()+"',password_desc='"+tfs.getText()+"'WHERE pass_id='"+tfid.getText()+"'and user_id='"+user_id+"'";
                    stmt.executeUpdate(sql);
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Updated Successful");
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
    /*public static void main(String[] args){
       editPass pass = new editPass(2);
    }*/
    }
