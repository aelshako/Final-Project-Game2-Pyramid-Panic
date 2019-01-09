package src;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Beetle extends GameObject {
    private static BufferedImage[] up = new BufferedImage[4];
    private static BufferedImage[] down = new BufferedImage[4];
    private static int player_x;
    private static int player_y;
    private int prev_y;
    private boolean isUp; //used to set initial direction, and keep track of direction
    private boolean reset_up_img;
    private boolean reset_down_img;
    private int up_index = 0;
    private int down_index = 0;
    private long last_time_up_changed = 0;
    private long last_time_down_changed = 0;


    Beetle(int spawn_x, int spawn_y, int vy, boolean isUp_initial) { //vy should always be positive
        this.x = spawn_x;
        this.y = spawn_y;
        this.vy = vy;
        this.isUp = isUp_initial;
        this.my_rectangle = new Rectangle(x, y, 32, 32);
    }

    static void setPlayer_pos(int player_x, int player_y) { //constantly gets called in the update for Player with the Player's coordinates
        Beetle.player_x = player_x;
        Beetle.player_y = player_y;
    }

    static void set_up_images(BufferedImage l0, BufferedImage l1, BufferedImage l2, BufferedImage l3) { //low(first image in animation) to high(last image in animation)
        Beetle.up[0] = l0;
        Beetle.up[1] = l1;
        Beetle.up[2] = l2;
        Beetle.up[3] = l3;
    }

    static void set_down_images(BufferedImage r0, BufferedImage r1, BufferedImage r2, BufferedImage r3) { //low(first image in animation) to high(last image in animation)
        Beetle.down[0] = r0;
        Beetle.down[1] = r1;
        Beetle.down[2] = r2;
        Beetle.down[3] = r3;
    }

    public int getPrev_y() {
        return prev_y;
    }

    public boolean getIsUp() {
        return isUp;
    }

    void switchDirection() {

        this.isUp = !this.isUp;

    }

    public void update() {
         this.prev_y = this.y;
        if (this.isUp) {
            if (x <= player_x + 10 && x >= player_x - 10 && player_y < y) {
                y -= 2 * vy;
            } else {
                y -= vy;
            }
        } else { //going down
            if (x <= player_x + 10 && x >= player_x - 10 && player_y > y) {
                y += 2 * vy;
            } else {
                y += vy;
            }
        }
        this.my_rectangle.setLocation(x, y);
    }


    public void drawImage(Graphics2D g2) {
        if (isUp) {
            if (reset_up_img) {
                up_index = 1;
                this.reset_up_img = false;
            }

            if (up_index == 4) {
                up_index = 0;
            }

            g2.drawImage(up[up_index], this.x, this.y, null);


            if (System.currentTimeMillis() - last_time_up_changed > 300) { //every 300ms we advance the image
                up_index++;
                last_time_up_changed = System.currentTimeMillis();
            }
        } else {
            if (reset_down_img) {
                down_index = 1;
                this.reset_down_img = false;
            }

            if (down_index == 4) {
                down_index = 0;
            }

            g2.drawImage(down[down_index], this.x, this.y, null);


            if (System.currentTimeMillis() - last_time_down_changed > 300) { //every 300ms we advance the image
                down_index++;
                last_time_down_changed = System.currentTimeMillis();
            }
        }
    }


    public void collision() {

    }

}
