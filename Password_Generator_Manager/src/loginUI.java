import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class loginUI extends JFrame {
    JTextField tuser,tpass;
    int flag =0;
    loginUI(int s,String save) {
        this.setSize(400, 300);


        //user
        JLabel user= new JLabel("Email");
        user.setBounds(40, 20, 80, 30);
        this.add(user);
        tuser = new JTextField();
        tuser.setBounds(130, 20, 180, 30);
        this.add(tuser);

        //password
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 60, 80, 30);
        this.add(pass);
        JPasswordField tpass = new JPasswordField();
        tpass.setBounds(130, 60, 180, 30);
        this.add(tpass);

        JButton Login= new JButton("Login");
        Login.setBounds(150, 200, 100, 50);
        this.add(Login);
        Login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                databaseLogin login = new databaseLogin();
                try {
                    Statement stmt = login.con.createStatement();
                    String sql = "select user_email,user_pass,user_id from pass_gen";
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        if (rs.getString(1).equals(tuser.getText()) && rs.getString(2).equals(tpass.getText())) {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "Login Successful");
                            flag = 1;

                            if(s==1){
                                int p = Integer.parseInt(rs.getString(3));
                                addPass pass = new addPass(p,save);
                                login.con.close();
                                disposal();
                                break;
                            }
                            mainPanel panel = new mainPanel(rs.getInt(3));
                            login.con.close();
                            disposal();


                            break;
                        }

                    }
                        if (flag == 0) {
                            JFrame f = new JFrame();
                            JOptionPane.showMessageDialog(f, "Invalid Credentials");
                        }

                }catch(Exception e){
                        System.out.println(e);
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
        loginUI log = new loginUI();
    }*/
}
