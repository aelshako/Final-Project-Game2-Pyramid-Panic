package src;

import java.util.ArrayList;

public class CreatureCreator {
    ArrayList<GameObject> CreateCreatures() {
        ArrayList<GameObject> Creature_list = new ArrayList<>();

        //adding scorpions
        //left triangle
        Creature_list.add(new Scorpion(10 * 32, 60 * 32, 5, false));
        Creature_list.add(new Scorpion(10 * 32, 62 * 32, 5, false));

        //right triangle
        Creature_list.add(new Scorpion(48 * 32, 60 * 32, 5, false));
        Creature_list.add(new Scorpion(48 * 32, 62 * 32, 5, false));


        //rightmost rectangle
        Creature_list.add(new Scorpion(57 * 32, 50 * 32, 4, false));
        Creature_list.add(new Scorpion(55 * 32, 70 * 32, 5, false));

        //lower center area
        Creature_list.add(new Scorpion(17 * 32, 50 * 32, 3, false));
        Creature_list.add(new Scorpion(15 * 32, 70 * 32, 3, false));

        //leftmost rectangle
        Creature_list.add(new Scorpion(7 * 32, 50 * 32, 5, false));
        Creature_list.add(new Scorpion(5 * 32, 70 * 32, 4, false));

        //upper scorpion area
        Creature_list.add(new Scorpion(35 * 32, 15 * 32, 5, false));
        Creature_list.add(new Scorpion(35 * 32, 12 * 32, 4, false));

        //adding beetles
        Creature_list.add(new Beetle(34 * 32, 20 * 32, 2, false));
        Creature_list.add(new Beetle(27 * 32, 23 * 32, 2, false));
        Creature_list.add(new Beetle(32, 50 * 32, 3, false));
        Creature_list.add(new Beetle(58 * 32, 50 * 32, 3, false));

        //adding mummy
        Creature_list.add(new Mummy(6 * 32, 43 * 32, 194, 386, 1216, 1372, 2, 2));
        Creature_list.add(new Mummy(9 * 32, 43 * 32 - 5 * 32, 194, 386, 1216, 1372, 2, 2));
        Creature_list.add(new Mummy(9 * 32, 43 * 32 - 5 * 32, 194, 386, 1216, 1372, 2, 2));
        Creature_list.add(new Mummy(48 * 32, 43 * 32 - 5 * 32, 48 * 32, 48 * 32 + 6 * 32, 1216, 1372, 2, 2));
        Creature_list.add(new Mummy(48 * 32 + 6 * 32, 48 * 32 - 5 * 32, 48 * 32, 48 * 32 + 6 * 32, 1216, 1372, 2, 2));

        return Creature_list;
    }
}
