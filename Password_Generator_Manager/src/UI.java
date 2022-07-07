import javax.swing.*;
import java.awt.event.*;

public class UI {
    JFrame frame = new JFrame("Password Generator");

    UI(){
        frame.setSize(400,500);
        JButton button = new JButton("Generate Password");
        JButton b1 = new JButton("LogIn");
        JButton b2 = new JButton("Register");

        //Button for Generate
        button.setBounds(100,100,200,40);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                generateUI generate = new generateUI();
            }
        });

        //Button for LogIn
        b1.setBounds(100,200,200,40);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loginUI login = new loginUI(0,"");
            }
        });

        //Button for Register
        b2.setBounds(100,300,200,40);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                registerUI register = new registerUI();
            }
        });
        frame.add(button);
        frame.add(b1);
        frame.add(b2);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*void Generate(){
        JFrame generate = new JFrame();
        frame.setSize(200,300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/

    public static void main(String[] args){
       UI ui = new UI();
    }

}
