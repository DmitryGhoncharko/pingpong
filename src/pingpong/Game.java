package pingpong;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.util.*;

public class Game extends JPanel implements KeyListener, ActionListener {
    private static final Set<Integer> KEYS = new HashSet<>(4);
    private final Timer timer = new Timer(5, this);
    private final GameField gameField;
    private final JFrame jFrame;
    private boolean gameIsStart = false;
    private int scopesPlayer1 = 0;
    private int scopesPlayer2 = 0;

    public Game(GameField gameField, JFrame jFrame) {
        this.gameField = gameField;
        this.jFrame = jFrame;
        jFrame.addKeyListener(this);
        timer.setInitialDelay(100);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphics2D = (Graphics2D) g;

        if (gameIsStart) {
            if(scopesPlayer1>=10){
                FontRenderContext fontRenderContext = ((Graphics2D) g).getFontRenderContext();
                Font font = new Font("Serif", Font.BOLD, 25);
                String text = "Win player 1 !!!!";
                TextLayout textLayout = new TextLayout(text, font, fontRenderContext);
                textLayout.draw(graphics2D, 360, 320);
                FontRenderContext fontRenderContext1 = ((Graphics2D) g).getFontRenderContext();
                Font font1 = new Font("Serif", Font.BOLD, 25);
                String text1 = "Press space to restart";
                TextLayout textLayout1 = new TextLayout(text1, font, fontRenderContext1);
                textLayout1.draw(graphics2D, 360, 290);
                gameIsStart = false;
            }else if(scopesPlayer2>=10){
                FontRenderContext fontRenderContext = ((Graphics2D) g).getFontRenderContext();
                Font font = new Font("Serif", Font.BOLD, 25);
                String text = "Win player 2 !!!!";
                TextLayout textLayout = new TextLayout(text, font, fontRenderContext);
                textLayout.draw(graphics2D, 360, 320);
                FontRenderContext fontRenderContext1 = ((Graphics2D) g).getFontRenderContext();
                Font font1 = new Font("Serif", Font.BOLD, 25);
                String text1 = "Press space to restart";
                TextLayout textLayout1 = new TextLayout(text1, font, fontRenderContext1);
                textLayout1.draw(graphics2D, 360, 290);
                gameIsStart = false;
            }else {
                FontRenderContext fontRenderContext = ((Graphics2D) g).getFontRenderContext();
                Font font = new Font("Serif", Font.BOLD, 25);
                String text = "Scopes player 1: " + scopesPlayer1;
                TextLayout textLayout = new TextLayout(text, font, fontRenderContext);
                textLayout.draw(graphics2D, 40, 40);
                FontRenderContext fontRenderContext1 = ((Graphics2D) g).getFontRenderContext();
                Font font1 = new Font("Serif", Font.BOLD, 25);
                String text1 = "Scopes player 2: " + scopesPlayer2;
                TextLayout textLayout1 = new TextLayout(text1, font, fontRenderContext1);
                textLayout1.draw(graphics2D, 680, 40);
                updateBall();
                checkBallCollision();
                regulateBordersForPads();
                graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.fillOval(gameField.getBall().getX(), gameField.getBall().getY(), gameField.getBall().getWidth(), gameField.getBall().getHeight());
                g.fillRect(gameField.getPad1().getX(), gameField.getPad1().getY(), gameField.getPad1().getWidth(), gameField.getPad1().getHeight());
                g.fillRect(gameField.getPad2().getX(), gameField.getPad2().getY(), gameField.getPad2().getWidth(), gameField.getPad2().getHeight());
            }


        } else {
            FontRenderContext fontRenderContext = ((Graphics2D) g).getFontRenderContext();
            Font font = new Font("Serif", Font.BOLD, 25);
            String text = "For start game press space ";
            TextLayout textLayout = new TextLayout(text, font, fontRenderContext);
            textLayout.draw(graphics2D, 360, 320);
            FontRenderContext fontRenderContext1 = ((Graphics2D) g).getFontRenderContext();
            Font font1 = new Font("Serif", Font.BOLD, 25);
            String text1 = "Game played to 10 scopes";
            TextLayout textLayout1 = new TextLayout(text1, font, fontRenderContext1);
            textLayout1.draw(graphics2D, 360, 290);
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if(!gameIsStart){
                gameIsStart = true;
                scopesPlayer1 = 0;
                scopesPlayer2 = 0;
                gameField.getBall().setX(490);
                gameField.getBall().setY(330);
                gameField.getPad1().setX(40);
                gameField.getPad1().setY(310);
                gameField.getPad2().setX(924);
                gameField.getPad2().setY(310);
            }
        }
        if (keyCode == KeyEvent.VK_UP) {
            KEYS.add(KeyEvent.VK_UP);

        } else if (keyCode == KeyEvent.VK_DOWN) {
            KEYS.add(KeyEvent.VK_DOWN);

        } else if (keyCode == KeyEvent.VK_W) {
            KEYS.add(KeyEvent.VK_W);

        } else if (keyCode == KeyEvent.VK_S) {
            KEYS.add(KeyEvent.VK_S);

        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (KEYS.size() > 0) {
            if (KEYS.contains(KeyEvent.VK_W)) {
                gameField.getPad1().setY(gameField.getPad1().getY() - gameField.getPad1().getSpeed());

            }
            if (KEYS.contains(KeyEvent.VK_S)) {
                gameField.getPad1().setY(gameField.getPad1().getY() + gameField.getPad1().getSpeed());

            }
            if (KEYS.contains(KeyEvent.VK_UP)) {

                gameField.getPad2().setY(gameField.getPad2().getY() - gameField.getPad2().getSpeed());
            }
            if (KEYS.contains(KeyEvent.VK_DOWN)) {

                gameField.getPad2().setY(gameField.getPad2().getY() + gameField.getPad2().getSpeed());
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            KEYS.remove(KeyEvent.VK_UP);

        } else if (keyCode == KeyEvent.VK_DOWN) {
            KEYS.remove(KeyEvent.VK_DOWN);

        } else if (keyCode == KeyEvent.VK_W) {
            KEYS.remove(KeyEvent.VK_W);

        } else if (keyCode == KeyEvent.VK_S) {
            KEYS.remove(KeyEvent.VK_S);

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private void checkBallCollision() {
        if (gameField.getBall().getX() <= 0) {
            gameField.getBall().setVectorX(1);
            scopesPlayer1++;
        }
        if (gameField.getBall().getX() >= 984) {
            gameField.getBall().setVectorX(-1);
            scopesPlayer2++;
        }
        if (gameField.getBall().getY() <= 0) {
            gameField.getBall().setVectorY(1);
        }
        if (gameField.getBall().getY() >= 661) {
            gameField.getBall().setVectorY(-1);
        }
        if (gameField.getBall().getX() <= gameField.getPad1().getX() + gameField.getPad1().getWidth() &&
                gameField.getBall().getY() >= gameField.getPad1().getY() && gameField.getBall().getY() <= gameField.getPad1().getY() + gameField.getPad1().getHeight()) {
            gameField.getBall().setVectorX(1);
            int randomNumber = new Random().nextInt(2);
            if (randomNumber == 0) {
                gameField.getBall().setVectorY(-1);
            } else {
                gameField.getBall().setVectorY(1);
            }
        }
        if (gameField.getBall().getX() + gameField.getBall().getWidth() >= gameField.getPad2().getX() &&
                gameField.getBall().getY() >= gameField.getPad2().getY() && gameField.getBall().getY() <= gameField.getPad2().getY() + gameField.getPad2().getHeight()) {
            gameField.getBall().setVectorX(-1);
            int randomNumber = new Random().nextInt(2);
            if (randomNumber == 0) {
                gameField.getBall().setVectorY(-1);
            } else {
                gameField.getBall().setVectorY(1);
            }
        }

    }

    private void updateBall() {
        gameField.getBall().setX(gameField.getBall().getX() + gameField.getBall().getSpeed() * gameField.getBall().getVectorX());
        gameField.getBall().setY(gameField.getBall().getY() + gameField.getBall().getSpeed() * gameField.getBall().getVectorY());
    }

    private void regulateBordersForPads() {
        if (gameField.getPad1().getY() <= 0) {
            gameField.getPad1().setY(1);
        }
        if (gameField.getPad1().getY() >= 661) {
            gameField.getPad1().setY(660);
        }
        if (gameField.getPad2().getY() <= 0) {
            gameField.getPad2().setY(1);
        }
        if (gameField.getPad2().getY() >= 661) {
            gameField.getPad2().setY(660);
        }
    }
}
