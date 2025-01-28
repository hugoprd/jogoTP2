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

        if(indiceAtual < 13){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            //pj.sah.tocarSomTexto();
            pj.con.repaint();
        }
        else if(indiceAtual == (frases.size() + 1)){
            indiceAtual = 0;
        }
        indiceAtual++;
        System.out.println("na cena 2: " + indiceAtual);
        //System.out.println(indiceAtual);
    }

    public void carregarCena3(String nome){
        if(frases != null){
            frases.clear();
        }

        if(nome.equals("kalrok")){
            carregarFrases("/lib/cenas/cena2/cena3Kalrok.txt");
        }
        else if(nome.equals("lohan")){
            carregarFrases("/lib/cenas/cena2/cena3Lohan.txt");
        }

        System.out.println(frases.size());

        if(indiceAtual < 13){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            //pj.sah.tocarSomTexto();
            pj.con.repaint();
        }
        else if(indiceAtual == (frases.size() + 1)){
            indiceAtual = 0;
        }
        indiceAtual++;
        System.out.println("na cena 2: " + indiceAtual);
        //System.out.println(indiceAtual);
    }

    public void carregarCena4(String nome){
        if(frases != null){
            frases.clear();
        }

        if(nome.equals("kalrok")){
            carregarFrases("/lib/cenas/cena2/cena3ComodaKalrok.txt");
        }
        else if(nome.equals("lohan")){
            carregarFrases("/lib/cenas/cena2/cena3ComodaLohan.txt");
        }

        System.out.println(frases.size());

        if(indiceAtual < 2){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            //pj.sah.tocarSomTexto();
            pj.con.repaint();
        }
        else if(indiceAtual == 3){
            indiceAtual = 0;
        }
        indiceAtual++;
        System.out.println("na cena 3: comoda: " + indiceAtual);
        //System.out.println(indiceAtual);
    }

    public void carregarCena5(String nome){
        if(frases != null){
            frases.clear();
        }

        if(nome.equals("kalrok")){
            carregarFrases("/lib/cenas/cena2/cena3Comoda2Kalrok.txt");
        }
        else if(nome.equals("lohan")){
            carregarFrases("/lib/cenas/cena2/cena3Comoda2Lohan.txt");
        }

        System.out.println(frases.size());

        if(indiceAtual < 7){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            //pj.sah.tocarSomTexto();
            pj.con.repaint();
        }
        else if(indiceAtual == 8){
            indiceAtual = 0;
        }
        indiceAtual++;
        System.out.println("na cena 3: comoda 2: " + indiceAtual);
        //System.out.println(indiceAtual);
    }

    public void carregarCena6(String nome){
        if(frases != null){
            frases.clear();
        }

        if(nome.equals("kalrok")){
            carregarFrases("/lib/cenas/cena2/cena3PocaKalrok.txt");
        }
        else if(nome.equals("lohan")){
            carregarFrases("/lib/cenas/cena2/cena3PocaLohan.txt");
        }

        System.out.println(frases.size());

        if(indiceAtual < 13){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            //pj.sah.tocarSomTexto();
            pj.con.repaint();
        }
        else if(indiceAtual == (frases.size() + 1)){
            indiceAtual = 0;
        }
        indiceAtual++;
        System.out.println("na cena 2: " + indiceAtual);
        //System.out.println(indiceAtual);
    }

    public void carregarCena7(String nome){
        if(frases != null){
            frases.clear();
        }

        if(nome.equals("kalrok")){
            carregarFrases("/lib/cenas/cena2/cena3PocaKalrok.txt");
        }
        else if(nome.equals("lohan")){
            carregarFrases("/lib/cenas/cena2/cena3PocaLohan.txt");
        }

        System.out.println(frases.size());

        if(indiceAtual < 13){
            pj.areaTextoPadrao.setText(frases.get(indiceAtual));
            //pj.sah.tocarSomTexto();
            pj.con.repaint();
        }
        else if(indiceAtual == (frases.size() + 1)){
            indiceAtual = 0;
        }
        indiceAtual++;
        System.out.println("na cena 2: " + indiceAtual);
        //System.out.println(indiceAtual);
    }

    public void escreverFrases(ActionEvent e, String nome, int cena){
        pj.csh.tocarClickSound();
        //System.out.println("Diretório atual: " + System.getProperty("user.dir"));
        
        if(cena == 1){ // cena 3
            carregarCena1(nome);
        }
        else if(cena == 2){ // cena 2
            carregarCena2(nome);
        }
        else if(cena == 3){ // cena 3
            carregarCena3(nome);
        }
        else if(cena == 4){ // cena 3: comoda
            carregarCena4(nome);
        }
        else if(cena == 5){ // cena 3: comoda 2: aceitou investigar
            carregarCena5(nome);
        }
        else if(cena == 6){ // cena 3: poltrona
            carregarCena6(nome);
        }
        else if(cena == 7){ // cena 3: poltrona 2: aceitou investigar
            carregarCena7(nome);
        }
    }
    
}
