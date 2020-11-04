package com.prueba.javatest.util.player;

import java.util.Random;

public class Dice
{
    private int side;

    public Dice(int side) {
        this.side = side;
    }

    public int roll(){
        return new Random().nextInt(side)+1;
    }
}
