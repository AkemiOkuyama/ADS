import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RotacaoSprite extends JFrame {
    private static final long serialVersionUID = 1L;
    private final int TAMANHO = 300;
    private final Sprite sprite = new Sprite();

    public RotacaoSprite() {
        add(sprite, BorderLayout.CENTER);
        setTitle("Desafio!");
        setSize(TAMANHO, TAMANHO);
        setLocationRelativeTo(null); // removido "a"
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(new Ouvinte());
    }

    public static void main(String[] args) {
        new RotacaoSprite();
    }

    private class Ouvinte extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    sprite.giraAntiHorario();
                    break;
                case KeyEvent.VK_RIGHT:
                    sprite.giraHorario();
                    break;
            }
        }
    }

    private class Sprite extends JPanel {
        private static final long serialVersionUID = 1L;
        final int ORDEM = 3;

        // desenho inicial
        int[][] desenho = {
            { 1, 1, 1 },
            { 1, 0, 0 },
            { 0, 0, 0 }
        };

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            final int MARGEM_ESQ = 75;
            final int MARGEM_SUP = 50;
            final int TAMANHO_BLOCO = 50;

            for (int i = 0; i < ORDEM; i++) {
                for (int j = 0; j < ORDEM; j++) {
                    if (desenho[i][j] == 1) {
                        g.fillRect(MARGEM_ESQ + j * TAMANHO_BLOCO,
                                   MARGEM_SUP + i * TAMANHO_BLOCO,
                                   TAMANHO_BLOCO, TAMANHO_BLOCO);
                    }
                }
            }
        }

        void giraAntiHorario() {
            final int[][] temp = new int[ORDEM][ORDEM];
            for (int i = 0; i < ORDEM; i++) {
                for (int j = 0; j < ORDEM; j++) {
                    temp[j][ORDEM - i - 1] = desenho[i][j];
                }
            }
            desenho = temp;
            repaint();
        }

        void giraHorario() {
            final int[][] temp = new int[ORDEM][ORDEM];
            for (int i = 0; i < ORDEM; i++) {
                for (int j = 0; j < ORDEM; j++) {
                    temp[ORDEM - j - 1][i] = desenho[i][j];
                }
            }
            desenho = temp;
            repaint();
        }
    }
}
