package com.mygdx.game.java.Units;

import com.mygdx.game.java.Pos;

import java.util.ArrayList;

public class Peasant extends BaseHero {
    public Peasant(String name, Pos pos) {
        super(name, pos, 7, 7, 5, 5, 0,4);
    }

    @Override
    public String getInfo() {
        return "Крестьянин ";
    }

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        super.turn(enemies,allies);
        if (!this.state.equals("dead")) this.state = "ready";
    }
}
