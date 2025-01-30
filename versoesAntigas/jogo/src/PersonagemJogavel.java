import java.io.File;
import java.util.ArrayList;

public class PersonagemJogavel implements Personagem{
    private String nome;
    private int idade;
    private int energia;
    private ArrayList<Item> inventario = new ArrayList<>();
    private final File som;

    public PersonagemJogavel(String nome, int idade, int energia, File som){
        setNome(nome);
        setIdade(idade);
        setEnergia(energia);
        this.som = som;
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

    public int getIdade(){
        return idade;
    }

    public boolean setIdade(int idade){
        if(idade > 0){
            this.idade = idade;

            return true;
        }

        return false;
    }

    public int getEnergia(){
        return energia;
    }

    public boolean setEnergia(int energia){
        if(energia >= 0){
            this.energia = energia;

            return true;
        }

        return false;
    }

    public void contarHistoria(){
        System.out.println("");
    }

    public void utilizarPoder(){
        System.out.println("");
    }

    public void adicionarItem(Item itemX){
        try{
            if(itemX != null){
                inventario.add(itemX);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
