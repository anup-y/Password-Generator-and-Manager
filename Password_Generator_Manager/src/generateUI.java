import javax.swing.*;
import java.awt.event.*;
public class generateUI extends JFrame {
    JButton generate = new JButton("Generate");
    JButton save = new JButton("Save");
    JTextField tf =  new JTextField();

    generateUI() {
        this.setSize(400, 300);

        //for password
        JLabel pass = new JLabel("Password");
        pass.setBounds(50,150,150,30);
        this.add(pass);

        //for textfield
        tf.setBounds(160,150,220,30);
        this.add(tf);
       //for generate
        generate.setBounds(70,200,120,30);
        this.add(generate);

       //for save
        save.setBounds(200,200,120,30);
        this.add(save);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loginUI login = new loginUI(1,tf.getText());
                disposal();
            }
        });
        this.setLayout(null);
        this.setVisible(true);

        passLength();
    }
    void passLength(){
        String Length[] = {"8","10","12","14","16","24"};
        JLabel l1 = new JLabel("Length");
        l1.setBounds(60,50,90,20);
        this.add(l1);

        JComboBox combo = new JComboBox(Length);
        combo.setBounds(200,50,90,20);
        this.add(combo);

        generate.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               //System.out.println(combo.getItemAt(combo.getSelectedIndex()));
               String s = String.valueOf(combo.getItemAt(combo.getSelectedIndex()));
               int n = Integer.parseInt(s);
               passwordGenerator(n);
           }
        });
    }

    void passwordGenerator(int n){
        passGenerator word = new passGenerator();
        word.CreatePassword(n);
        tf.setText(word.passWord);
    }
    void disposal(){
        this.dispose();
    }
}
