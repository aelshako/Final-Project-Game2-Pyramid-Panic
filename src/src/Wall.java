package src;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Wall extends GameObject{
    private boolean is_background;          //denotes if the wall is a background wall
    private boolean is_border;     //denotes if wall is a border wall(uses a different image)
    private boolean is_sword;
    private static BufferedImage background_img;
    private static BufferedImage unmovable_wall_img; //32x32 //change to regular wall img
    private static BufferedImage border_wall_img;
    private static BufferedImage sword_wall_img; //this is a special red wall that surrounds the sword in a checker configuration


    static void set_unmovable_wall_img(BufferedImage image) {
        unmovable_wall_img = image;

    }

    static void setBackground_img(BufferedImage image) {
        background_img = image;
    }

    static void setBorder_wall_img(BufferedImage image){
        border_wall_img = image;
    }
    static void setSword_wall_img(BufferedImage image){
        sword_wall_img = image;
    }

    boolean getIsBackground(){
        return this.is_background;
    }
    Wall(){

    }

    Wall(int x, int y, boolean is_background, boolean is_border, boolean is_sword) {
        this.x = x;
        this.y = y;
        this.vx = 0;
        this.vy = 0;
        this.is_border = is_border;
        this.is_background = is_background;
        this.is_sword = is_sword;
        this.my_rectangle = new Rectangle(x, y, unmovable_wall_img.getWidth(), unmovable_wall_img.getHeight());

    }

    public void update() {

    }

    public void collision() { //we only call this if the wall is breakable

    }

    public void drawImage(Graphics2D g2d) {

        if (this.is_background) { //it is a background image
            g2d.drawImage(background_img, x, y, null);
        } else if(this.is_border){              //unbreakable wall
            g2d.drawImage(border_wall_img, x, y, null);
        }else if(this.is_sword){ //sword wall
            g2d.drawImage(sword_wall_img, x, y,null);
        }else{ //regular wall
            g2d.drawImage(unmovable_wall_img, x, y,null);
        }

    }
}
