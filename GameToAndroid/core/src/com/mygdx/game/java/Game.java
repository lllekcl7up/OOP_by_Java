package com.mygdx.game.java;

import com.mygdx.game.java.Units.*;

import java.util.*;

public class Game {
     public ArrayList<BaseHero> team1;
     public ArrayList<BaseHero> team2;
     public PriorityQueue<BaseHero> bothTeamsInTurnOrder;
     public int turnCount;
     public int teamSize;


    public void setTeams(int teamSize){
        this.teamSize = teamSize;
        this.team1 = new ArrayList<>();
        this.team2 = new ArrayList<>();

        Random r = new Random();
        for (int i = 1; i <= this.teamSize; i++) {
            switch (r.nextInt(7)) {
                case 0:
                    this.team1.add(new CrossBowman(getNameM(),new Pos(1,i)));
                    break;
                case 1:
                    this.team1.add(new Mage(getNameM(), new Pos(1,i)));
                    break;
                case 2:
                    this.team1.add(new Monk(getNameM(), new Pos(1,i)));
                    break;
                case 3:
                    this.team1.add(new Peasant(getNameM(), new Pos(1,i)));
                    break;
                case 4:
                    this.team1.add(new Raider(getNameM(), new Pos(1,i)));
                    break;
                case 5:
                    this.team1.add(new Sniper(getNameM(), new Pos(1,i)));
                    break;
                default: this.team1.add(new SpearMan(getNameM(),new Pos(1,i)));
            }
            switch (r.nextInt(7)) {
                case 0:
                    this.team2.add(new CrossBowman(getNameF(), new Pos(this.teamSize,i)));
                    break;
                case 1:
                    this.team2.add(new Mage(getNameF(),new Pos(this.teamSize,i)));
                    break;
                case 2:
                    this.team2.add(new Monk(getNameF(), new Pos(this.teamSize,i)));
                    break;
                case 3:
                    this.team2.add(new Peasant(getNameF(), new Pos(this.teamSize,i)));
                    break;
                case 4:
                    this.team2.add(new Raider(getNameF(), new Pos(this.teamSize,i)));
                    break;
                case 5:
                    this.team2.add(new Sniper(getNameF(), new Pos(this.teamSize,i)));
                    break;
                default:
                    this.team2.add(new SpearMan(getNameF(), new Pos(this.teamSize,i)));
            }
        }
    }
    public void setTurnOrder(){
        this.bothTeamsInTurnOrder = new PriorityQueue<>(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero h1, BaseHero h2) {
                if (h1.initiative==h2.initiative) {
                    if (h2.getStrPerc()>h1.getStrPerc()) return 1;
                    else return -1;
                }
            return h2.initiative-h1.initiative;
            }
        });
        this.bothTeamsInTurnOrder.addAll(this.team1);
        this.bothTeamsInTurnOrder.addAll(this.team2);
    }
    public void gameTurn(){
         while (!this.bothTeamsInTurnOrder.isEmpty()){
             if (this.team1.contains(this.bothTeamsInTurnOrder.peek()))
                 this.bothTeamsInTurnOrder.poll().turn(this.team2, this.team1);
             else this.bothTeamsInTurnOrder.poll().turn(this.team1, this.team2);
         }
    }

    public boolean teamOneDead(){
        for (BaseHero hero:
             this.team1) {
            if (!hero.state.equals("dead")) return false;
        }
        return true;
    }
    public boolean teamTwoDead(){
        for (BaseHero hero:
                this.team2) {
            if (!hero.state.equals("dead")) return false;
        }
        return true;
    }

//    public void play(){
//        System.out.println("ДА НАЧНЕТСЯ БИТВА!");
//         this.setTeams();
//         this.showTeams();
//         this.turnCount = 1;
//         do {
//             System.out.printf("Ход номер %d \n", this.turnCount);
//             System.out.println("-".repeat(20));
//             this.setTurnOrder();
//             this.gameTurn();
//             this.showTeams();
//             this.turnCount++;
//             System.out.println("Введите любую строку для следующего хода или 'stop' для завершения");
//         } while (!myScanner.nextLine().equals("stop"));
//    }

    private String getNameM(){
        return NamesM.values()[new Random().nextInt(NamesM.values().length)].toString();
    }
    private String getNameF(){
        return NamesF.values()[new Random().nextInt(NamesF.values().length)].toString();
    }
}
