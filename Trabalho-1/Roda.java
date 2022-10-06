import java.io.Serializable;
import java.util.Random;

public class Roda implements Serializable{
    private boolean calibragemPneu;

    public Roda(){
        Random r = new Random();

        this.calibragemPneu = r.nextBoolean();
    }

    public void setCalibragem(boolean bool){
        this.calibragemPneu = bool;
    }

    public boolean getCalibragem(){
        return this.calibragemPneu;
    }

    public String toString(){
        return calibragemPneu ? "Pneu calibrado" : "Pneu vazio";
    }
    
    // private void esvaziarPneu(){
    //     this.calibragemPneu = false;
    // }
}
