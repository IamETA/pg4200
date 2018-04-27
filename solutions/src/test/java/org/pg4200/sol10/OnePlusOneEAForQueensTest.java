package org.pg4200.sol10;

import org.junit.Test;
import org.pg4200.les09.queens.QueensProblem;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by arcuri82 on 25-Oct-17.
 */
public class OnePlusOneEAForQueensTest {

    private void testOnePlusOneEA(int n){

        int[] positions = OnePlusOneEAForQueens.solve(n);

        int fitness = QueensProblem.evaluate(positions);

        assertEquals(0, fitness);
        assertTrue(QueensProblem.isCorrect(positions));

        System.out.println(Arrays.toString(positions));
    }

    @Test
    public void testOnePlusOneEA_8x8(){

        testOnePlusOneEA(8);
    }

    @Test
    public void testOnePlusOneEA_16x16(){

        testOnePlusOneEA(16);
    }

    @Test
    public void testOnePlusOneEA_20x20(){

        testOnePlusOneEA(20);
    }

    @Test
    public void testOnePlusOneEA_100x100(){

        testOnePlusOneEA(100);
    }


}