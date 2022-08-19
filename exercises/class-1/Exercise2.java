import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exercise2{
    
    public static void main(String[] agrs){
        String Snumber = JOptionPane.showInputDialog("Type a number");
        //System.out.println("Type a number:");

        Scanner keyboard = new Scanner(System.in);
        int number = Integer.parseInt(Snumber);//keyboard.nextInt();
        int dividers = 0;
        for(int i = 1; i<=number; i++){
            if(number%i==0){
                dividers++;
            }
            if(dividers > 2){
                JOptionPane.showMessageDialog(null, "The number "+ number +" is NOT prime");
                //System.out.printf("The number %d is NOT prime\n", number);
                break;
            }
            else if(i==number && dividers == 2){
                JOptionPane.showMessageDialog(null, "The number "+ number +" is prime");
                //System.out.printf("The number %d is prime\n", number);
            }
        }
        keyboard.close();
    }

} 