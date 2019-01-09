package src;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pickup extends GameObject {
    static private BufferedImage amulet_img;
    static private BufferedImage anubis_img;
    static private BufferedImage scarab_img;
    static private BufferedImage sword_img;
    private boolean isAnubis;
    private boolean isAmulet;
    private boolean isScarab;
    private boolean isSword;

    Pickup(int x, int y, boolean isAnubis, boolean isAmulet, boolean isScarab, boolean isSword) {
        this.x = x;
        this.y = y;
        this.isAnubis = isAnubis;
        this.isAmulet = isAmulet;
        this.isScarab = isScarab;
        this.isSword = isSword;
        this.my_rectangle = new Rectangle(x, y, Pickup.amulet_img.getWidth() - 4, Pickup.amulet_img.getHeight() - 4); //the -4 is a buffer to make it less likely that 2 get picked up at once
    }

    static void setAmulet_img(BufferedImage img) {
        Pickup.amulet_img = img;
    }

    static void setAnubis_img(BufferedImage img) {
        Pickup.anubis_img = img;
    }

    static void setScarab_img(BufferedImage img) {
        Pickup.scarab_img = img;
    }

    static void setSword_img(BufferedImage img) {
        Pickup.sword_img = img;
    }

    boolean isAnubis() {
        return isAnubis;
    }

    boolean isAmulet() {
        return isAmulet;
    }

    boolean isScarab() {
        return isScarab;
    }

    boolean isSword() {
        return isSword;
    }

    public void update() {

    }

    public void drawImage(Graphics2D g) {
        if (this.isAmulet) {
            g.drawImage(amulet_img, x, y, amulet_img.getWidth(), amulet_img.getHeight(), null);
        }
        if (this.isAnubis) {
            g.drawImage(anubis_img, x, y, anubis_img.getWidth(), anubis_img.getHeight(), null);
        }
        if (this.isScarab) {
            g.drawImage(scarab_img, x, y, scarab_img.getWidth(), scarab_img.getHeight(), null);
        }
        if (this.isSword) {
            g.drawImage(sword_img, x, y, sword_img.getWidth(), sword_img.getHeight(), null);
        }

    }

    public void collision() {

    }
}
