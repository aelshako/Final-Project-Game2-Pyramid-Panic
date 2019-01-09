package src;

import java.awt.*;
import java.util.ArrayList;

public class CollisionHandler {

    ArrayList<GameObject> HandleCollisions(ArrayList<GameObject> game_objects) {

        for (int i = 0; i < game_objects.size(); i++) {
            for (int j = i; j < game_objects.size(); j++) {
                GameObject obj_at_i = game_objects.get(i);
                GameObject obj_at_j = game_objects.get(j);

                if (i != j) {

                    if (obj_at_i instanceof MovableWall && ((MovableWall) obj_at_i).getIs_vertical() && obj_at_j instanceof Player && !((MovableWall) obj_at_i).isIn_collision()) { //we only check Movable Wall to Player because we always add walls before adding the player to our game_object Array List
                        if (obj_at_i.getMy_rectangle().intersects(((Player) obj_at_j).getOffsetBounds())) { //getOffsetBounds has a 4 pixel buffer to allow the player to get closer, to give more of a pushing type animation
                            ((MovableWall) obj_at_i).incrementVy(obj_at_j.getVy()); //moving block with velocity of player in that direction
                        }

                    }
                    if (obj_at_i instanceof MovableWall && ((MovableWall) obj_at_i).getIs_horizontal() && obj_at_j instanceof Player && !((MovableWall) obj_at_i).isIn_collision()) { //horizontal Movable Wall to Player collision
                        if (obj_at_i.getMy_rectangle().intersects(((Player) obj_at_j).getOffsetBounds())) {
                            ((MovableWall) obj_at_i).incrementVx(obj_at_j.getVx());
                        }

                    }
                    if (obj_at_i instanceof MovableWall && (obj_at_j instanceof Wall && !((Wall) obj_at_j).getIsBackground() && !((MovableWall) obj_at_i).isIn_collision())) {
                        if (obj_at_i.getMy_rectangle().intersects(obj_at_j.getMy_rectangle())) {
                            ((MovableWall) obj_at_i).setIn_collision(true);
                        }
                    }
                    if (obj_at_j instanceof MovableWall && (obj_at_i instanceof Wall && !((Wall) obj_at_i).getIsBackground()) && !((MovableWall) obj_at_j).isIn_collision()) {
                        if (obj_at_j.getMy_rectangle().intersects(obj_at_i.getMy_rectangle())) {
                            ((MovableWall) obj_at_j).setIn_collision(true);
                        }
                    }


                    if (obj_at_i instanceof Wall && !((Wall) obj_at_i).getIsBackground() && obj_at_j instanceof Player) {

                        Rectangle r2 = ((Player) obj_at_j).getOffsetBounds();
                        if (r2.intersects(obj_at_i.getMy_rectangle())) {  //intersection occurs
                            obj_at_j.setX(((Player) obj_at_j).getPrev_x());
                            obj_at_j.setY(((Player) obj_at_j).getPrev_y());

                        }

                    }
                    if (obj_at_i instanceof Player && obj_at_j instanceof Pickup) {

                        if (obj_at_i.getMy_rectangle().intersects(obj_at_j.getMy_rectangle())) {
                            if (((Pickup) obj_at_j).isAmulet()) { //+20 to score
                                ((Player) obj_at_i).addScore(20);
                                System.out.println("Amulet picked up!");
                                game_objects.remove(j);

                            } else if (((Pickup) obj_at_j).isAnubis()) { //+100 to score
                                ((Player) obj_at_i).addScore(100);
                                System.out.println("Anubis picked up!");
                                game_objects.remove(j);
                            } else if (((Pickup) obj_at_j).isScarab()) {
                                ((Player) obj_at_i).addScarab(1);
                                System.out.println("Scarab picked up!");
                                game_objects.remove(j);
                            }
                        }

                    }
                    if (((obj_at_i instanceof Wall && !((Wall) obj_at_i).getIsBackground())) && (obj_at_j instanceof Scorpion)) { //non-background wall and scorpion, we don't need the other case because we add walls first, so its always wall to scorpion when they collide

                        if (obj_at_i.getMy_rectangle().intersects(((Scorpion) obj_at_j).getMy_rectangle())) {
                            obj_at_j.setX(((Scorpion) obj_at_j).getPrev_x());
                            ((Scorpion) obj_at_j).switchDirection();
                        }

                    }
                    if (obj_at_i instanceof Wall && (obj_at_j instanceof Beetle) && !((Wall) obj_at_i).getIsBackground()) {
                        if (obj_at_i.getMy_rectangle().intersects(((Beetle) obj_at_j).getMy_rectangle())) {
                            obj_at_j.setY(((Beetle) obj_at_j).getPrev_y());
                            ((Beetle) obj_at_j).switchDirection();
                        }
                    }
                    if (obj_at_i instanceof Player && (obj_at_j instanceof Beetle || obj_at_j instanceof Scorpion)) {
                        if (((Player) obj_at_i).getOffsetBounds().intersects(obj_at_j.getMy_rectangle())) { //we use the player's offset bounds to ensure that a scorpion/beetle actually touches them and isn't a hitbox issue
                            obj_at_i.collision(); //in the collision for the player, we mark the player as dead, which is accounted for in the main loop of game world.
                        }
                    }

                    if (obj_at_i instanceof Player && obj_at_j instanceof Mummy) {
                        if (obj_at_i.getMy_rectangle().intersects(obj_at_j.getMy_rectangle())) {
                            if (Mummy.getScarab_active()) { //active scarab
                                ((Player) obj_at_i).addScore(100);
                                game_objects.remove(j);
                            } else {
                                obj_at_i.collision();
                            }
                        }

                    }

                    if (obj_at_i instanceof Player && obj_at_j instanceof Pickup && ((Pickup) obj_at_j).isSword()) {
                        if (obj_at_i.getMy_rectangle().intersects(obj_at_j.getMy_rectangle())) {
                            ((Player) obj_at_i).activateSword(); //the sword gets activated once picked up and the player must return to the spawn point fast enough
                            System.out.println("Sword picked up");
                            game_objects.remove(j);
                        }

                    }

                }

            }
        }

        return game_objects;
    }
}
