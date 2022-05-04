package pingpong;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;

public class Game extends JPanel implements KeyListener, ActionListener {
    private static final Set<Integer> KEYS = new HashSet<>(20);
    private  final Timer timer = new Timer(5,this);
    private final GameField gameField;
    private final JFrame jFrame;
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
        repaint();
        regulateBordersForPads();
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillOval(gameField.getBall().getX(), gameField.getBall().getY(),gameField.getBall().getWidth(),gameField.getBall().getHeight());
        g.fillRect(gameField.getPad1().getX(),gameField.getPad1().getY(),gameField.getPad1().getWidth(),gameField.getPad1().getHeight());
        g.fillRect(gameField.getPad2().getX(),gameField.getPad2().getY(),gameField.getPad2().getWidth(),gameField.getPad2().getHeight());

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_UP){
            KEYS.add(KeyEvent.VK_UP);

        }else if(keyCode==KeyEvent.VK_DOWN){
            KEYS.add(KeyEvent.VK_DOWN);

        }else if(keyCode==KeyEvent.VK_W){
            KEYS.add(KeyEvent.VK_W);

        }else if(keyCode==KeyEvent.VK_S){
            KEYS.add(KeyEvent.VK_S);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(KEYS.size()>0){
            if(KEYS.contains(KeyEvent.VK_UP)){

                gameField.getPad1().setY(gameField.getPad1().getY()-gameField.getPad1().getSpeed());
            }
            if(KEYS.contains(KeyEvent.VK_DOWN)){

                gameField.getPad1().setY(gameField.getPad1().getY()+gameField.getPad1().getSpeed());
            }
            if(KEYS.contains(KeyEvent.VK_W)){

                gameField.getPad2().setY(gameField.getPad2().getY()-gameField.getPad2().getSpeed());
            }
            if(KEYS.contains(KeyEvent.VK_S)){

                gameField.getPad2().setY(gameField.getPad2().getY()+gameField.getPad2().getSpeed());
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_UP){
            KEYS.remove(KeyEvent.VK_UP);

        }else if(keyCode==KeyEvent.VK_DOWN){
            KEYS.remove(KeyEvent.VK_DOWN);

        }else if(keyCode==KeyEvent.VK_W){
            KEYS.remove(KeyEvent.VK_W);

        }else if(keyCode==KeyEvent.VK_S){
            KEYS.remove(KeyEvent.VK_S);

        }
    }
    private void regulateBordersForPads(){
        if(gameField.getPad1().getY()<=0){
            gameField.getPad1().setY(1);
        }
        if(gameField.getPad1().getY()>=661){
            gameField.getPad1().setY(660);
        }
        if(gameField.getPad2().getY()<=0){
            gameField.getPad2().setY(1);
        }
        if(gameField.getPad2().getY()>=661){
            gameField.getPad2().setY(660);
        }
    }
}
