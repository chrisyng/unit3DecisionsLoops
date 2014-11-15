
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.Actor;

/**
 * The test class GameOfLifeTest.It creates an initial glider pattern and tests the initial pattern to see if the actors were generated correctly. testFinalState() tests the expected live cells of the world after one generation.
 * The test classes implement for loops to iterate through each row and column to check each cell's state. It asserts not null at expected live cells.
 *
 * @author  @Christopher Ng
 * @version 8 November 2014
 */
public class GameOfLifeTest
{
    GameOfLife game;
    final int ROWS;
    final int COLS;
    /**
     * Default constructor for test class GameOfLifeTest
     */
    public GameOfLifeTest()
    {
        this.game = new GameOfLife();
        ROWS = game.getNumRows();
        COLS = game.getNumCols();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testInitialState()
    {
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    0 1 2 3 4 5 6 7 8 9
         *  0 - - - - - - - - - - 
         *  1 - X - - - - - - - -
         *  2 - - X - - - - - - -
         *  3 X X X - - - - - - -
         *  4 - - - - - - - - - -
         *  5 - - - - - - - - - - 
         *  6 - - - - - - - - - - 
         *  7 - - - - - - - - - - 
         *  8 - - - - - - - - - - 
         *  9 - - - - - - - - - - 
         */
        game.testPopulate();

        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (row == 1 && col == 1) ||
                (row == 2 && col == 2) ||
                (row == 3 && col == 2) ||
                (row == 3 && col == 1) ||
                (row == 3 && col == 0)
                )
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
    }

    @Test
    public void testFinalState()
    {
        /* verify that the actual pattern matches the expected pattern after 3 generations         *  
         */
        game.testPopulate();
        game.createNextGeneration();
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);               

                // if the cell at the current row and col should be alive, assert that the actor is not null\

                if(

                (row == 2 && col == 0) ||
                (row == 2 && col == 2) ||
                (row == 3 && col == 1) ||
                (row == 3 && col == 2) ||
                (row == 4 && col == 1)                
                )
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);                    
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }

            }
        }
    }
}

