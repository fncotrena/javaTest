package com.prueba.javatest.util;


import com.prueba.javatest.util.player.Dice;
import com.prueba.javatest.util.player.Player;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void  loses_when_dice_number_is_too_low(){
        Dice dice= Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        Player player =new Player(dice,3);
        Assert.assertFalse(player.play());
    }

    @Test
    public void  loses_when_dice_number_is_big(){
        Dice dice= Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);

        Player player =new Player(dice,3);
        Assert.assertTrue(player.play());
    }

}