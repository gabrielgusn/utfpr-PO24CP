import java.util.Random;

public class Simulador {
    private static int qtiDeVeiculos;
    private static Carro[] veiculos = new Carro[20];

    public Simulador(){
        qtiDeVeiculos = 0;
    }

    public void incluirVeiculo(){
        if(qtiDeVeiculos == 0){
            veiculos[0] = new Carro();
            qtiDeVeiculos++;
        }
        else if(qtiDeVeiculos == 20){
            System.out.println("Quantia maxima de veiculos ja atingida");
        }
        else{
            Random r = new Random();
            int id = r.nextInt();
            while(confereId(id) && qtiDeVeiculos<20){
                id = r.nextInt();
            }
            if(!confereId(id)){
                veiculos[qtiDeVeiculos] = new Carro(id);
                qtiDeVeiculos++;
            }
        }
    }

    public void imprimirPista(){
        for(int i = 0; i<qtiDeVeiculos; i++){
            veiculos[i].desenhaCarro();
        }
    }

    public boolean confereId(int id){
        for(int i = 0; i < qtiDeVeiculos; i++){
            if(veiculos[i].getId() == id){
                return true;
            }
        }
        return false;
    }
}
