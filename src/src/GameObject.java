package src;


import java.awt.*;

public abstract class GameObject {
    int x;
    int y;
    int vx;
    int vy;
    int height;
    int width;

    Rectangle my_rectangle;

    int getX() {
        return this.x;
    }

    void setX(int x_to_set) {
        this.x = x_to_set;
    }

    int getY() {
        return this.y;
    }

    void setY(int y_to_set) {
        this.y = y_to_set;
    }

    int getVx() {
        return vx;
    }

    void setVx(int vx) {
        this.vx = vx;
    }

    int getVy() {
        return vy;
    }

    void setVy(int vy) {
        this.vy = vy;
    }

    Rectangle getMy_rectangle() {
        return this.my_rectangle;
    }

    public abstract void update();

    public abstract void drawImage(Graphics2D g);

    public abstract void collision();

}

