package saves;

import entidade.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SalvamentoJogo{
    public static void salvarProgresso(String nomeJogador, String personagemJogado, int vida, int energia, int pontuacao, ArrayList<Item> inventario, String comodoAtual){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("save.csv"))){
            String itensColetados = "";
            for(Item itemX : inventario){
                itensColetados.concat(itemX.getNome() + ", ");
            }
            writer.write(nomeJogador + "," + personagemJogado + "," + vida + "," + energia + "," + pontuacao + "," + itensColetados + "," + comodoAtual + "\n");
            System.out.println("Progresso salvo em CSV com sucesso");
        }catch (IOException e){
            System.err.println("Erro ao salvar o progresso: " + e.getMessage());
        }
    }
}
