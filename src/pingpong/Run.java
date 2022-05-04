package pingpong;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Run {
    public static void main(String[] args) {
        Ball ball = new Ball(1,490,330,40,40, 1, -1);
        Pad pad1 = new Pad(13,40,310,30,100);
        Pad pad2 = new Pad(13,924,310,30,100);
        GameField gameField = new GameField(1024,768,ball,pad1,pad2);
        JFrame jFrame = new JFrame("Ping-Pong");
        Game game = new Game(gameField,jFrame);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1024,768);
        jFrame.setResizable(false);
        jFrame.add(game);
        jFrame.setVisible(true);

    }
}
