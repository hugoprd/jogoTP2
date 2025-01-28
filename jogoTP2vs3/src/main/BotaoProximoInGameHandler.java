package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BotaoProximoInGameHandler{
    PainelJogo pj;

    ArrayList<String> frases = new ArrayList<>();
    int indiceAtual = 0;

    public BotaoProximoInGameHandler(PainelJogo pj){
        this.pj = pj;
    }

    private void carregarFrases(String nomeArquivo) {
        try(InputStream inputStream = getClass().getResourceAsStream(nomeArquivo);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
            String linha;
            while ((linha = br.readLine()) != null) {
                frases.add(linha);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void carregarCena1(String nome){        
        if(nome.equals("kalrok")){
            carregarFrases("/lib/cenas/cena1/cena1Kalrok.txt");
        }
        else if(nome.equals("lohan")){
            carregarFrases("/lib/cenas/cena1/cena1Lohan.txt");
        }

        //System.out.println(frases.size());

        if(indiceAtual < frases.size()){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            pj.sah.tocarSomTexto();
            pj.con.repaint();
        }
        else if(indiceAtual == 6){
            indiceAtual = 0;
        }
        indiceAtual++;
        System.out.println("na cena 1: " + indiceAtual);
    }

    public void carregarCena2(String nome){
        if(frases != null){
            frases.clear();
        }

        if(nome.equals("kalrok")){
            carregarFrases("/lib/cenas/cena2/cena2Kalrok.txt");
        }
        else if(nome.equals("lohan")){
            carregarFrases("/lib/cenas/cena2/cena2Lohan.txt");
        }

        System.out.println(frases.size());

        if(indiceAtual < 12){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            //pj.sah.tocarSomTexto();
            indiceAtual++;
            pj.con.repaint();
            System.out.println("na cena 2: " + indiceAtual);
        }
        else if(indiceAtual == (frases.size() + 1)){
            indiceAtual = 0;
        }
        System.out.println(indiceAtual);
    }

    public void escreverFrases(ActionEvent e, String nome, int cena){
        pj.csh.tocarClickSound();
        //System.out.println("Diretório atual: " + System.getProperty("user.dir"));
        
        if(cena == 1){
            carregarCena1(nome);
        }
        else if(cena == 2){
            carregarCena2(nome);
        }
    }
    
}
