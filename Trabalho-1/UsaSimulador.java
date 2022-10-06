import java.util.Scanner;

import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class UsaSimulador {
    public static void main(String[] args){
        // JOptionPane inputPane = new JOptionPane();
        Scanner input = new Scanner(System.in);
        String opcao = "0";
        Simulador sim = new Simulador();

        while(true){
            if(Integer.parseInt(opcao) == 13) break;
            // System.out.print("Escolha uma opcao: \n");
            opcao = JOptionPane.showInputDialog(null, "Escolha uma opcao: ", "0");
            while(Integer.parseInt(opcao) < 1 || Integer.parseInt(opcao) >13 || opcao == ""){
                opcao = JOptionPane.showInputDialog(null, "Opcao invalida, digite novamente: ", "0");

            }
            menu(Integer.parseInt(opcao), sim);
        }
        
        input.close();
    }

    public static void menu(int opcao, Simulador sim){
        // JOptionPane in = new JOptionPane();
        int id = 0;
        switch(opcao){
            case 1:
                sim.incluirVeiculo();
                break;
            case 2:
                id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do veiculo:"));
                sim.removerVeiculo(id);
                break;
            case 3:
                id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do veiculo:"));
                sim.abastecerVeiculo(id);
                break;
            case 4:
                id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do veiculo:"));
                sim.moverVeiculo(id);
                break;
            case 5:
                sim.moverTodosOsVeiculos();
                break;
            case 6:
                id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do veiculo:"));
                sim.imprimeVeiculo(id);
                break;
            case 7:
                sim.imprimeTodosVeiculos();
                break;
            case 8:
                id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do veiculo:"));
                sim.calibrarPneu(id);
                break;
            case 9:
                id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do veiculo:"));
                sim.calibrarTodosPneus(id);
                break;
            case 10:
                sim.imprimirPista();
                break;
            case 11:
                gravarVeiculosArq(sim);
                break;   
            case 12:
                sim = lerVeiculosArq(JOptionPane.showInputDialog("Digite o caminho do arquivo: "));
                break;
            case 13:
                System.out.println("\n\nVolte Sempre!\n\n");
                break;
            default:
                System.out.println("Opcao Invalida");
                break;
        }
    }

    public static void gravarVeiculosArq(Simulador sim){
        File arquivo = new File("simulador.dat");
        try{
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(sim);
            oos.flush();
            oos.close();
            fout.close();
        }catch (Exception ex){
            System.err.println("Erro: " + ex.toString());
        }
    }

    public static Simulador lerVeiculosArq(String path){
        File arquivo = new File(path);
        Simulador simArq = new Simulador();
        try{
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);

            simArq = (Simulador) oin.readObject();
            simArq.imprimeTodosVeiculos();
            oin.close();
            fin.close();
            return simArq;

        }catch (Exception ex){
            System.err.println("Erro: " + ex.toString());
        }
        return simArq;
    }

    // private static void clearBuffer(Scanner scanner) {
    //     if (scanner.hasNextLine()) {
    //         scanner.nextLine();
    //     }
    // }
}
