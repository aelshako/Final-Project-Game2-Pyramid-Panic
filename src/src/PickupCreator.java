package src;

import java.util.ArrayList;

public class PickupCreator {

    ArrayList<Pickup> CreatePickups(){
        ArrayList<Pickup> Pickup_list = new ArrayList<>();

        //left triangle portion
        Pickup_list.add(new Pickup(10*32,67*32,true,false, false, false));
        Pickup_list.add(new Pickup(11*32,66*32,false,true, false,false));
        Pickup_list.add(new Pickup(12*32,65*32,false,true, false,false));
        Pickup_list.add(new Pickup(13*32,64*32,false,true, false,false));
        Pickup_list.add(new Pickup(14*32,63*32,false,true, false,false));

        Pickup_list.add(new Pickup(10*32,55*32,true,false, false,false));
        Pickup_list.add(new Pickup(11*32,56*32,false,true, false,false));
        Pickup_list.add(new Pickup(12*32,57*32,false,true, false,false));
        Pickup_list.add(new Pickup(13*32,58*32,false,true, false,false));
        Pickup_list.add(new Pickup(14*32,59*32,false,true, false,false));

        //right triangle portion
        Pickup_list.add(new Pickup(49*32,67*32,false,false, false,false));
        Pickup_list.add(new Pickup(48*32,66*32,false,true, false,false));
        Pickup_list.add(new Pickup(47*32,65*32,false,true, false,false));
        Pickup_list.add(new Pickup(46*32,64*32,false,true, false,false));
        Pickup_list.add(new Pickup(45*32,63*32,false,true, false,false));

        Pickup_list.add(new Pickup(45*32,59*32,false,true, false,false));
        Pickup_list.add(new Pickup(46*32,58*32,false,true, false,false));
        Pickup_list.add(new Pickup(47*32,57*32,false,true, false,false));
        Pickup_list.add(new Pickup(48*32,56*32,false,true, false,false));
        Pickup_list.add(new Pickup(49*32,55*32,true,false, false,false));

        //left square portion
        Pickup_list.add(new Pickup(9*32,41*32,true,false, false,false));
        Pickup_list.add(new Pickup(6*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(7*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(8*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(9*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(10*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(11*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(12*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(17*32,40*32,false,false, true,false));

        Pickup_list.add(new Pickup(6*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(7*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(8*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(9*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(10*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(11*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(12*32,43*32,false,true, false,false));

        //right square portion
        Pickup_list.add(new Pickup(51*32,41*32,true,false, false,false));
        Pickup_list.add(new Pickup(48*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(49*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(50*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(51*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(52*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(53*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(54*32,38*32,false,true, false,false));
        Pickup_list.add(new Pickup(43*32,40*32,false,false, true,false));

        Pickup_list.add(new Pickup(48*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(49*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(50*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(51*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(52*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(53*32,43*32,false,true, false,false));
        Pickup_list.add(new Pickup(54*32,43*32,false,true, false,false));

        //middle corridor portion
        Pickup_list.add(new Pickup(27*32,61*32,false,true, false,false));
        Pickup_list.add(new Pickup(27*32,62*32,false,true, false,false));
        Pickup_list.add(new Pickup(27*32,63*32,false,true, false,false));
        Pickup_list.add(new Pickup(27*32,64*32,false,true, false,false));
        Pickup_list.add(new Pickup(27*32,65*32,false,true, false,false));

        Pickup_list.add(new Pickup(29*32,65*32,false,true, false,false));
        Pickup_list.add(new Pickup(30*32,65*32,false,true, false,false));
        Pickup_list.add(new Pickup(31*32,65*32,false,true, false,false));
        Pickup_list.add(new Pickup(32*32,65*32,false,true, false,false));

        Pickup_list.add(new Pickup(34*32,65*32,false,true, false,false));
        Pickup_list.add(new Pickup(34*32,64*32,false,true, false,false));
        Pickup_list.add(new Pickup(34*32,63*32,false,true, false,false));
        Pickup_list.add(new Pickup(34*32,62*32,false,true, false,false));
        Pickup_list.add(new Pickup(34*32,61*32,false,true, false,false));

        //upper portion
        Pickup_list.add(new Pickup(24*32,18*32,true,false, false,false));
        Pickup_list.add(new Pickup(24*32,22*32,true,false, false,false));
        Pickup_list.add(new Pickup(24*32,26*32,true,false, false,false));
        Pickup_list.add(new Pickup(24*32,30*32,true,false, false,false));

        Pickup_list.add(new Pickup(37*32,18*32,true,false, false,false));
        Pickup_list.add(new Pickup(37*32,22*32,true,false, false,false));
        Pickup_list.add(new Pickup(37*32,26*32,true,false, false,false));
        Pickup_list.add(new Pickup(37*32,30*32,true,false, false,false));

        Pickup_list.add(new Pickup(34*32,20*32,false,true, false,false));
        Pickup_list.add(new Pickup(34*32,21*32,false,true, false,false));
        Pickup_list.add(new Pickup(34*32,22*32,false,true, false,false));
        Pickup_list.add(new Pickup(34*32,23*32,false,true, false,false));
        Pickup_list.add(new Pickup(34*32,24*32,false,true, false,false));

        Pickup_list.add(new Pickup(27*32,20*32,false,true, false,false));
        Pickup_list.add(new Pickup(27*32,21*32,false,true, false,false));
        Pickup_list.add(new Pickup(27*32,22*32,false,true, false,false));
        Pickup_list.add(new Pickup(27*32,23*32,false,true, false,false));
        Pickup_list.add(new Pickup(27*32,24*32,false,true, false,false));

        //upper scorpion portion
        Pickup_list.add(new Pickup(24*32,12*32,false,true, false,false));
        Pickup_list.add(new Pickup(26*32,12*32,false,true, false,false));
        Pickup_list.add(new Pickup(28*32,12*32,false,true, false,false));
        Pickup_list.add(new Pickup(30*32,12*32,false,true, false,false));
        Pickup_list.add(new Pickup(32*32,12*32,false,true, false,false));
        Pickup_list.add(new Pickup(34*32,12*32,false,true, false,false));
        Pickup_list.add(new Pickup(36*32,12*32,false,true, false,false));

        //top horizontal corridor
        for(int i = 0; i < 13; i++){
            Pickup_list.add(new Pickup(26*32 + i*32,2*32,false,true, false,false));
            Pickup_list.add(new Pickup(26*32 + i*32,32,false,true, false,false));
        }
        Pickup_list.add(new Pickup(23*32 ,2*32,false,false, true,false));
        Pickup_list.add(new Pickup(23*32 ,32,false,false, true,false));

        //sword area
        for(int i = 0; i < 12; i++){
            for(int j = 0; j <3;j++){
                Pickup_list.add(new Pickup(46*32 +j*32,6*32 + i*32,false,true, false,false));

            }
        }
        for(int i = 0; i < 12; i++){
            for(int j = 0; j <3;j++){
                Pickup_list.add(new Pickup(50*32 +j*32,6*32 + i*32,false,true, false,false));

            }
        }

        Pickup_list.add(new Pickup(49*32, 10*32, false, false,false,true)); //spawning the sword

        return Pickup_list;
    }



}
