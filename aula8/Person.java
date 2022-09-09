import java.io.Serializable;

public class Person implements Serializable{
    private String name;
    private String cpf;

    public Person(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }

    public void printData(){
        System.out.println("Name: " + name);
        System.out.println("Cpf: " + cpf);        
    }
}