public class UseNonStaticCellphone {
    public static void main(String[] arg) {
        NonStaticCellphone a = new NonStaticCellphone();
        NonStaticCellphone b = new NonStaticCellphone();
        a.increment();
        b.increment();

        System.out.println(a.getTotal());
        System.out.println(b.getTotal());
    }
}
