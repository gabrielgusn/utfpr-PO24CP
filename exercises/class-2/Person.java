public class Person{

    private String name;
    private String cpf;
    private int birthYear;

    public Person(){
        name = "to be set";
        cpf = "to be set";
        birthYear = 0;
    }

    public Person(String n){
        name = n;
        cpf = "to be set";
        birthYear = 0;
    }

    public Person(String n, String c){
        name = n;
        cpf = c;
        birthYear = 0;
    }

    public Person(String n, String c, int y){
        name = n;
        cpf = c;
        birthYear = y;
    }

    public void printData(){
        System.out.println("Nome: " + name);
        System.out.println("CPF: " + cpf);
        System.out.println("Ano: " + birthYear);
    }
}
