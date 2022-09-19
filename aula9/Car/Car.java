public class Car{
    private String brand;
    private Engine engine;

    public Car(String brand, Engine mo){
        this.brand = brand;
        this.engine = mo;
    }

    public void accelerate(int value){
        this.engine.accelerate(value, this.brand);
    }

    public String getBrand(){
        return "Brand: " + brand;
    }
}
