// import javax.swing.JOptionPane;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args){
        System.out.println("Type a number:");
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        for(int i = 0; i<=number; i++){
            int dividers = 0;
            for(int j = 1; j<=i; j++){
                if(i%j==0){
                    dividers++;
                }
                if(dividers>2){
                    break;
                } else if(dividers == 2 && j == i){
                    System.out.println(i);
                    break;
                };
            }
        }
        keyboard.close();
    }    
}
