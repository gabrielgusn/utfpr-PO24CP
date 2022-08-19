import java.util.Scanner;

public class Exercise1{

    public static void main(String[] args){
        System.out.println("Type a number:");
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        for(int i = 0; i<number; i++){
            if(i%2!=0){
                System.out.println(i);
            } 
                
        }
        keyboard.close();
    }
}