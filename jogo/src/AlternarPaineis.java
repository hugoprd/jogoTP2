import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class AlternarPaineis extends JFrame{
    private static int painelAtual = 0; // Índice atual do painel
    private static final Map<String, Integer> PAINEIS = new LinkedHashMap<>(); // Map com os painéis

    private String nome;

    public AlternarPaineis(String nome){
        PAINEIS.put("apartamento", 1);
        PAINEIS.put("sala", 2);
        PAINEIS.put("quarto", 3);
        PAINEIS.put("cozinha", 4);
        PAINEIS.put("banheiro", 5);
        PAINEIS.put("autoestima", 6);
        PAINEIS.put("chefe", 7);

        int i = 0;
        for (Map.Entry<String, Integer> entrada : PAINEIS.entrySet()){
            JLabel painel = new JLabel();
            //painel.setBackground(new Color(30 + 30 * i, 60 + 20 * i, 150 - 10 * i)); // Cores diferentes
            System.out.println("Feito: " + entrada.getKey() +  "(Valor: + " + entrada.getValue() + "))");
            //Frame.cardPanel.add(painel, entrada.getKey());
            i++;
        }
        //JButton btnAlternar = new JButton("Próximo Painel");
        //btnAlternar.addActionListener(new ActionListener() {
        //    @Override
        //    public void actionPerformed(ActionEvent e) {
        //        alternarPainel();
        //    }
        //});

        //setLayout(new BorderLayout());
        //add(Frame.cardPanel, BorderLayout.CENTER);
        //add(btnAlternar, BorderLayout.SOUTH);

        Jogo.cardLayout.show(Jogo.cardPanel, PAINEIS.keySet().iterator().next());
    }

    public String getNome(){
        return nome;
    }

    public static void alternarPainel(){
        String[] chaves = PAINEIS.keySet().toArray(new String[0]);

        painelAtual = (painelAtual + 1) % PAINEIS.size();

        //Frame.cardLayout.show(Frame.cardPanel, chaves[painelAtual]);
    }
}
