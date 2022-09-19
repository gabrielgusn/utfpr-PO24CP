import java.util.Random;

public class Roda {
    private boolean calibragemPneu;

    public Roda(){
        Random r = new Random();

        this.calibragemPneu = r.nextBoolean();
    }

    public void calibrar(){
        this.calibragemPneu = true;
    }

    private void esvaziarPneu(){
        this.calibragemPneu = false;
    }
}
