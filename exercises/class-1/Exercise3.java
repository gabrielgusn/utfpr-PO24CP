import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exercise3 {
    public static void main(String[] args){
        String Snumber = JOptionPane.showInputDialog("Type a number");
        Scanner keyboard = new Scanner(System.in);
        int number = Integer.parseInt(Snumber);//keyboard.nextInt();
        int dividerSum = 0;
        for(int i = 1; i<number; i++){
            if(number%i==0){
                dividerSum += i;
            }
        }
        if(dividerSum == number){
            JOptionPane.showMessageDialog(null, "The number "+ number +" is perfect");
            //System.out.printf("The number %d is perfect\n", number);
        } else{
            JOptionPane.showMessageDialog(null, "The number "+ number +" is NOT perfect");
            //System.out.printf("The number %d is NOT perfect\n", number);
        }
        keyboard.close();
    }
}
