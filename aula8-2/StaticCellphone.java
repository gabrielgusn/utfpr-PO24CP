public class StaticCellphone {
    private static int total;
    private int serial;

    public StaticCellphone(int s){
        this.serial = s;
        StaticCellphone.total = StaticCellphone.total+1;
    }

    public static int getTotal() {
        return StaticCellphone.total;
    }

    public int getSerial(){
        return this.serial;
    }
}
