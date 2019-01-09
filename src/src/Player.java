package src;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;

public class Player extends GameObject { //analogous to tank class

    private static BufferedImage[] down = new BufferedImage[4];
    private static BufferedImage[] up = new BufferedImage[4];
    private static BufferedImage[] left = new BufferedImage[4];
    private static BufferedImage[] right = new BufferedImage[4];
    private int prev_x;
    private int prev_y;
    private int vx_abs;
    private int vy_abs;
    private int up_index = 0; //used to traverse through up images
    private int down_index = 0; //used to traverse through down images
    private int left_index = 0;
    private int right_index = 0;
    private boolean reset_up_img = false;
    private boolean reset_down_img = false;
    private boolean reset_left_img = false;
    private boolean reset_right_img = false;
    private BufferedImage img_left;
    private BufferedImage img_right;
    private BufferedImage img_down;
    private BufferedImage img_up;
    private BufferedImage current_img; //this will be changed based on which direction the player is going
    private boolean UpPressed;
    private boolean DownPressed;
    private boolean RightPressed;
    private boolean LeftPressed;
    private boolean EnterPressed;
    private long last_time_up_changed = 0;
    private long last_time_down_changed = 0;
    private long last_time_left_changed = 0;
    private long last_time_right_changed = 0;
    private long last_time_enter_pressed = 0; // this allows us to impose a delay to prevent multiple clicks registering on 1 press
    private long last_deducted_health = 0; //allows us to constantly tick score down until player dies when sword is active

    private int score = 0;
    private int num_scarabs = 0;
    private boolean Sword_active = false;
    private boolean has_sword = false; //will be true once player collects the sword
    // private boolean scarab_active = false;
    private boolean alive = true; //alternative to health, denotes if a player is dead(so we handle that in the main loop of GameWorld)

    Player(int x, int y, int vx, int vy, BufferedImage left, BufferedImage right, BufferedImage down, BufferedImage up) {
        this.x = x;
        this.y = y;
        this.vx = vx; //this will later be changed during motion
        this.vx_abs = abs(vx);
        this.vy_abs = abs(vy);
        this.vy = vy; //this will later be changed during motion
        this.img_left = left;
        this.img_right = right;
        this.img_down = down;
        this.img_up = up;
        this.height = left.getHeight(); // height is same for all images
        this.width = left.getWidth();
        this.my_rectangle = new Rectangle(x, y, img_up.getWidth(), img_up.getHeight());
        this.current_img = img_up; //initially the character is facing up
    }

    static void set_down_images(BufferedImage d0, BufferedImage d1, BufferedImage d2, BufferedImage d3) { //low(first image in animation) to high(last image in animation)
        Player.down[0] = d0;
        Player.down[1] = d1;
        Player.down[2] = d2;
        Player.down[3] = d3;
    }

    static void set_up_images(BufferedImage u0, BufferedImage u1, BufferedImage u2, BufferedImage u3) { //low(first image in animation) to high(last image in animation)
        Player.up[0] = u0;
        Player.up[1] = u1;
        Player.up[2] = u2;
        Player.up[3] = u3;
    }

    static void set_left_images(BufferedImage l0, BufferedImage l1, BufferedImage l2, BufferedImage l3) { //low(first image in animation) to high(last image in animation)
        Player.left[0] = l0;
        Player.left[1] = l1;
        Player.left[2] = l2;
        Player.left[3] = l3;
    }

    static void set_right_images(BufferedImage r0, BufferedImage r1, BufferedImage r2, BufferedImage r3) { //low(first image in animation) to high(last image in animation)
        Player.right[0] = r0;
        Player.right[1] = r1;
        Player.right[2] = r2;
        Player.right[3] = r3;
    }

    void addScore(int score_increment) {
        this.score += score_increment;
    }

    private void removeScore(int score_increment) {
        if (this.score - score_increment <= 0) {
            this.score = 0;
            this.alive = false; //player died, we will handle this in main of GameWorld
        } else {
            this.score -= score_increment;
        }

    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
    }

    void activateSword() {
        this.Sword_active = true;
    }

    boolean isAlive() {
        return alive;
    }

    void setAlive(boolean alive) {
        this.alive = alive;
    }

    boolean getIsSwordActive() {
        return Sword_active;
    }

    int getNum_scarabs() {
        return this.num_scarabs;
    }

    public void setNum_scarabs(int num_scarabs) {
        this.num_scarabs = num_scarabs;
    }

    void addScarab(int scarab_increment) {
        if (this.num_scarabs < 3) { //3 scarabs max
            this.num_scarabs += scarab_increment;
        }

    }

    private void removeScarab(int num_scarabs_to_remove) {
        if (this.num_scarabs - num_scarabs_to_remove <= 0) {
            this.num_scarabs = 0;
        } else {
            this.num_scarabs -= num_scarabs_to_remove;
        }

    }

    public int getPrev_x() {
        return prev_x;
    }

    public void setPrev_x(int prev_x) {
        this.prev_x = prev_x;
    }

    public int getPrev_y() {
        return prev_y;
    }

    public void setPrev_y(int prev_y) {
        this.prev_y = prev_y;
    }

    void toggleUpPressed() {
        this.UpPressed = true;
    }

