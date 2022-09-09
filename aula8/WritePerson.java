import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WritePerson {
    public static void main(String[] args){

        Person[] agenda = new Person[5];

        agenda[0] = new Person("Gabriel", "123");
        agenda[1] = new Person("Gustavo", "456");
        agenda[4] = new Person("Thais", "789");
        

        File archive = new File("agenda.dat");
        try{
            FileOutputStream fout = new FileOutputStream(archive);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            
            oos.writeObject(agenda);
            oos.flush();
            oos.close();
            fout.close();
        } catch (Exception err){
            System.out.println("Error: "+ err.toString());
        }
    }
}
