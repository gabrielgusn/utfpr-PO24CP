public class Person{
    private String name;
    private String cpf;

    public Person(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }

    public String toString(){
        return "\nName: " + name + " CPF: " + cpf; 
    }
}