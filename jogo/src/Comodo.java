import java.util.ArrayList;
import javax.swing.JPanel;

public class Comodo implements Obstaculo{
    private String nome;
    private final String caminhoImagem;
    private JPanel painel = new JPanel();
    private ArrayList<Item> itens = new ArrayList<>();

    public Comodo(String nome, String caminhoImagem){
        setNome(nome);
        this.caminhoImagem = caminhoImagem;
    }

    public String getNome(){
        return nome;
    }

    public boolean setNome(String nome){
        if(nome.length() >= 1){
            this.nome = nome;

            return true;
        }

        return false;
    }

    public ArrayList<Item> getItens(){
        return itens;
    }

    public boolean addItem(Item itemX){
        if(itemX != null){
            itens.add(itemX);

            return true;
        }

        return false;
    }

    @Override
    public void interageComPersonagem(PersonagemJogavel personagem){
        throw new UnsupportedOperationException("Unimplemented method 'interageComPersonagem'");
    }
}
