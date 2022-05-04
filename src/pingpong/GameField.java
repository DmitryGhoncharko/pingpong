package pingpong;


import java.util.Objects;

public class GameField {
    private final int gameFieldSizeX;
    private final int gameFieldSizeY;
    private final Ball ball;
    private final Pad pad1;
    private final Pad pad2;

    public GameField(int gameFieldSizeX, int gameFieldSizeY, Ball ball, Pad pad1, Pad pad2) {
        this.gameFieldSizeX = gameFieldSizeX;
        this.gameFieldSizeY = gameFieldSizeY;
        this.ball = ball;
        this.pad1 = pad1;
        this.pad2 = pad2;
    }

    public int getGameFieldSizeX() {
        return gameFieldSizeX;
    }

    public int getGameFieldSizeY() {
        return gameFieldSizeY;
    }

    public Ball getBall() {
        return ball;
    }

    public Pad getPad1() {
        return pad1;
    }

    public Pad getPad2() {
        return pad2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameField gameField = (GameField) o;

        if (gameFieldSizeX != gameField.gameFieldSizeX) return false;
        if (gameFieldSizeY != gameField.gameFieldSizeY) return false;
        if (!Objects.equals(ball, gameField.ball)) return false;
        if (!Objects.equals(pad1, gameField.pad1)) return false;
        return Objects.equals(pad2, gameField.pad2);
    }

    @Override
    public int hashCode() {
        int result = gameFieldSizeX;
        result = 31 * result + gameFieldSizeY;
        result = 31 * result + (ball != null ? ball.hashCode() : 0);
        result = 31 * result + (pad1 != null ? pad1.hashCode() : 0);
        result = 31 * result + (pad2 != null ? pad2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GameField{" +
                "gameFieldSizeX=" + gameFieldSizeX +
                ", gameFieldSizeY=" + gameFieldSizeY +
                ", ball=" + ball +
                ", pad1=" + pad1 +
                ", pad2=" + pad2 +
                '}';
    }
    //    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//
//
//    }


}
