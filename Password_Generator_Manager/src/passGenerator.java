import java.util.Scanner;
import java.util.Random;
public class passGenerator{
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    String passWord="";
   /*int getLength(){
     System.out.println("Enter the length of Password");
     return scan.nextInt();
   }*/

   int returnNo(){
      return random.nextInt(10);
   }

   char returnSmallChar(){
       return (char) (random.nextInt(26)+ 'a');
   }

   char returnBigChar(){
        return (char) (random.nextInt(26)+ 'A');
   }
   char returnSpecial(){
       String set = "~!@#$%^&*()_+-=";
       int ran = random.nextInt(set.length());
       return set.charAt(ran);
   }

   void CreatePassword(int length){

      int Length = length;
      for(int i =0; i < Length; i++){
         int n = random.nextInt(4);
         switch(n){
             case 0 : passWord+=returnNo();
                        break;
             case 1: passWord+=returnSmallChar();
                        break;
             case 2: passWord+=returnBigChar();
                        break;
             case 3: passWord+=returnSpecial();
                        break;
             default: System.out.println("Wrong Number Generated");
                        break;
         }
      }

   }
   /*public static void main(String[] args) {
        passGenerator m = new passGenerator();
        m.CreatePassword(12);
        System.out.println("Password is " +m.passWord);
     }*/
}
