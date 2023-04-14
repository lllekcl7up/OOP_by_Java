package OOP_by_Java.LordOfRings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import OOP_by_Java.LordOfRings.Units.BaseHero;
import OOP_by_Java.LordOfRings.Units.Crossbowman;
import OOP_by_Java.LordOfRings.Units.Monk;
import OOP_by_Java.LordOfRings.Units.Names;
import OOP_by_Java.LordOfRings.Units.Peasant;
import OOP_by_Java.LordOfRings.Units.Rogue;
import OOP_by_Java.LordOfRings.Units.Sniper;
import OOP_by_Java.LordOfRings.Units.Spearman;
import OOP_by_Java.LordOfRings.Units.Warlock;


public class Main {
    public static final int SIDE_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;
    public static ArrayList<BaseHero> allSide;

    public static void main( String[] args ) {
        init();

        Scanner iScanner = new Scanner( System.in );
        String input = "";

        // System.out.println( AnsiColors.ANSI_RED_BACKGR  + "PowerShell не хочет краситься" + AnsiColors.ANSI_RESET);

        while( true ) {
            if ( input.equals( "q" ) ) break;
            ConsoleView.view();

            // System.out.println( "\n" + AnsiColors.ANSI_RED_BACKGR  + " --- Java не умеет красить текст в PowerShell --- " + AnsiColors.ANSI_RESET + "\n");

            makeStep();
            System.out.println( "\nPress 'ENTER' to Step() or 'q' to exit program" );
            input = iScanner.nextLine();
        }

        iScanner.close();
    }


    private static void init() {
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();
        allSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        for ( int i = 0; i < SIDE_SIZE; i++ ) {
            switch ( new Random().nextInt( 4 ) ) {
                case 0: whiteSide.add( new Peasant( getName(), x, y++ ) ); break;
                case 1: whiteSide.add( new Rogue( getName(), x, y++ ) ); break;
                case 2: whiteSide.add( new Sniper( getName(), x, y++ ) ); break;
                default: whiteSide.add( new Monk( getName(), x, y++ ) ); //break;
            }
            whiteSide.get( i ).side = "whiteSide";
        }

        x = SIDE_SIZE;
        y = 1;
        for ( int i = 0; i < SIDE_SIZE; i++ ) {
            switch ( new Random().nextInt( 4 ) ) {
                case 0: darkSide.add( new Peasant( getName(), x, y++ ) ); break;
                case 1: darkSide.add( new Spearman( getName(), x, y++ ) ); break;
                case 2: darkSide.add( new Crossbowman( getName(), x, y++ ) ); break;
                default: darkSide.add( new Warlock( getName(), x, y++ ) ); //break;
            }
            darkSide.get( i ).side = "darkSide";
        }

        allSide.addAll( whiteSide );
        allSide.addAll( darkSide );
        Collections.sort( allSide );
        /* Проверка коректности обратной сортировки
        for (BaseHero hero : allSide) {
            System.out.println( hero );
        }
        */
    }


    private static void makeStep() {

        for ( BaseHero hero: allSide ) {
            if ( whiteSide.contains( hero ) ) {
                hero.doStep( darkSide );
            } else {
                hero.doStep( whiteSide );
            }
        }
    }


    private static String getName() {
        return Names.values()[ new Random().nextInt( Names.values().length ) ].toString();
    }
}
