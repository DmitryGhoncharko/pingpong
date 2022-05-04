package pingpong;

import javax.swing.*;
import java.awt.*;

public class Pad  {
    private final int speed;
    private final int width;
    private final int height;
    private int x;
    private int y;

    public Pad(int speed, int x, int y, int width, int height) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

        Pad pad = (Pad) o;

        if (speed != pad.speed) return false;
        if (width != pad.width) return false;
        if (height != pad.height) return false;
        if (x != pad.x) return false;
        return y == pad.y;
    }

    @Override
    public int hashCode() {
        int result = speed;
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Pad{" +
                "speed=" + speed +
                ", width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
