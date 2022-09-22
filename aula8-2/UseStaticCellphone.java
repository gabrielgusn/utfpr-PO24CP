public class UseStaticCellphone {
    public static void main(String[] arg) {

        System.out.println(StaticCellphone.getTotal());
        StaticCellphone c = new StaticCellphone(123);
        StaticCellphone d = new StaticCellphone(456);

        System.out.println(StaticCellphone.getTotal());
        System.out.println(d.getSerial());
    }
}
