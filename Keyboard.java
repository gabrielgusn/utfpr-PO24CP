import java.util.Scanner;

public class Keyboard{

    public static void main(String[] args){

        try (Scanner keyboard = new Scanner(System.in)) {
            int i = keyboard.nextInt(); //read an int
            double r = keyboard.nextDouble();
            String s = keyboard.nextLine(); //read a string
                s = keyboard.nextLine();
            System.out.println("int: " + i + ", real: " + r);
            System.out.println("Phrase: " + s);
        }
    }
}