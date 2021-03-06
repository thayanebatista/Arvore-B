package arvoreb;

/**
 * UsaArvoreB.java
 *
 * @author Marcos Alves (marcos@ucdb.br)
 *
 * Este programa, de prop�sitos educacionais, implementa uma interface bastante
 * simples para manipulação de uma ArvoreB, implementada atraves da classe {@link ArvoreB).
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsaArvoreB extends JFrame {

    ArvoreB arvore1;
    ArvoreB arvore2;
    JTextField chave;
    JTextField ordem1;
    JTextField ordem2;
    JButton botaoInsere1;
    JButton botaoInsere2;
    JTextArea saida1;
    JTextArea saida2;

    /**
     * Inicia a classe UsaArvoreB criando uma �rvore vazia e apresentando os
     * componentes da Interface Gr�fica
     */
    public UsaArvoreB() {
        arvore1 = new ArvoreB(); // Cria uma arvore.
        arvore2 = new ArvoreB(); // Cria uma arvore.
        criaComponentes();
//        for (int i = 1; i <= 50; ++i ) {
//            arvore.insere(i);
//        }
//        saida1.setText(arvore.mostra(1));
        setVisible(true);
    }

    ;


    /** Mostra o conte�do da �rvore na caixa de texto "saida1" */
    private void mostraArvoreB(ArvoreB arvore, JTextArea saida) {
        saida.setText(arvore.mostra(1));
    }

    /**
     * Cria, posiciona e inicia os componentes da Interface gr�ica, como caixas
     * de textos e botoes
     */
    private void criaComponentes() {

        /**
         * Altera o texto na barra de titulo da Janela.
         */
        setTitle("Programa Simples que Utiliza uma ArvoreB");

        ordem1 = new JTextField(10);
        ordem1.setText("2"); // Ordem default eh 2
        ordem2 = new JTextField(10);
        ordem2.setText("2"); // Ordem default eh 2
        arvore1.setOrdem(2);
        arvore2.setOrdem(3);
        chave = new JTextField(10);

        /**
         * Cria o botao que ao ser clicado, empilha o elemento contido na caixa
         * de texto chave.
         */
        botaoInsere1 = new JButton();
        botaoInsere1.setText("Insere Na Arvore 1");
        botaoInsere1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                // Aqui deve ser colocado o codigo a ser executado quando
                // o usuario clicar no botao.
                arvore1.setOrdem(Integer.parseInt(ordem1.getText()));
                arvore1.insere(Integer.parseInt(chave.getText()));
                mostraArvoreB(arvore1, saida1);
            }
        });

        /**
         * Cria o bot? que ao ser clicado, empilha o elemento contido na caixa
         * de texto chave.
         */
        botaoInsere2 = new JButton();
        botaoInsere2.setText("Insere Na Arvore 2");
        botaoInsere2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                // Aqui deve ser colocado o codigo a ser executado quando
                // o usuario clicar no botao.
                arvore2.setOrdem(Integer.parseInt(ordem2.getText()));
                arvore2.insere(Integer.parseInt(chave.getText()));
                mostraArvoreB(arvore2, saida2);
            }
        });



        /**
         * Cria caixa de texto para mostrar o contedo da pilha (com 20 linhas e
         * 50 colunas
         */
        saida1 = new JTextArea(10, 25);
        saida1.setLineWrap(true);

        saida2 = new JTextArea(10, 25);
        saida2.setLineWrap(true);

        /**
         * Determina como os elementos graficos devem ser posicionados na
         * Janela.
         */
        Container principal = getContentPane();
        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        JPanel ordens = new JPanel();
        ordens.setLayout(new BoxLayout(ordens, BoxLayout.X_AXIS));

        ordens.add(new JLabel("Ordem 1:"));
        ordens.add(ordem1);
        ordens.add(new JLabel("Ordem 2:"));
        ordens.add(ordem2);

        principal.add(ordens);
        principal.add(new JLabel("Entrada:"));
        principal.add(chave);

        /**
         * O Codigo abaixo eh responsavel pelo alinhamento horizontal (X_AXIS)
         * dos dois botoes. Sem esse codigos, os botoes seriam alinhados
         * horizontalmente (Y_AXIS)
         */
        JPanel botoes = new JPanel();
        botoes.setLayout(new BoxLayout(botoes, BoxLayout.X_AXIS));
        botoes.add(botaoInsere1);
        botoes.add(botaoInsere2);

        principal.add(botoes);

        JPanel saidas = new JPanel();
        saidas.setLayout(new BoxLayout(saidas, BoxLayout.X_AXIS));

        saidas.add(saida1);
        saidas.add(saida2);

        principal.add(saidas);

        /**
         * Posicionamento da Janela na Tela do Computador.
         */
        setLocation(100, 40);

        pack();

        /**
         * Fecha o programa quando a janela eh fechada. (Sem o codigo abaixo, a
         * janela fecha mas o programa continua aberto)
         */
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                System.exit(0);
            }
        });


    }

    public static void main(String args[]) {
        new UsaArvoreB();
    }
}
