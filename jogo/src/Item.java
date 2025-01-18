public class Item{
    private String nome;
    private int recEnergia;
    private int dificuldade;

    public Item(String nome, int recEnergia, int dificuldade){
        setNome(nome);
        setRecEnergia(recEnergia);
        setDificuldade(dificuldade);
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

    public int getRecEnergia(){
        return recEnergia;
    }

    public boolean setRecEnergia(int recEnergia){
        if(recEnergia >= 0){
            this.recEnergia = recEnergia;

            return true;
        }

        return false;
    }

    public int getDificuldade(){
        return dificuldade;
    }

    public boolean setDificuldade(int dificuldade){
        if(dificuldade >= 0){
            this.dificuldade = dificuldade;

            return true;
        }

        return false;
    }

    public void exibirInformacoes(){
        System.out.println("");
    }
}
