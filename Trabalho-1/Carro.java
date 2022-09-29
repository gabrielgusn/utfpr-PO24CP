import java.util.Random;

public class Carro {
    private int id;
    private String desenho;
    private int distanciaPercorrida;
    private Roda[] rodas = new Roda[4];
    private Double combustivel;
    private Double precoVenda;
    private boolean ipvaPago;

    public Carro(){
        Random r = new Random();
    
        this.ipvaPago = r.nextBoolean();
        this.combustivel = 2.5;
        this.precoVenda = 0.0;
        this.distanciaPercorrida = 0;
        this.desenho = sorteiaModelo();
        this.id = r.nextInt();
    }

    public Carro(int id){
        Random r = new Random();
    
        this.ipvaPago = r.nextBoolean();
        this.combustivel = 2.5;
        this.precoVenda = 0.0;
        this.distanciaPercorrida = 0;
        this.desenho = sorteiaModelo();
        this.id = id;
    }


    private String sorteiaModelo(){
        Random r = new Random();
        String[] desenhos = new String[6];
        desenhos[0] = "    ____\n __/  |_ \\_\n|  _     _``-.\n'-(_)---(_)--'\n\n\n";
        desenhos[1] = "  ______\n /|_||_\\`.__\n(   _    _ _\\ \n=`-(_)--(_)-'\n\n";
        desenhos[2] = "        __         \n      ~( @\\ \\   \n   _____]_[_/_>__   \n  / __ \\<> |  __ \\      \n=\\_/__\\_\\__|_/__\\_D\n   (__)      (__)    \n";
        desenhos[3] = "   __o\n _`\\<,_\n(*)/ (*)\n\n";
        desenhos[4] = "   ,_oo\n.-/c-//::\n(_)'==(_)\n";
        desenhos[5] = "   _______\n _/\\______\\__\n/ ,-. -|-  ,-.`-.\n`( o )----( o )-'\n  `-'      `-'\n";

        return desenhos[r.nextInt(6)];
    }

    public void desenhaCarro(){
        System.out.print(this.desenho);
    }
    public int getId(){
        return this.id;
    }
}
