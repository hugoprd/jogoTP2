package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BotaoProximoInGameHandler{
    PainelJogo pj;

    ArrayList<String> frases = new ArrayList<>();
    int indiceAtual = 0;

    public BotaoProximoInGameHandler(PainelJogo pj){
        this.pj = pj;
    }

    private void carregarFrases(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))){
            String linha;
            while ((linha = br.readLine()) != null) {
                frases.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarCena1(String nome){
        if(frases != null){
            frases.removeAll(frases);
        }
        
        if(nome.equals("kalrok")){
            carregarFrases("/src/lib/cenas/cena1/cena1Kalrok.txt");
        }
        else if(nome.equals("lohan")){
            carregarFrases("/src/lib/cenas/cena1/cena1Lohan.txt");
        }

        indiceAtual = 0;

        if(indiceAtual < frases.size()){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            indiceAtual++;
        }
    }

    public void carregarCena2(String nome){
        if(frases != null){
            frases.removeAll(frases);
        }

        if(nome.equals("kalrok")){
            carregarFrases("/src/lib/cenas/cena2/cena2Kalrok.txt");
        }
        else if(nome.equals("lohan")){
            carregarFrases("/src/lib/cenas/cena2/cena2Lohan.txt");
        }

        indiceAtual = 0;

        if(indiceAtual < frases.size()){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            indiceAtual++;
        }
    }

    public void escreverFrases(ActionEvent e, String nome, int cena){
        pj.csh.tocarClickSound();
        
        if(cena == 1){
            carregarCena1(nome);
        }
        else if(cena == 2){
            carregarCena2(nome);
        }
    }
    
}
