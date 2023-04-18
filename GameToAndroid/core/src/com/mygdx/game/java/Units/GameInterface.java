package com.mygdx.game.java.Units;

import java.util.ArrayList;

public interface GameInterface {
    void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies);
    String getInfo();
}
