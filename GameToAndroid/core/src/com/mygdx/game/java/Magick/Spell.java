package com.mygdx.game.java.Magick;

public enum Spell {

    MagickArrow(3,3, "MagickArrow"),
    FireBall(5,5,"FireBall"),
    Lightning(7,7,"Lightning"),
    OmsHealing(-3,3,"OmsHealing"),
    DmsHealing(-5,5,"DmsHealing"),
    RealHealing(-7,7,"RealHealing");

    public final int spellPower;
    public final int manaCost;

    public final String name;

    Spell(int spellPower, int manaCost,String name){
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.name = name;
    }
}
