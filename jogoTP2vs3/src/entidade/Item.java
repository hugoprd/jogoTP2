package entidade;

public class Item{
    protected String nome;
    protected int recEnergia;
    protected int dificuldadeAchar;
    protected boolean pista;

    public Item(String nome, int recEnergia, int dificuldadeAchar, boolean pista){
        setNome(nome);
        setRecEnergia(recEnergia);
        setDificuldadeAchar(dificuldadeAchar);
        this.pista = pista;
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

    public int getRecEnergia(){
        return recEnergia;
    }

    public boolean setRecEnergia(int recEnergia){
        if(recEnergia > 0){
            this.recEnergia = recEnergia;

            return true;
        }

        return false;
    }

    public int getDificuldadeAchar(){
        return dificuldadeAchar;
    }

    public boolean setDificuldadeAchar(int dificuldadeAchar){
        if(dificuldadeAchar >= 0){
            this.dificuldadeAchar = dificuldadeAchar;

            return true;
        }

        return false;
    }

    public boolean getPista(){
        return pista;
    }
}
