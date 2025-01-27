package entidade;

import java.io.File;
import java.util.ArrayList;

public class PersonagemJogavel implements Personagem{
    protected String nome;
    protected int idade;
    protected int energia;
    protected ArrayList<Item> inventario = new ArrayList<>();

    protected String caminhoSom;
    protected File somPersonagem;

    public PersonagemJogavel(String nome, int idade, int energia, String caminhoSom){
        setNome(nome);
        setIdade(idade);
        setEnergia(energia);
        setCaminhoSom(caminhoSom);
        setSom(getCaminhoSom());
    }

    public String getNome(){
        return nome;
    }

    public boolean setNome(String nome){
        if(nome.length() > 0){
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
        if(energia > 0){
            this.energia = energia;

            return true;
        }

        return false;
    }

    public String getCaminhoSom(){
        return caminhoSom;
    }

    public boolean setCaminhoSom(String caminhoSom){
        if(caminhoSom.length() > 0){
            this.caminhoSom = caminhoSom;

            return true;
        }

        return false;
    }

    public boolean setSom(String caminhoSom){
        try{
            this.somPersonagem = new File(caminhoSom);

            return true;
        }
        catch(Exception e){
            throw e;
        }
    }

    @Override
    public void contarHistoria(){
        throw new UnsupportedOperationException("Unimplemented method 'contarHistoria'");
    }

    @Override
    public void utilizarPoder(){
        throw new UnsupportedOperationException("Unimplemented method 'utilizarPoder'");
    }

    @Override
    public void adicionarItem(Item itemX){
        throw new UnsupportedOperationException("Unimplemented method 'adicionarItem'");
    }
}
