import java.util.Random;

public class Simulador {
    private int qtiDeVeiculos;
    private Carro[] veiculos = new Carro[20];

    public Simulador(){
        qtiDeVeiculos = 0;
    }

    public void moveRandom(){
        Random r = new Random();
        veiculos[r.nextInt(qtiDeVeiculos)].mover();
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
            int id = r.nextInt(100);
            while(confereId(id)){
                id = r.nextInt(100);
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

    public void imprimeVeiculo(Carro veiculo){
        System.out.println(veiculo.toString());
    }

    public void estadoVeiculos(){
        for(int i = 0; i<qtiDeVeiculos; i++){
            if(veiculos[i].getCombustivel()>=.055 && veiculos[i].getIpva() && veiculos[i].confereCalibragens()){
                System.out.println("Veiculo " + i + " funcionando");
            }
            else{
                System.out.println("Veiculo " + i + " NAO funcionando");
            }
        }
    }

    public int getQtd(){
        return this.qtiDeVeiculos;
    }

    public Carro getVeiculo(int index){
        return this.veiculos[index];
    }
}
