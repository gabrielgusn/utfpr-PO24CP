public class UseDate {
    public static void main(String[] args){
        Date d = new Date();
        d.changeDate(31);
        System.out.println(d.toString());
        d.changeDate(31,12);
        System.out.println(d.toString());
        d.changeDate(31,12,1969);
        System.out.println(d.toString());
    }
}
