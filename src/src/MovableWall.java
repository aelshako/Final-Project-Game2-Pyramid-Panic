package src;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MovableWall extends Wall {

    private static BufferedImage horiz_img;
    private static BufferedImage vert_img;
    private boolean is_vertical;
    private boolean is_horizontal;
    private int x_spawn;
    private int y_spawn;
    private boolean in_collision = false;

    MovableWall(int x, int y, int vx, int vy, boolean is_vertical, boolean is_horizontal) {
        this.x = x;
        this.y = y;
        this.x_spawn = x;
        this.y_spawn = y;
        this.vx = vx;
        this.vy = vy;
        this.is_vertical = is_vertical;
        this.is_horizontal = is_horizontal;
        this.my_rectangle = new Rectangle(this.x_spawn, this.y_spawn, horiz_img.getWidth(), horiz_img.getHeight());
    }

    static void setHoriz_img(BufferedImage horiz_img) {
        MovableWall.horiz_img = horiz_img;
    }

    static void setVert_img(BufferedImage vert_img) {
        MovableWall.vert_img = vert_img;
    }

    boolean isIn_collision() {
        return in_collision;
    }

    void setIn_collision(boolean in_collision) {
        this.in_collision = in_collision;
    }

    boolean getIs_vertical() {
        return is_vertical;
    }

    public void setIs_vertical(boolean is_vertical) {
        this.is_vertical = is_vertical;
    }

    boolean getIs_horizontal() {
        return is_horizontal;
    }

    public void setIs_horizontal(boolean is_horizontal) {
        this.is_horizontal = is_horizontal;
    }

    void incrementVx(int increment_vx) { //used only for horizontal walls
        //   prev_x = x;
        if (!in_collision) {
            x += increment_vx;
            this.my_rectangle.setLocation(this.x, this.y);
        }

    }

    void incrementVy(int increment_vy) {  //used only for vertical walls
        //   prev_y = y;
        if (!in_collision) {
            y += increment_vy;
            this.my_rectangle.setLocation(this.x, this.y);
        }

    }

    public void update() {

    }

    public void collision() {

    }

    public void drawImage(Graphics2D g2d) {
        if (this.is_vertical) {
            g2d.drawImage(vert_img, x, y, null);
        } else if (this.is_horizontal) {
            g2d.drawImage(horiz_img, x, y, null);
        }
    }

}
