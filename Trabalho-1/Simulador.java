import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Simulador implements Serializable{
    private static int qtiDeVeiculos;
    private Carro[] veiculos = new Carro[20];

    public Simulador(){
        qtiDeVeiculos = 0;
    }

    // public void moveRandom(){
    //     Random r = new Random();
    //     veiculos[r.nextInt(qtiDeVeiculos)].mover();
    // }

    public void incluirVeiculo(){
        if(qtiDeVeiculos == 0){
            veiculos[0] = new Carro();
            qtiDeVeiculos++;
            System.out.println("1º Veiculo de ID "+veiculos[0].getId()+" incluido");
        }
        else if(qtiDeVeiculos == 20){
            System.out.println("Quantia maxima de veiculos ja atingida");
        }
        else{
            Random r = new Random();
            int id = r.nextInt(20);
            while(confereIdExistente(id)){
                id = r.nextInt(20);
            }
            if(!confereIdExistente(id)){
                veiculos[qtiDeVeiculos] = new Carro(id);
                System.out.println((qtiDeVeiculos+1) + "º Veiculo de ID "+veiculos[qtiDeVeiculos].getId()+" incluido");
                qtiDeVeiculos++;
            }
        }
    }

    public void removerVeiculo(int id){
        int index = buscaPosicaoPorId(id);
        if(index == -1)
            System.out.println("Veiculo ID " + id + " nao existe");
        else{
            veiculos[index] = null;
            qtiDeVeiculos--;
            System.out.println("Veiculo de ID "+ id + " na posicao " + (index+1) + " removido");
        }
    }

    public void abastecerVeiculo(int id){
        int posicao = buscaPosicaoPorId(id);
        veiculos[posicao].abastecerVeiculo();
        System.out.println("Veiculo "+ id + "abastecido!");
    }

    public void moverVeiculo(int id){
        int posicao = buscaPosicaoPorId(id);
        if(posicao == -1 && veiculos[posicao] == null) 
            System.out.println("\nVeiculo" + id + "nao existe\n");
        else if(veiculos[posicao] != null)
            veiculos[posicao].mover();
    }

    public void moverTodosOsVeiculos(){
        for(int i = 0; i<qtiDeVeiculos; i++){
            if(veiculos[i] != null)
                veiculos[i].mover();
        }
    }

    public void imprimirPista(){
        if(qtiDeVeiculos == 0) System.out.println("Nenhum veiculo cadastrado");
        for(int i = 0; i<qtiDeVeiculos; i++){
            if(veiculos[i] != null)
                veiculos[i].desenhaCarro();
        }
    }

    public void imprimeVeiculo(int id){
        int index = buscaPosicaoPorId(id);
        if(index == -1) 
            System.out.println("Veiculo ID " + id + " nao existe");
        else
            System.out.println(this.veiculos[buscaPosicaoPorId(id)].toString());
    }

    public void imprimeTodosVeiculos(){
        if(qtiDeVeiculos == 0) System.out.println("Nenhum veiculo cadastrado");
        for(int i = 0; i<qtiDeVeiculos; i++){
            if(veiculos[i] != null)
                System.out.println(veiculos[i].toString());
        }
    }

    public void calibrarPneu(int id){
        int index = buscaPosicaoPorId(id);
        if(index == -1)
            System.out.println("\nVeiculo ID " + id + " nao existe\n");
        else{
            Scanner input = new Scanner(System.in);
            System.out.println("Qual pneu voce quer calibrar? (1 a 4)");
            
            int pneu = 0;
            while(pneu<1 || pneu>4){
                pneu = input.nextInt();
                if(pneu>=1 && pneu<=4){
                    veiculos[index].calibrarPneuEspecifico(pneu);
                    System.out.println("\nPneu " + pneu + " do veiculo " + id + " calibrado!\n");
                    break;
                }
                else{
                    if(pneu == -1) break;
                    System.out.println("Pneu "+ id +" nao existe.\n Digite outro ID de 1 a 4 ou digite -1 para sair");
                }
            }
            
            input.close();
        }
    }

    public void calibrarTodosPneus(int id){
        int index = buscaPosicaoPorId(id);
        if(index == -1)
            System.out.println("\nVeiculo ID " + id + " nao existe\n");
        else{
            veiculos[index].calibrarVeiculo();
            System.out.println("\nCarro id " + id + " calibrado\n");
        }
    }

    // public void lerVeiculosArq(String path){
    //     System.out.println(path);
    // }

    // public void estadoVeiculos(){
    //     for(int i = 0; i<qtiDeVeiculos; i++){
    //         if(veiculos[i].getCombustivel()>=0.55 && veiculos[i].getIpva() && veiculos[i].confereCalibragens()){
    //             System.out.println("Veiculo na posicao " + i + " funcionando");
    //         }
    //         else{
    //             System.out.println("Veiculo na posicao " + i + " NAO funcionando");
    //         }
    //     }
    // }

    public int getQtd(){
        return Simulador.qtiDeVeiculos;
    }

    public Carro getVeiculo(int index){
        return this.veiculos[index];
    }

    public int buscaPosicaoPorId(int id){
        int i = 0;
        while(i<qtiDeVeiculos){
            if(veiculos[i].getId() == id && veiculos[i] != null){
                return i;
            }
            i++;
        }
        if(i == qtiDeVeiculos){
            System.out.println("\nVeiculo id " + id + " nao encontrado\n");
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
