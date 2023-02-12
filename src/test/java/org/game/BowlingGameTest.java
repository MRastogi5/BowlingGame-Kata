package org.game;

import org.game.bowling.BowlingGame;
import org.game.bowling.Frame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {


    // (1,4)(4,5)(6,4)(5,5)(10,0)(0,1)(7,3)(6,4)(10,0)(2,8,6)

    private BowlingGame game;

    @Test
    public void testBowlingGame(){

        Frame[] frames = new Frame[10];
        frames[0] = new Frame(1, 4);
        frames[1] = new Frame(4, 5);
        frames[2] = new Frame(6, 4);
        frames[3] = new Frame(5, 5);
        frames[4] = new Frame(10, 0);
        frames[5] = new Frame(0, 1);
        frames[6] = new Frame(7, 3);
        frames[7] = new Frame(6, 4);
        frames[8] = new Frame(10, 0);
        frames[9] = new Frame(2, 8, 6);

        game = new BowlingGame(frames);
        assertEquals(133, game.play());

    }

    @Test
    public void testBowlingGameNoScore(){

        Frame[] frames = new Frame[10];
        frames[0] = new Frame(0, 0);
        frames[1] = new Frame(0, 0);
        frames[2] = new Frame(0, 0);
        frames[3] = new Frame(0, 0);
        frames[4] = new Frame(0, 0);
        frames[5] = new Frame(0, 0);
        frames[6] = new Frame(0, 0);
        frames[7] = new Frame(0, 0);
        frames[8] = new Frame(0, 0);
        frames[9] = new Frame(0, 0);

        game = new BowlingGame(frames);
        assertEquals(0, game.play());

    }

    @Test
    public void testBowlingGameAllOnes(){

        Frame[] frames = new Frame[10];
        frames[0] = new Frame(1, 1);
        frames[1] = new Frame(1, 1);
        frames[2] = new Frame(1, 1);
        frames[3] = new Frame(1, 1);
        frames[4] = new Frame(1, 1);
        frames[5] = new Frame(1, 1);
        frames[6] = new Frame(1, 1);
        frames[7] = new Frame(1, 1);
        frames[8] = new Frame(1, 1);
        frames[9] = new Frame(1, 1);

        game = new BowlingGame(frames);
        assertEquals(20, game.play());

    }

    
    public void testBowlingGameAllTens(){

        Frame[] frames = new Frame[10];
        frames[0] = new Frame(10, 0);
        frames[1] = new Frame(10, 0);
        frames[2] = new Frame(10, 0);
        frames[3] = new Frame(10, 0);
        frames[4] = new Frame(10, 0);
        frames[5] = new Frame(10, 0);
        frames[6] = new Frame(10, 0);
        frames[7] = new Frame(10, 0);
        frames[8] = new Frame(10, 0);
        frames[9] = new Frame(10, 10, 10);

        game = new BowlingGame(frames);
        assertEquals(300, game.play());

    }
}