    void toggleDownPressed() {
        this.DownPressed = true;
    }

    void toggleRightPressed() {
        this.RightPressed = true;
    }

    void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    void unToggleUpPressed() {
        this.UpPressed = false;
    }

    void unToggleDownPressed() {
        this.DownPressed = false;
    }

    void unToggleRightPressed() {
        this.RightPressed = false;
    }

    void unToggleLeftPressed() {
        this.LeftPressed = false;
    }

    void EnterPressed() {
        this.EnterPressed = true;
    }

    void unToggleEnterPressed() {
        this.EnterPressed = false;
    }

    private void moveLeft() {
        vx = -vx_abs;
        vy = 0;
        x += vx;


    }

    private void moveRight() {
        vx = vx_abs;
        vy = 0;
        x += vx;

    }

    private void moveDown() {
        vx = 0;
        vy = vy_abs;
        y += vy;
    }

    private void moveUp() {
        vx = 0;
        vy = -vy_abs;
        y += vy;
    }


    public void update() {

        prev_x = x;
        prev_y = y;

        this.my_rectangle.setLocation(x, y);

        if (this.EnterPressed && this.num_scarabs > 0 && (System.currentTimeMillis() - last_time_enter_pressed > 1000)) { //1 second delay
            System.out.println("scarab activated");
            this.removeScarab(1);
            Mummy.setScarab_active(true);
            Mummy.setLast_time_scarab_activated(System.currentTimeMillis());
            last_time_enter_pressed = System.currentTimeMillis();
        }

        if (this.UpPressed) {
            this.current_img = img_up;
            this.moveUp();


        } else if (this.DownPressed) {
            this.current_img = img_down;
            this.moveDown();


        } else if (this.LeftPressed) {
            this.current_img = img_left;
            this.moveLeft();

        } else if (this.RightPressed) {
            this.current_img = img_right;
            this.moveRight();


        } else { //player is stopped, so we restart to the stopped image
            if (current_img == img_up) {//check all cases
                this.reset_up_img = true;
            } else if (current_img == img_down) {
                this.reset_down_img = true;
            } else if (current_img == img_left) {
                this.reset_left_img = true;
            } else if (current_img == img_right) {
                this.reset_right_img = true;
            }
        }

        if (this.Sword_active && System.currentTimeMillis() - last_deducted_health > 20) { //sword is active, player loses score of 1 every 20ms
            this.removeScore(1); //removeScore will mark the player as dead which will be handled in main if the player's score is 0
            this.last_deducted_health = System.currentTimeMillis();
        }


        Mummy.setPlayer_pos(this.x, this.y); //passing location into the Mummy class
        Beetle.setPlayer_pos(this.x, this.y);
        Scorpion.setPlayer_pos(this.x, this.y);
    }

    public void drawImage(Graphics2D g2) {

        if (this.current_img == img_up) { //facing up

            if (reset_up_img) { //resets back to the image of the player standing still facing up
                up_index = 1;
                this.reset_up_img = false;
            }

            if (up_index == 4) {
                up_index = 0;
            }

            g2.drawImage(up[up_index], this.x, this.y, null);


            if (System.currentTimeMillis() - last_time_up_changed > 250) { //every 250ms we advance the image
                up_index++;
                last_time_up_changed = System.currentTimeMillis();
            }


        } else if (this.current_img == img_down) {

            if (reset_down_img) { //resets back to the image of the player standing still facing up
                down_index = 1;
                this.reset_down_img = false;
            }

            if (down_index == 4) {
                down_index = 0;
            }

            g2.drawImage(down[down_index], this.x, this.y, null);


            if (System.currentTimeMillis() - last_time_down_changed > 250) { //every 250ms we advance the image
                down_index++;
                last_time_down_changed = System.currentTimeMillis();
            }

        } else if (this.current_img == img_left) {
            if (reset_left_img) { //resets back to the image of the player standing still facing up
                left_index = 1;
                this.reset_left_img = false;
            }

            if (left_index == 4) {
                left_index = 0;
            }

            g2.drawImage(left[left_index], this.x, this.y, null);


            if (System.currentTimeMillis() - last_time_left_changed > 250) { //every 250ms we advance the image
                left_index++;
                last_time_left_changed = System.currentTimeMillis();
            }

        } else if (this.current_img == img_right) {
            if (reset_right_img) { //resets back to the image of the player standing still facing up
                right_index = 1;
                this.reset_right_img = false;
            }

            if (right_index == 4) {
                right_index = 0;
            }

            g2.drawImage(right[right_index], this.x, this.y, null);


            if (System.currentTimeMillis() - last_time_right_changed > 250) { //every 250ms we advance the image
                right_index++;
                last_time_right_changed = System.currentTimeMillis();
            }
        }

    }

    public void collision() { //only called when player hits a scorpion or a bettle or a mummy(so they basically die), unless they've used a scarab for the mummy case
        this.alive = false;
    }


    Rectangle getOffsetBounds() {  //the -4 is used as a buffer to make movements in narrow spaces smoother, it is unnoticeable to the player
        return new Rectangle(x, y, img_up.getWidth() - 4, img_up.getHeight() - 4);
    }
}
