import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadPerson {
    public static void main(String[] args){
        File archive = new File("agenda.dat");
        try{
            FileInputStream fin = new FileInputStream(archive);
            ObjectInputStream oin = new ObjectInputStream(fin);


            Person[] agendaArq = (Person[]) oin.readObject();
            oin.close();
            fin.close();

            for(Person p: agendaArq){
                if(p!= null) p.printData();
            }
        } catch(Exception err){
            System.out.println("Error: "+ err.toString());
        }
        System.out.println("Finished");

    }
}
