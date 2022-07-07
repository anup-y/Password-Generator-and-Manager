import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class mainPanel extends JFrame {

   JTextField tfd = new JTextField("Enter the id");

   mainPanel(int user_id){
      this.setSize(500, 400);

      tfd.setBounds(50,270,100,30);
      //this.add(tfd);
      String [] columnName ={"id","Password","Password Descrption"};
      databaseLogin login = new databaseLogin();

      JButton add = new JButton("ADD");
      add.setBounds(40, 300, 90, 30);
      this.add(add);
      add.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             addPass pass = new addPass(user_id,"");

             disposal();
         }
      });



      JButton delete = new JButton("DELETE");
      delete.setBounds(200, 300, 90, 30);
      this.add(delete);
      delete.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){

             deletePass delete = new deletePass(user_id);
            disposal();
         }
      });


      JButton edit = new JButton("EDIT");
      edit.setBounds(380, 300, 90, 30);
      this.add(edit);
      edit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            editPass pass = new editPass(user_id);

            disposal();
         }
      });

      //Object[][] data = new Object[][]{};
      int count = 0;
      try {
         Statement stmt = login.con.createStatement();
         String sql = "select * from user_data where user_id='"+user_id+"'";
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
            count++;
         }
         String data[][] = new String[count][4];
         ResultSet Rs = stmt.executeQuery("select * from user_data where user_id='"+user_id+"'");


         int x =0;
         while (Rs.next()){
            int y = 0;
            for(int i=1;i<5;i++){

                  data[x][y] = Rs.getString(i);

                y++;
               }
            x++;
               //System.out.println(" inside");
            }


         for(int i=0;i<count;i++){
            for(int j=0;j<4;j++){
               //System.out.println(count);
              System.out.print(data[i][j]);

            }
            //System.out.println("Array");
         }

         JTable table = new JTable(data,columnName);
         table.setRowHeight(20);
         this.add(new JScrollPane(table));
         this.setVisible(true);

         login.con.close();
      }catch(Exception e){
         System.out.println(e);
      }
      //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(null);
      this.setVisible(true);
   }


   void disposal(){
       this.dispose();
   }
  /*public static void main(String[] args) {
     mainPanel mp = new mainPanel(2);
  }*/
}
