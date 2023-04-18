package com.mygdx.game.java.Units;

import com.mygdx.game.java.Pos;

import java.util.ArrayList;


public abstract class MeleeAttackUnit extends BaseHero {
    protected int attackRange;

    public MeleeAttackUnit(int attackRange, String name, Pos pos, int strength, int maxStrength, int armor, int maxArmor, int armorBreak, int initiative) {
        super(name, pos, strength, maxStrength, armor, maxArmor, armorBreak, initiative);
        this.attackRange = attackRange;
    }

    protected boolean targetWithinAttackRange() {
        return (this.pos.distanceFrom(this.targetHero.pos) <= this.attackRange);
    }

    protected void meleeAttack() {
        if ((float) (this.strength - this.targetHero.armor) / (float) this.targetHero.strength >= 0.2){
            System.out.println(this.getInfo() + " " + this.name +
                    " attacks ♥️ of " + this.targetHero.getInfo() + this.targetHero.name);
            this.targetHero.getStrengthDamage(Math.max(this.strength - this.targetHero.armor, 0));
        }else{
            System.out.println(this.getInfo() + this.name +
                    " attacks \uD83D\uDEE1 of " + this.targetHero.getInfo() + " " + this.targetHero.name);
            this.targetHero.getArmorDamage(this.armorBreak);
        }
    }
    protected void moveTowardsTarget(ArrayList<BaseHero> allies){
        Pos dir = this.pos.directionTo(this.targetHero.pos);
        Pos primaryDestination;
        Pos secondaryDestination;
        if (Math.abs(dir.x) > Math.abs(dir.y)) {
            primaryDestination = new Pos(this.pos.x + (int) Math.signum(dir.x), this.pos.y);
            secondaryDestination = new Pos(this.pos.x, this.pos.y + (int) Math.signum(dir.y));
        } else {
            secondaryDestination = new Pos(this.pos.x + (int) Math.signum(dir.x), this.pos.y);
            primaryDestination = new Pos(this.pos.x, this.pos.y + (int) Math.signum(dir.y));
        }
        if (isVacant(primaryDestination, allies)) {
            this.pos = primaryDestination;
            System.out.println(this.getInfo()+this.name+" "+"makes a resolute step towards "
                    +this.targetHero.getInfo()+this.targetHero.name);
        }
        else if (isVacant(secondaryDestination, allies)) {
            this.pos = secondaryDestination;
            System.out.println(this.getInfo()+this.name+" makes a resolute step towards "
                    +this.targetHero.getInfo()+this.targetHero.name);
        }
        else {
            System.out.println(this.getInfo()+this.name+" is waiting anxiously for the right moment");
        }
    }

    protected boolean isVacant(Pos pos, ArrayList<BaseHero> allies){
        for (BaseHero ally :
                allies) {
            if (ally.pos.equals(pos) && !ally.state.equals("dead")) return false;
        }
        return true;
    }

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        super.turn(enemies, allies);
        if (this.state.equals("dead")) return;
        this.targetHero = this.nearestAliveEnemy(enemies);
        if (this.targetWithinAttackRange()) this.meleeAttack();
        else this.moveTowardsTarget(allies);
    }
}
