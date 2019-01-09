package src;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Mummy extends GameObject {
    private static long last_time_scarab_activated = 0;
    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;
    private static int player_x;
    private static int player_y;
    private static boolean scarab_active = false;
    private int x_spawn;
    private int y_spawn;
    private int min_x;
    private int min_y;
    private int max_x;
    private int max_y;

    //variables for animations
    private static BufferedImage[] up = new BufferedImage[4];
    private static BufferedImage[] down = new BufferedImage[4];
    private static BufferedImage[] left = new BufferedImage[4];
    private static BufferedImage[] right = new BufferedImage[4];
    private boolean reset_up_img = false;
    private boolean reset_down_img = false;
    private boolean reset_left_img = false;
    private boolean reset_right_img = false;
    private int up_index = 0; //used to traverse through up images
    private int down_index = 0; //used to traverse through down images
    private int left_index = 0;
    private int right_index = 0;
    private long last_time_up_changed = 0;
    private long last_time_down_changed = 0;
    private long last_time_left_changed = 0;
    private long last_time_right_changed = 0;

    Mummy(int x_spawn, int y_spawn,int min_x,int max_x, int min_y, int max_y, int vx, int vy){
        this.x = x_spawn;
        this.y = y_spawn;
        this.x_spawn = x_spawn;
        this.y_spawn = y_spawn;
        this.vx = vx; //this will later be changed during motion
        this.vy = vy; //this will later be changed during motion
        this.min_x = min_x;
        this.min_y = min_y;
        this.max_x = max_x;
        this.max_y = max_y;
        this.height = up[0].getHeight(); // height is same for all images
        this.width = up[0].getWidth();
        this.my_rectangle = new Rectangle(x,y, up[0].getWidth(), up[0].getHeight());
        this.setDirectionBooleans(true,false,false,false);
    }

    static void setPlayer_pos(int player_x, int player_y){ //constantly gets called in the update for Player with the Player's coordinates
        Mummy.player_x = player_x;
        Mummy.player_y = player_y;
    }
    static void setLast_time_scarab_activated(long t){
        Mummy.last_time_scarab_activated = t;
    }

    static void set_down_images(BufferedImage d0, BufferedImage d1, BufferedImage d2, BufferedImage d3){ //low(first image in animation) to high(last image in animation)
        Mummy.down[0] = d0;
        Mummy.down[1] = d1;
        Mummy.down[2] = d2;
        Mummy.down[3] = d3;
    }
    static void set_up_images(BufferedImage u0, BufferedImage u1, BufferedImage u2, BufferedImage u3){ //low(first image in animation) to high(last image in animation)
        Mummy.up[0] = u0;
        Mummy.up[1] = u1;
        Mummy.up[2] = u2;
        Mummy.up[3] = u3;
    }
    static void set_left_images(BufferedImage l0, BufferedImage l1, BufferedImage l2, BufferedImage l3){ //low(first image in animation) to high(last image in animation)
        Mummy.left[0] = l0;
        Mummy.left[1] = l1;
        Mummy.left[2] = l2;
        Mummy.left[3] = l3;
    }
    static void set_right_images(BufferedImage r0, BufferedImage r1, BufferedImage r2, BufferedImage r3){ //low(first image in animation) to high(last image in animation)
        Mummy.right[0] = r0;
        Mummy.right[1] = r1;
        Mummy.right[2] = r2;
        Mummy.right[3] = r3;
    }
    static void setScarab_active(boolean scarab_active){
        Mummy.scarab_active = scarab_active;
    }
    static boolean getScarab_active(){
        return Mummy.scarab_active;
    }

    private void setDirectionBooleans(boolean isUp, boolean isDown, boolean isLeft, boolean isRight){
        this.isUp = isUp;
        this.isDown = isDown;
        this.isLeft = isLeft;
        this.isRight = isRight;
    }
    public boolean getisUp(){
        return this.isUp;
    }
    public boolean getisDown(){
        return this.isDown;
    }
    public boolean getisLeft(){
        return this.isLeft;
    }
    public boolean getisRight(){
        return this.isRight;
    }

    public void update() {

        double distance_to_player;
        distance_to_player = sqrt(  pow((player_x - x), 2) +  pow((player_y - y), 2)  );
        if(!Mummy.scarab_active){
            if( distance_to_player < 200){
                if(player_x < this.x && this.x -vx >= min_x){ //move left
                    x -= vx;
                    this.setDirectionBooleans(false,false,true,false);
                }
                if(player_x > this.x && this.x + vx <= max_x){ // move right
                    x += vx;
                    this.setDirectionBooleans(false,false,false,true);
                }
                if(player_y < this.y && this.y - vy >= min_y){ // go up
                    y -= vy;
                    this.setDirectionBooleans(true,false,false,false);
                }
                if(player_y > this.y && this.y + vy <= max_y){ // go down
                    y += vy;
                    this.setDirectionBooleans(false,true,false,false);
                }
            }
        }else{
            if(System.currentTimeMillis() - last_time_scarab_activated  < 7000){ // 7 seconds
                    if(player_x < this.x && this.x +vx <= max_x){ //move right
                        x += vx;
                        this.setDirectionBooleans(false,false,false,true);
                    }
                    if(player_x > this.x && this.x - vx >= min_x){ // move left
                        x -= vx;
                        this.setDirectionBooleans(false,false,true,false);
                    }
                    if(player_y < this.y && this.y + vy <= max_y){ // go down
                        y += vy;
                        this.setDirectionBooleans(false,true,false,false);
                    }
                    if(player_y > this.y && this.y - vy >= min_y){ // go up
                        y -= vy;
                        this.setDirectionBooleans(true,false,false,false);
                    }
            }else{ //time is up for scarab, so we disable it
                Mummy.scarab_active = false;
            }
        }


        this.my_rectangle.setLocation(this.x, this.y);
    }


    public void drawImage(Graphics2D g2) {
        if(this.isUp){ //facing up

            if(reset_up_img){ //resets back to the image of the Mummy standing still facing up
                up_index = 1;
                this.reset_up_img = false;
            }

            if(up_index == 4){
                up_index = 0;
            }

            g2.drawImage(up[up_index],this.x, this.y, null );


            if(System.currentTimeMillis() - last_time_up_changed > 300){ //every 300ms we advance the image
                up_index++;
                last_time_up_changed = System.currentTimeMillis();
            }


        }else if(this.isDown){

            if(reset_down_img){ //resets back to the image of the Mummy standing still facing up
                down_index = 1;
                this.reset_down_img = false;
            }

            if(down_index == 4){
                down_index = 0;
            }

            g2.drawImage(down[down_index],this.x, this.y, null );


            if(System.currentTimeMillis() - last_time_down_changed > 300){ //every 300ms we advance the image
                down_index++;
                last_time_down_changed = System.currentTimeMillis();
            }

        }else if(this.isLeft){
            if(reset_left_img){ //resets back to the image of the Mummy standing still facing up
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

        }else if(this.isRight){
            if(reset_right_img){ //resets back to the image of the player standing still facing up
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
