import java.util.Scanner;

public class UsaSimulador {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        Simulador sim = new Simulador();

        while(opcao!=13){
            System.out.print("Escolha uma opcao: ");
            opcao = input.nextInt();
            menu(opcao, sim);
        }

        for(int i = 0; i<20; i++){
            sim.incluirVeiculo();
            // System.out.println("\n" + sim.getQtd());
            // sim.imprimeVeiculo(sim.getVeiculo(i));
            System.out.println("id veiculo " + i + ": " + sim.getVeiculo(i).getId());
        }
        
        input.close();
    }

    public static void menu(int opcao, Simulador sim){
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        switch(opcao){
            case 1:
                sim.incluirVeiculo();
                break;
            case 2:
                sim.removerVeiculo(id);
                break;
            case 3:
                sim.abastecerVeiculo(id);
                break;
            case 4:
                sim.moverVeiculo(id);
                break;
            case 5:
                sim.moverTodosOsVeiculos();
        }
        input.close();
    }
}
