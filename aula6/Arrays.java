public class Arrays {
    public static void main(String[] args){
        String[] strArr = {"teste", "este", "ste","te","e"};
        System.out.println(strArr.toString());

        for(String i: strArr){
            System.out.println(i);
        }

        System.out.println(strArr[4].compareTo("31"));
    }
}
