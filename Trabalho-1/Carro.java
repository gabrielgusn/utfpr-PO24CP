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

    public Carro(){
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

    public Carro(int id){
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

    public void mover(){
        if(this.combustivel >= 0.55 && this.ipvaPago && confereCalibragens()){
            this.desenho = desenho.replaceAll("\n", "\n     ");
            this.distanciaPercorrida+=1;

            System.out.println("\nVeiculo " + this.id + " movido!");
        }
        else{
            if(this.combustivel < 0.55){
                System.out.println("\nVeiculo " + id + " sem combustivel\n");
            } 
            if(!this.ipvaPago){
                System.out.println("\nVeiculo " + id + " nao esta regularizado\n");

                int pagarIPVA = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja pagar o IPVA?", "0 ou 1"));
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

    public void abastecerVeiculo(){
        this.combustivel += 2.50;
    }

    public void calibrarVeiculo(){
        for(int i = 0; i<4; i++){
            this.rodas[i].setCalibragem(true);
        }
    }

    public void calibrarPneuEspecifico(int index){
        rodas[index].setCalibragem(true);
    }

    public void pagarIpva(){
        this.ipvaPago = true;
    }

    public boolean confereCalibragens(){
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
    
    private String sorteiaModelo(){
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
