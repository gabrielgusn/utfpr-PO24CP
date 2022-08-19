import javax.swing.JOptionPane;

public class Exercise6 {
    public static void main(String[] args){
        while(true){
            int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Please, type a Number:"));
            if(number == -1) break;
            int colNumber = (number*2)-1;
            int[][] matrix = new int[number][(colNumber*2)-1];
        }


    }
}
