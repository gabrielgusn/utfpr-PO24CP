public class UsePerson{
    public static void main(String[] args){

        Person[] agenda = new Person[10];

        agenda[0] = new Person("Ana Julia", "123");
        agenda[1] = new Person("Paulo Ricardo", "456");
        agenda[2] = new Person("Mary Jane", "789");
    
        for(Person p : agenda)
            if(p!=null)
                System.out.println(p);

        for(int i = 0; i<agenda.length; i++)
            if(agenda[i] != null)
                System.out.println(agenda[i]);
        
    }
}