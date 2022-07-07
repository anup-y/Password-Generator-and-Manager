import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class addPass extends JFrame{
    addPass(int user_id,String savepass){
        this.setSize(350, 300);

        databaseLogin login = new databaseLogin();

       JLabel service = new JLabel("Service");
       service.setBounds(20,50,80,30);
       this.add(service);

        JLabel password = new JLabel("Password");
        password.setBounds(20,100,80,30);
        this.add(password);

        JTextField tfs = new JTextField();
        tfs.setBounds(120,50,150,30);
        this.add(tfs);

        JTextField tfp = new JTextField();
        tfp.setBounds(120,100,150,30);
        tfp.setText(savepass);
        this.add(tfp);

        JButton save = new JButton("Save");
        save.setBounds(135,200,80,30);
        this.add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    Statement stmt = login.con.createStatement();
                    String sql = "insert into user_data values (NULL,'"+tfp.getText()+"','"+tfs.getText()+"','"+user_id+"')";
                    stmt.executeUpdate(sql);
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "Added Successful");
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
       addPass pass = new addPass(2);
    }*/
}
