public class UsaSimulador {
    public static void main(String[] args){
        Simulador sim = new Simulador();
        for(int i = 0; i<20; i++){
            sim.incluirVeiculo();
        }
        
        sim.moveRandom();
        sim.moveRandom();
        sim.imprimirPista();

    }
}
