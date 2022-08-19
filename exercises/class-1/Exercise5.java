// import javax.swing.JOptionPane;
// import java.util.Scanner;
import java.util.Random;

public class Exercise5{
    public static void main(String[] args){
        Random r = new Random();
        int[] randomArr = new int[10];
        for(int i = 0; i<10; i++){
            randomArr[i] = r.nextInt(30);
            System.out.printf("%d ",randomArr[i]);
        }
        System.out.printf("\n");
        int aux;
        for(int i = 0; i<10; i++){
            for(int j = 0; j<9-i; j++){
                if(randomArr[j]>randomArr[j+1] && j<9){
                    aux = randomArr[j+1];
                    randomArr[j+1] = randomArr[j];
                    randomArr[j] = aux;
                }
            }
        }
        for(int i = 0; i<10; i++){
            System.out.printf("%d ",randomArr[i]);
        }
        System.out.printf("\n");
    }
}