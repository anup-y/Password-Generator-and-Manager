import javax.swing.*;
import java.awt.event.*;
public class registerUI extends JFrame {
    JTextField tname, taddress, tnumber, temail, tpass;

    registerUI() {
        this.setSize(400, 400);
        this.setLayout(null);
        this.setVisible(true);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(40, 20, 80, 30);
        this.add(name);
        tname = new JTextField();
        tname.setBounds(130, 20, 180, 30);
        this.add(tname);

        //address
        JLabel address = new JLabel("Address");
        address.setBounds(40, 60, 80, 30);
        this.add(address);
        taddress = new JTextField();
        taddress.setBounds(130, 60, 180, 30);
        this.add(taddress);

        //number
        JLabel number = new JLabel("Mobile No.");
        number.setBounds(40, 100, 80, 30);
        this.add(number);
        tnumber = new JTextField();
        tnumber.setBounds(130, 100, 180, 30);
        this.add(tnumber);

        //email
        JLabel email = new JLabel("Email");
        email.setBounds(40, 140, 80, 30);
        this.add(email);
        temail = new JTextField();
        temail.setBounds(130, 140, 180, 30);
        this.add(temail);

        //password
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 180, 80, 30);
        this.add(pass);
        tpass = new JTextField();
        tpass.setBounds(130, 180, 180, 30);
        this.add(tpass);

        //register
        JButton register = new JButton("Register");
        register.setBounds(70, 250, 100, 50);
        this.add(register);
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user_name = tname.getText();
                String user_add = taddress.getText();
                int user_mob = Integer.parseInt(tnumber.getText());
                String user_email = temail.getText();
                String user_pass = tpass.getText();

                dataBaseInsert dbinsert = new dataBaseInsert(user_name, user_add, user_mob, user_email, user_pass);
                loginUI login = new loginUI(0,"");
                disposal();
            }

        });

        //reset
        JButton reset = new JButton("Reset");
        reset.setBounds(230, 250, 100, 50);
        this.add(reset);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = "";
                tname.setText(s);
                taddress.setText(s);
                tnumber.setText(s);
                temail.setText(s);
                tpass.setText(s);
            }
        });


    }

    void disposal() {
        this.dispose();
    }
}
