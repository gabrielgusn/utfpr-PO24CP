import java.util.Random;
import java.util.Scanner;

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
            while(confereIdExistente(id)){
                id = r.nextInt(100);
            }
            if(!confereIdExistente(id)){
                veiculos[qtiDeVeiculos] = new Carro(id);
                qtiDeVeiculos++;
            }
        }
    }

    public void removerVeiculo(int id){
        int posicao = buscaPosicaoPorId(id);
        veiculos[posicao] = null;
        qtiDeVeiculos--;
        System.out.println("Veiculo "+ id + "na posicao " + posicao + "removido");
    }

    public void abastecerVeiculo(int id){
        int posicao = buscaPosicaoPorId(id);
        veiculos[posicao].abastecerVeiculo();
        System.out.println("Veiculo "+ id + "abastecido!");
    }

    public void moverVeiculo(int id){
        int posicao = buscaPosicaoPorId(id);
        veiculos[posicao].mover();
    }

    public void moverTodosOsVeiculos(){
        for(int i = 0; i<qtiDeVeiculos; i++){
            veiculos[i].mover();
        }
    }

    public void imprimirPista(){
        for(int i = 0; i<qtiDeVeiculos; i++){
            veiculos[i].desenhaCarro();
        }
    }

    public void imprimeVeiculo(int id){
        System.out.println(this.veiculos[buscaPosicaoPorId(id)].toString());
    }

    public void imprimeTodosVeiculos(){
        for(int i = 0; i<qtiDeVeiculos; i++){
            System.out.println(veiculos[i].toString());
        }
    }

    public void calibrarPneu(int id){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual pneu voce quer calibrar? (1 a 4)");
        
        int pneu = 0;
        while(pneu<1 || pneu>4){
            pneu = input.nextInt();
            if(pneu>=1 && pneu<=4){
                veiculos[buscaPosicaoPorId(id)].calibrarPneuEspecifico(pneu);
                break;
            }
            else{
                if(pneu == -1) break;
                System.out.println("Pneu "+ id +" nao existe.\n Digite outro ID de 1 a 4 ou digite -1 para sair");
            }
        }

        input.close();
    }

    public void estadoVeiculos(){
        for(int i = 0; i<qtiDeVeiculos; i++){
            if(veiculos[i].getCombustivel()>=0.55 && veiculos[i].getIpva() && veiculos[i].confereCalibragens()){
                System.out.println("Veiculo na posicao " + i + " funcionando");
            }
            else{
                System.out.println("Veiculo na posicao " + i + " NAO funcionando");
            }
        }
    }

    public int getQtd(){
        return this.qtiDeVeiculos;
    }

    public Carro getVeiculo(int index){
        return this.veiculos[index];
    }

    public int buscaPosicaoPorId(int id){
        int i = 0;
        while(i<qtiDeVeiculos){
            if(veiculos[i].getId() == id){
                return i;
            }
            i++;
        }
        if(i == qtiDeVeiculos){
            System.out.println("Veiculo id " + id + " nao encontrado");
        }
        return -1;
    }

    public boolean confereIdExistente(int id){
        for(int i = 0; i < qtiDeVeiculos; i++){
            if(veiculos[i].getId() == id){
                return true;
            }
        }
        return false;
    }
}
