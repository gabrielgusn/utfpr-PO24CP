public class Date {
    private int day, month, year;

    public void changeDate(int d) {
        this.day = d;
    }

    public void changeDate(int d, int m) {
        this.day = d;
        this.month = m;
    }

    public void changeDate(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }
}
