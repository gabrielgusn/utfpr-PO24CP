import java.io.Serializable;
import java.util.Random;

import javax.swing.JOptionPane;

public class Carro implements Serializable{
    private int id;
    private String desenho;
    private int distanciaPercorrida;
    private Roda[] rodas = new Roda[4];
    private double combustivel;
    private double precoVenda;
    private boolean ipvaPago;

    public Carro(){//construtor padrao da classe Carro, utilizado pelo simulador quando ainda nao ha veiculos cadastrados, fornece um id aleatorio de 0 a 20 ao veiculo
        Random r = new Random();
    
        this.ipvaPago = r.nextBoolean();
        this.combustivel = 2.5;
        this.precoVenda = 0.0;
        this.distanciaPercorrida = 0;
        this.desenho = sorteiaModelo();
        this.id = r.nextInt(20);
        for(int i = 0; i < 4; i++)
            rodas[i] = new Roda();
    }

    public Carro(int id){//construtor utilizado pelo simulador para o caso de ja ter sido cadastrado o primeiro veiculo do simulador
        Random r = new Random();
    
        this.ipvaPago = r.nextBoolean();
        if(ipvaPago == false)
        this.combustivel = 2.5;
        this.precoVenda = 0.0;
        this.distanciaPercorrida = 0;
        this.desenho = sorteiaModelo();
        this.id = id;
        for(int i = 0; i < 4; i++)
            rodas[i] = new Roda();
    }

    //funcao utilizada para movimentar o veiculo
    public void mover(){
        //confere se o ipva esta pago, se ha mais de 0.55 litros de combustivel e se o ipva esta pago e, entao, utilizei como metodo para "mover" o veiculo o replaceAll, trocando todos os \n da string do desenho do veiculo por "\n     ", assim, a cada quebra de linha, onde eh a continuacao do desenho, eh acrescentado um espaco para o veiculo  "se mover" no terminal
        if(this.combustivel >= 0.55 && this.ipvaPago && confereCalibragens()){
            this.desenho = desenho.replaceAll("\n", "\n     ");
            this.distanciaPercorrida+=1;

            System.out.println("\nVeiculo " + this.id + " movido!");
        }
        else{//caso nao satisfaca alguma das exigencias acima, informa qual delas nao foi satisfeita
            if(this.combustivel < 0.55){
                System.out.println("\nVeiculo " + id + " sem combustivel\n");
            } 
            if(!this.ipvaPago){//caso o ipva ainda nao tenha sido pago, abre um painel do JOptionPane para conferir se o usuario quer que o veiculo seja regularizado, 0 para nao e 1 para sim. E da um retorno no terminal para o caso do usuario solicitar o pagamento do ipva
                System.out.println("\nVeiculo " + id + " nao esta regularizado\n");

                int pagarIPVA = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja pagar o IPVA do Veiculo ID " + this.id + "?", "0 ou 1"));
                if(pagarIPVA == 1){
                    this.pagarIpva();
                    System.out.println("\nIPVA do veiculo ID " + this.id + " pago\n");
                } 
            } 
            if(!this.confereCalibragens()){
                System.out.println("\nPneus do veiculo " + this.id + " nao estao calibradas!\n");
            }
        }
    }

    public void abastecerVeiculo(){//aumenta o combustivel do veiculo para 2.50
        this.combustivel += 2.50;
    }

    public void calibrarVeiculo(){//calibra todos os pneus do veiculo, setando o estado da calibragem de cada pneu como true
        for(int i = 0; i<4; i++){
            this.rodas[i].setCalibragem(true);
        }
    }

    public void calibrarPneuEspecifico(int index){//procura o indice informado por parameto, para calibrar o pneu especificado
        rodas[index].setCalibragem(true);
    }

    public void pagarIpva(){//seta o estado do ipvaPago como true
        this.ipvaPago = true;
    }

    public boolean confereCalibragens(){//confere todas as calibragens de todos os pneus do veiculo, caso haja ao menos 1 roda nao calibrada, retorna false
        for(int i = 0; i<4; i++){
            if(rodas[i].getCalibragem() == false){
                return false;
            }
        }
        return true;
    }
    
    public int getId(){
        return this.id;
    }
    
    public double getPrecoVenda(){
        return this.precoVenda;
    }
    
    public int getDistancia(){
        return this.distanciaPercorrida;
    }
    
    public void getEstadoRodas(){
        for(Roda roda : rodas){
            System.out.print(roda.getCalibragem());
        }
    }
    
    public double getCombustivel(){
        return this.combustivel;
    }
    
    public boolean getIpva(){
        return this.ipvaPago;
    }
    
    public String toString(){
        return "\n\tID:" + id + "\n" + desenho + "\n Combustivel: " + this.combustivel + "\n IPVA: " + this.ipvaPago + "\n Calibragem: " + this.confereCalibragens() + "\n";
    }

    public void desenhaCarro(){
        System.out.print(this.desenho);
    }
    
    private String sorteiaModelo(){//funcao utilizada para sortear um modelo de desenho para os veiculos, a fim de ficar melhor a visualizacao de cada modelo no terminal
        Random r = new Random();
        String[] desenhos = new String[6];
        desenhos[0] = "\n    ____\n __/  |_ \\_\n|  _     _``-.\n'-(_)---(_)--'\n\n";
        desenhos[1] = "\n  ______\n /|_||_\\`.__\n(   _    _ _\\ \n=`-(_)--(_)-'\n\n";
        desenhos[2] = "\n        __         \n      ~( @\\ \\   \n   _____]_[_/_>__   \n  / __ \\<> |  __ \\      \n=\\_/__\\_\\__|_/__\\_D\n   (__)      (__)    \n\n";
        desenhos[3] = "\n   __o\n _`\\<,_\n(*)/ (*)\n\n";
        desenhos[4] = "\n   ,_oo\n.-/c-//::\n(_)'==(_)\n\n";
        desenhos[5] = "\n   _______\n _/\\______\\__\n/ ,-. -|-  ,-.`-.\n`( o )----( o )-'\n  `-'      `-'\n\n";
        
        return desenhos[r.nextInt(6)];
    }
}
