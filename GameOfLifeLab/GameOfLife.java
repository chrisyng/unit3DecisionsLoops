import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    private Scanner in = new Scanner(System.in);
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;

    // the game board will have 5 rows and 5 columns
    private final int ROWS = 10;
    private final int COLS = 10;
    private BoundedGrid<Actor> grid;

    // constants for the location of the three cells initially alive
    /*
    private final int X1 = 1, Y1 = 1;
    private final int X2 = 2, Y2 = 1;
    private final int X3 = 2, Y3 = 6;
    private final int X4 = 3, Y4 = 7;
    private final int X5 = 4, Y5 = 5;
    private final int X6 = 4, Y6 = 5;
    private final int X7 = 5, Y7 = 6;
    private final int X8 = 6, Y8 = 1;
    private final int X9 = 7, Y9 = 1;
    private final int X10 = 7, Y10 = 2;
     */

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized with a grid and a world
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        this.grid = new BoundedGrid<Actor>(ROWS, COLS);

        // create a world based on the grid
        this.world = new ActorWorld(grid);  
        world.show();

    }

    public void testPopulate()
    {
        final int X1 = 1, Y1 = 1;
        final int X2 = 2, Y2 = 1;
        final int X3 = 2, Y3 = 6;
        final int X4 = 3, Y4 = 7;
        final int X5 = 4, Y5 = 5;        
        final int X6 = 4, Y6 = 5;
        final int X7 = 5, Y7 = 6;
        final int X8 = 6, Y8 = 1;
        final int X9 = 7, Y9 = 1;
        final int X10 = 7, Y10 = 2;

        Rock rock1 = new Rock();
        Location loc1 = new Location(X1, Y1);
        grid.put(loc1, rock1);

        Rock rock2 = new Rock();
        Location loc2 = new Location(X2, Y2);
        grid.put(loc2, rock2);

        Rock rock3 = new Rock();
        Location loc3 = new Location(X3, Y3);
        grid.put(loc3, rock3);

        Rock rock4 = new Rock();
        Location loc4 = new Location(X4, Y4);
        grid.put(loc4, rock4);

        Rock rock5 = new Rock();
        Location loc5 = new Location(X5, Y5);
        grid.put(loc5, rock5);
    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        //Grid<Actor> grid = world.getGrid();
        /*
        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(X1, Y1);
        grid.put(loc1, rock1);

        Rock rock2 = new Rock();
        Location loc2 = new Location(X2, Y2);
        grid.put(loc2, rock2);

        Rock rock3 = new Rock();
        Location loc3 = new Location(X3, Y3);
        grid.put(loc3, rock3);

        Rock rock4 = new Rock();
        Location loc4 = new Location(X4, Y4);
        grid.put(loc4, rock4);

        Rock rock5 = new Rock();
        Location loc5 = new Location(X5, Y5);
        grid.put(loc5, rock5);
         */
        String response;
        do
        {
            Actor newActor = new Actor();
            int row;
            int column;            
            System.out.println("Enter an row number:");
            row = in.nextInt();
            System.out.println("Enter a column number:");
            column = in.nextInt();
            Location newLoc = new Location(row,column);
            grid.put(newLoc, newActor);
            world.show();
            System.out.println("Continue making actors? (y/n)");
            response = in.next();            
        }
        while(response.equals("y"));
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    private void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */

        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();

        // insert magic here...
        BoundedGrid<Actor> refreshedGrid = new BoundedGrid<Actor>(ROWS, COLS);

        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col<COLS; col++)
            { 
                Location thisCellLocation = new Location(row, col); // location of this cell
                Actor thisCell = grid.get(thisCellLocation);
                if (thisCell!=null)
                {
                    refreshedGrid.put(thisCellLocation, thisCell); // copies over the actor from previous grid to the new grid
                }
                ArrayList occupiedAdjacents = grid.getOccupiedAdjacentLocations(thisCellLocation);
                int numberOfAdjacents = occupiedAdjacents.size(); // number of live adjacent cells
                if (thisCell==null)
                {                    
                    if (numberOfAdjacents == 3)
                    {
                        Actor newActor = new Actor();
                        refreshedGrid.put(thisCellLocation, newActor); //makes a new Actor in this location                        
                    }
                }
                else // code for what to do if this cell is alive
                {
                    if (numberOfAdjacents < 2)
                    {
                        refreshedGrid.remove(thisCellLocation); // kills this cell
                    }
                    else if (numberOfAdjacents ==2 || numberOfAdjacents == 3)
                    {
                        break; // leave the dang cell alone; it's still alive
                    }
                    else // what hapens if the cell has more than three neighbors
                    {
                        refreshedGrid.remove(thisCellLocation); // kills the cell
                    }
                }
            }
        }        
        world.setGrid(refreshedGrid);
        world.show(); // refreshes the iteration

    }

    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }

    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }

    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        GameOfLife game = new GameOfLife();
        game.populateGame();
        while (1==1)
        {
            Thread.sleep(2000);
            game.createNextGeneration();        
        }
    }

}
