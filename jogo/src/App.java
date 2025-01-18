import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class App{
    public static void main(String[] args) throws Exception{
        Frame.criarJanela();

        ArrayList<Item> itensGerais = new ArrayList<>();

        Item clipe = new Item("clipe de papel", 0, 1);
        Item queijo = new Item("queijo", 5, 3);
        Item caixaLeite = new Item("caixa de leite", 2, 1);
        Item garrafaCerveja = new Item("garrafa de cerveja", 3, 2);
        Item peCabra = new Item("pe de cabra", 0, 4);
        itensGerais.add(clipe);
        itensGerais.add(queijo);
        itensGerais.add(caixaLeite);
        itensGerais.add(garrafaCerveja);
        itensGerais.add(peCabra);

        //Comodo quarto = new Comodo("quarto");
        //quarto.addItem(clipe);
        //Comodo cozinha = new Comodo("cozinha");
        //cozinha.addItem(queijo);
        //cozinha.addItem(caixaLeite);
        //cozinha.addItem(garrafaCerveja);
        //Comodo sala = new Comodo("sala");
        //cozinha.addItem(peCabra);
        //Comodo banheiro = new Comodo("banheiro");

        //PersonagemJogavel kalrok = new PersonagemJogavel("kalrok", 54, 50);
    }
}
