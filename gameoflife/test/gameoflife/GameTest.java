package gameoflife;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/**
 *
 * @author Yaniv Levin
 */
public class GameTest {

    /**
     * Testing of a game with random arguments
     */
    @Test
    public void testRandomGame() {
        Game gol;
        Random rand = new Random();
        int width = rand.nextInt(8) + 3;
        int height = rand.nextInt(8) + 3;
        int infectAfter = rand.nextInt(10) + 1;
        int maxGenerations = rand.nextInt(5) + infectAfter;
        String seed = new String();
        
        for(int i=0; i < width*height; i++)
            seed = seed.concat(Integer.toString(rand.nextBoolean()?1:0)); //Create a random seed
        
        try {
            gol = new Game(width, height, infectAfter, maxGenerations, seed);
        } catch (IllegalArgumentException e) {
           fail("Illegal argument");
           return;
        }
       
       gol.startGame(); 
    }

 
}