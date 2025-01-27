package saves;

import entidade.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SalvamentoJogo{
    public static void salvarProgresso(String nomeJogador, String personagemJogado, int vida, int energia, ArrayList<Item> inventario){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("save.csv"))){
            // Escreve os dados no arquivo CSV
            writer.write(nomeJogador + "," + personagemJogado + "," + vida + "," + energia + "," + pontuacao + "," + itensColetados + "\n");
            System.out.println("Progresso salvo em CSV com sucesso!");
        }catch (IOException e){
            System.err.println("Erro ao salvar o progresso: " + e.getMessage());
        }
    }
}
