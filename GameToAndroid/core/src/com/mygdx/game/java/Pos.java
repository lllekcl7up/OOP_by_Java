package com.mygdx.game.java;

public class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Pos pos) {
        //return Math.sqrt(Math.pow(this.x - pos.x, 2) + Math.pow(this.y - pos.y, 2));
        //return Math.max(Math.abs(pos.x - this.x), Math.abs(pos.y - this.y));
        return Math.abs(pos.x - this.x)+Math.abs(pos.y - this.y);
    }

    public Pos directionTo(Pos destination) {
        return new Pos(destination.x - this.x, destination.y - this.y);
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean equals(Pos pos) {
        return this.x == pos.x && this.y == pos.y;
    }
}
