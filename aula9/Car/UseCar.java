public class UseCar{

    public static void main(String[] args){

        Engine engine1 = new Engine(4, 65, 1);
        Car beetle = new Car("Volkswagen", engine1);

        Car golfr = new Car("Volkswagen", new Engine(6, 270, 1));

        beetle.accelerate(10);
        golfr.accelerate(10);
    }
}