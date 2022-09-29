import java.util.Random;

public class Carro {
    private int id;
    private Roda[] roda = new Roda[4];
    private Double combustivel;
    private Double precoVenda;
    private boolean ipvaPago;

    public Carro(){}
    
    public Carro(int id){
        Random r = new Random();
    
        this.ipvaPago = r.nextBoolean();
        
    }

}
