public class Engine {
    private int cilinders;
    private int hp;
    private int currentRpm;

    public Engine(int c, int h, int r){
        this.cilinders = c;
        this.hp = h;
        this.currentRpm = r;
    }

    public void accelerate(int a, String brand){
        System.out.println(brand + " Accelerating with " + (cilinders*hp*currentRpm*a) + "N");
        this.currentRpm += a;
    }
}
