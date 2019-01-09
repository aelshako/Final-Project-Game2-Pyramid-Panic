package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControl implements KeyListener {

    private final int up;
    private final int down;
    private final int left;
    private final int right;
    private final int enter;
    private final int space;
    private Player p;

    PlayerControl(Player p, int up, int down, int left, int right, int enter, int space) {
        this.p = p;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.space = space;
        this.enter = enter;
    }


    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();
        if (keyPressed == up) {
            this.p.toggleUpPressed();
        }
        if (keyPressed == down) {
            this.p.toggleDownPressed();
        }
        if (keyPressed == left) {
            this.p.toggleLeftPressed();
        }
        if (keyPressed == right) {
            this.p.toggleRightPressed();
        }
        if (keyPressed == enter) {
            this.p.EnterPressed();
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();
        if (keyReleased == up) {
            this.p.unToggleUpPressed();
        }
        if (keyReleased == down) {
            this.p.unToggleDownPressed();
        }
        if (keyReleased == left) {
            this.p.unToggleLeftPressed();
        }
        if (keyReleased == right) {
            this.p.unToggleRightPressed();
        }
        if (keyReleased == enter) {
            this.p.unToggleEnterPressed();
        }


    }
}
