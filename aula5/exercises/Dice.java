// package exercises;

import java.util.Random;

public class Dice {
    private int sideUp;

    public Dice(){
        Random r = new Random();
        sideUp = (r.nextInt(6))+1;
    }
    
    public void roll(){
        Random r = new Random();
        sideUp = (r.nextInt(6))+1;
        System.out.println("Rolling...");
    }

    public int getSideUp(){
        return sideUp;
    }
}

class DiceDemo{
    public static void main(String[] args){
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        System.out.println(dice1.getSideUp());
        System.out.println(dice2.getSideUp());
        dice1.roll();
        dice2.roll();
        System.out.printf("\nDado 1: %d \nDado 2: %d \nSoma: %d \n",dice1.getSideUp(), dice2.getSideUp(),(dice1.getSideUp()+dice2.getSideUp()));
    }
}
