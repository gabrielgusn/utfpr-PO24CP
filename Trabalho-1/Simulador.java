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

    //Funcao utilizada para incluir veiculos
    public void incluirVeiculo(){
        if(qtiDeVeiculos == 0){//caso o simulador nao contenha veiculos, eh utilizado o construtor padrao, sem passar id por parametro, incrementa a variavel qtdiDeVeiculos e imprime confirmacao no terminal
            veiculos[0] = new Carro();
            qtiDeVeiculos++;
            System.out.println("1º Veiculo de ID "+veiculos[0].getId()+" incluido");
        }
        else if(qtiDeVeiculos == 20){//caso quantia maxima de veiculos ja tenha sido atingida
            System.out.println("Quantia maxima de veiculos ja atingida");
        }
        else{//caso nao seja o primeiro veiculo, cria um id pseudoaleatorio para passar por parametro no construtor com id da classe carro
            Random r = new Random();
            int id = r.nextInt(20);
            while(confereIdExistente(id)){//confere se o ID ja esta em uso, a fim de que nao haja carros com ids repetidos no simulador
                id = r.nextInt(20);//caso ja exista, fornece um id novo ate que a condicao de exclusividade seja satisfeita
            }
            if(!confereIdExistente(id)){
                veiculos[qtiDeVeiculos] = new Carro(id);//inclui veiculo com o id pseudoaleatorio
                System.out.println((qtiDeVeiculos+1) + "º Veiculo de ID "+veiculos[qtiDeVeiculos].getId()+" incluido");
                qtiDeVeiculos++;//incrementa a quantia de veiculos
            }
        }
    }

    //funcao utilizada para remover um veiculo especifico pelo id
    public void removerVeiculo(int id){
        int index = buscaPosicaoPorId(id);
        if(index == -1)//caso o retorno de buscaPosicaoPorId(id) seja -1, significa que nao ha veiculo com este id no simulador
            System.out.println("Veiculo ID " + id + " nao existe");
        else{
            //transforma o veiculo na posicao index em nulo e decrementa a quantia de veiculos
            veiculos[index] = null;
            qtiDeVeiculos--;
            System.out.println("Veiculo de ID "+ id + " na posicao " + (index+1) + " removido");//informa que um veiculo com id tal foi inserido na posicao index+1
        }
    }

    //busca a posicao indicada pelo parametro e abastece o veiculo atraves do metodo da classe carro Carro.abastecerVeiculo()
    public void abastecerVeiculo(int id){
        int posicao = buscaPosicaoPorId(id);
        if(posicao == -1 && veiculos[posicao] == null) 
            System.out.println("\nVeiculo" + id + "nao existe\n");
        else if(veiculos[posicao] != null)
            veiculos[posicao].abastecerVeiculo();
        System.out.println("Veiculo "+ id + "abastecido!");
    }

    //busca a posicao indicada pelo parametro e move o veiculo atraves do metodo da classe carro Carro.mover()
    public void moverVeiculo(int id){
        int posicao = buscaPosicaoPorId(id);
        if(posicao == -1 && veiculos[posicao] == null) 
            System.out.println("\nVeiculo" + id + "nao existe\n");
        else if(veiculos[posicao] != null)
            veiculos[posicao].mover();
    }

    //move todos os veiculos
    public void moverTodosOsVeiculos(){
        for(int i = 0; i<20; i++){
            if(veiculos[i] != null)
                veiculos[i].mover();
        }
    }

    //confere se existe algum veiculo cadastrado no simulador e, caso tenha, imprime a pista 
    public void imprimirPista(){
        if(qtiDeVeiculos == 0) System.out.println("Nenhum veiculo cadastrado");
        for(int i = 0; i<20; i++){
            if(veiculos[i] != null)
                veiculos[i].desenhaCarro();
        }
    }

    //busca um unico veiculo pelo seu id e o imprime utilizando o metodo da classe Carro Carro.toString()
    public void imprimeVeiculo(int id){
        int index = buscaPosicaoPorId(id);
        if(index == -1) 
            System.out.println("Veiculo ID " + id + " nao existe");
        else
            System.out.println(this.veiculos[buscaPosicaoPorId(id)].toString());
    }

    //imrpime todos os veiculos existentes utilizando o metodo .toString()
    public void imprimeTodosVeiculos(){
        if(qtiDeVeiculos == 0) System.out.println("Nenhum veiculo cadastrado");
        for(int i = 0; i<20; i++){
            if(veiculos[i] != null)
                System.out.println(veiculos[i].toString());
        }
    }

    //confere se existe veiculo cadastrado com o id passado por parametro, caso exista, pede no terminal qual dos pneus quer que seja calibrado
    public void calibrarPneu(int id){
        int index = buscaPosicaoPorId(id);
        if(index == -1)
            System.out.println("\nVeiculo ID " + id + " nao existe\n");
        else{
            Scanner input = new Scanner(System.in);
            System.out.println("Qual pneu voce quer calibrar? (1 a 4)");
            
            int pneu = 0;
            while(pneu<1 || pneu>4){//loop para garantir que a entrada seja de 1 a 4, correspondente ao numero de pneus
                pneu = input.nextInt();
                if(pneu>=1 && pneu<=4){
                    veiculos[index].calibrarPneuEspecifico(pneu);//calibra o pneu especificado
                    System.out.println("\nPneu " + pneu + " do veiculo " + id + " calibrado!\n");
                    break;
                }
                else{
                    if(pneu == -1) break;//quebra o laco de repeticao caso a opcao seja -1
                    System.out.println("Pneu "+ id +" nao existe.\n Digite outro ID de 1 a 4 ou digite -1 para sair");
                }
            }
            
            input.close();
        }
    }

    //busca o veiculo pelo id e calibra todos os seus pneus
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

    //possui laco de repeticao para encontrar id do veiculo especificada por parametro
    //caso retorne -1, significa que nao existe veiculo cadastrado com esse id
    public int buscaPosicaoPorId(int id){
        int i = 0;
        while(i<20){
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

    //funcao utilizada para conferir no se o id ja fui utilizado 
    public boolean confereIdExistente(int id){
        for(int i = 0; i < qtiDeVeiculos; i++){
            if(veiculos[i].getId() == id){
                return true;
            }
        }
        return false;
    }
}
