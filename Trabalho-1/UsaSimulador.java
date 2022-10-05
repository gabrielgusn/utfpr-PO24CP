

public class UsaSimulador {
    public static void main(String[] args){
        Simulador sim = new Simulador();

        for(int i = 0; i<20; i++){
            sim.incluirVeiculo();
            // System.out.println("\n" + sim.getQtd());
            // sim.imprimeVeiculo(sim.getVeiculo(i));
            System.out.println("id veiculo " + i + ": " + sim.getVeiculo(i).getId());
        }
        

    }

    public void menu(){

    }
}
