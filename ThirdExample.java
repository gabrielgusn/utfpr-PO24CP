import javax.swing.JOptionPane;

public class ThirdExample{
    public static void main(String[] args){
        String text;
        text = JOptionPane.showInputDialog("Enter a number");
        int number = Integer.parseInt(text);
        JOptionPane.showMessageDialog(null, number);
    }
}