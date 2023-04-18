package com.mygdx.game.java.Units;

import com.mygdx.game.java.Pos;

import java.util.ArrayList;

public abstract class RangeAttackUnit extends BaseHero {
    protected int projectiles, maxProjectiles;
    protected int accuracy;

    public RangeAttackUnit(int projectiles, int maxProjectiles, int accuracy, String name, Pos pos, int strength, int maxStrength, int armor, int maxArmor, int armorBreak, int initiative) {
        super(name, pos, strength, maxStrength, armor, maxArmor, armorBreak, initiative);
        this.projectiles = projectiles;
        this.maxProjectiles = maxProjectiles;
        this.accuracy = accuracy;
    }

    protected abstract void attackTarget();

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        super.turn(enemies, allies);
        if (this.state.equals("dead")) return;
        if (this.projectiles == 0) {
            System.out.println(this.name + " has nothing to shoot with...");
            return;
        }
        this.targetHero = this.nearestAliveEnemy(enemies);
        this.attackTarget();
        this.projectiles--;
        for (BaseHero ally :
                allies) {
            if ((ally instanceof Peasant) && (ally.state.equals("ready"))) {
                this.projectiles++;
                System.out.println(this.getInfo()+" "+this.name+" receives a projectile from "+ally.getInfo()+" "+ally.name);
                ally.state = "busy";
                break;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString()+" \uD83C\uDFF9:"+this.projectiles+"("+this.maxProjectiles+")";
    }
}
