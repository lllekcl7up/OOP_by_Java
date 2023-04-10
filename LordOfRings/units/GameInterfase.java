package LordOfRings.units;

import java.util.ArrayList;

public interface GameInterfase {
    StringBuilder getInfo();
    void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2);
}
