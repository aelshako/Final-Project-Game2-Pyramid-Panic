package src;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Scorpion extends GameObject {
    private static BufferedImage[] left = new BufferedImage[4];
    private static BufferedImage[] right = new BufferedImage[4];
    private boolean isleft = false; //used to set initial direction, and keep track of direction
    private static int player_x;
    private static int player_y;
    private int prev_x;
    private boolean reset_left_img;
    private boolean reset_right_img;
    private int left_index = 0;
    private int right_index = 0;
    private long last_time_left_changed = 0;
    private long last_time_right_changed = 0;



    Scorpion(int spawn_x, int spawn_y, int vx, boolean isLeft_initial){ //vx should always be positive
        this.x = spawn_x;
        this.y = spawn_y;
        this.vx = vx;
        this.isleft = isLeft_initial;
        this.my_rectangle = new Rectangle(x,y,32,32);
    }
    static void setPlayer_pos(int player_x, int player_y){ //constantly gets called in the update for Player with the Player's coordinates
        Scorpion.player_x = player_x;
        Scorpion.player_y = player_y;
    }
    static void set_left_images(BufferedImage l0, BufferedImage l1, BufferedImage l2, BufferedImage l3){ //low(first image in animation) to high(last image in animation)
        Scorpion.left[0] = l0;
        Scorpion.left[1] = l1;
        Scorpion.left[2] = l2;
        Scorpion.left[3] = l3;
    }
    static void set_right_images(BufferedImage r0, BufferedImage r1, BufferedImage r2, BufferedImage r3){ //low(first image in animation) to high(last image in animation)
        Scorpion.right[0] = r0;
        Scorpion.right[1] = r1;
        Scorpion.right[2] = r2;
        Scorpion.right[3] = r3;
    }

    public int getPrev_x() {
        return prev_x;
    }

    public boolean getIsleft() {
        return isleft;
    }

    void switchDirection(){
        this.isleft = !this.isleft;
    }

    public void update() {
    prev_x = x;
        if(this.isleft){
            if(y <= player_y + 10 && y >= player_y - 10 && player_x < x){
                x -= 2*vx;
            }else{
                x -= vx;
            }
        }else{
            if(y <= player_y + 10 && y >= player_y - 10 && player_x > x){
                x += 2*vx;
            }else{
                x += vx;
            }
       }
        this.my_rectangle.setLocation(x, y);
    }


    public void drawImage(Graphics2D g2) {
        if(isleft){
            if(reset_left_img){
                left_index = 1;
                this.reset_left_img = false;
            }

            if(left_index == 4){
                left_index = 0;
            }

            g2.drawImage(left[left_index],this.x, this.y, null );


            if(System.currentTimeMillis() - last_time_left_changed > 300){ //every 300ms we advance the image
                left_index++;
                last_time_left_changed = System.currentTimeMillis();
            }
        }else{ //going right
            if(reset_right_img){
                right_index = 1;
                this.reset_right_img = false;
            }

            if(right_index == 4){
                right_index = 0;
            }

            g2.drawImage(right[right_index],this.x, this.y, null );


            if(System.currentTimeMillis() - last_time_right_changed > 300){ //every 300ms we advance the image
                right_index++;
                last_time_right_changed = System.currentTimeMillis();
            }
        }
    }


    public void collision() {

    }

}
