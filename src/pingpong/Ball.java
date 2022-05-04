package pingpong;


public class Ball {
    private final int speed;
    private final int height;
    private final int width;
    private  int vectorX;
    private  int vectorY;
    private int x;
    private int y;

    public Ball(int speed, int x, int y, int width, int height, int vectorX, int vectorY) {
        this.speed = speed;
        this.height = height;
        this.width = width;
        this.vectorX = vectorX;
        this.vectorY = vectorY;
        this.x = x;
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getVectorX() {
        return vectorX;
    }

    public void setVectorX(int vectorX) {
        this.vectorX = vectorX;
    }

    public int getVectorY() {
        return vectorY;
    }

    public void setVectorY(int vectorY) {
        this.vectorY = vectorY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (speed != ball.speed) return false;
        if (height != ball.height) return false;
        if (width != ball.width) return false;
        if (vectorX != ball.vectorX) return false;
        if (vectorY != ball.vectorY) return false;
        if (x != ball.x) return false;
        return y == ball.y;
    }

    @Override
    public int hashCode() {
        int result = speed;
        result = 31 * result + height;
        result = 31 * result + width;
        result = 31 * result + vectorX;
        result = 31 * result + vectorY;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "speed=" + speed +
                ", height=" + height +
                ", width=" + width +
                ", vectorX=" + vectorX +
                ", vectorY=" + vectorY +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
