package gameoflife;
import java.util.Arrays;

/**
 *
 * @author Yaniv Levin
 */
public class Universe {
    private Cell[][] cells;
    private boolean infected = false;
    private int width, height;
    
    /**
     * Initializes the universe
     * 
     * @param height    The height of the universe
     * @param width     The width of the universe
     * @param seed      The initial state of the universe
     */
    public Universe(int height, int width, String seed) {
        char[] seedArray = seed.toCharArray();
        cells = new Cell[height][width];
        this.width = width;
        this.height = height;
        
        for(int i=0; i<height; i++) { //Create all the cells in the universe from the seed
            for(int j=0; j<width; j++) {
                cells[i][j] = new Cell(Character.getNumericValue(seedArray[(i*width)+j]));
            }
        }
    }
    
    
    @Override
    public String toString() {
        String result = "";
        
        for(Cell[] cellArray : cells) { //Create the cells string
            for(Cell cell : cellArray) {
                result += cell + " ";
            }
        }
        result = result.substring(0, result.length()-1) + "\n"; //Add new line character
        return result;
    }
    
    /**
     *  Changes the state of the universe to infected
     */
    public void infect() {
        infected = true;
    }
    
    /**
     *  Counts the number of live neighbours
     * 
     * @param y The row of the cell in the cells array
     * @param x The column of the cell in the cells array
     * @return The number of live neighbours 
     */
    private int numOfLiveNeighbours(int y, int x) {
        int count=0;
        int yStart = ((y-1<0)?y:y-1), yEnd = ((y+1>=height)?y:y+1);
        int xStart = ((x-1<0)?x:x-1), xEnd = ((x+1>=width)?x:x+1);

        for(int i = yStart; i <= yEnd; i++) {
            for(int j = xStart; j <= xEnd; j++) {
                if(i != y || j != x) //Don't include the cell itself in the counting
                    count += cells[i][j].isAlive();
            }
        }
        return count;
    }
   
     /**
     *  Counts the number of horizontal or vertical live neighbours 
     * 
     * @param y The row of the cell in the cells array
     * @param x The column of the cell in the cells array
     * @return The number of horizontal or vertical live neighbours 
     */
    private int numOfAdjacentNeighbours(int y, int x) {
        return ((y-1<0?0:cells[y-1][x].isAlive()) +
                (x-1<0?0:cells[y][x-1].isAlive()) +
                (y+1>=height?0:cells[y+1][x].isAlive()) +
                (x+1>=width?0:cells[y][x+1].isAlive()));
    }
    
    /**
     *  Checks if a specific cell should be dead or alive in the next generation
     * 
     * @param i The row of the cell in the cells array
     * @param j The column of the cell in the cells array
     * @return 0 if the cell should be dead or 1 if it should be alive
     */
    private int checkCell(int i, int j) {
        int adjacent, neighbours = numOfLiveNeighbours(i, j);
        
        if(infected) {
            adjacent = numOfAdjacentNeighbours(i, j);
            if(cells[i][j].isAlive() == 1) {
                if(adjacent == 0)
                    return 0; //die
            } else {
                if(neighbours == 1)
                    return 1; //revive
            }
        } else { //Not infected
            if(cells[i][j].isAlive() == 1) {
                if(neighbours < 2 || neighbours > 3) //Under population or over population
                    return 0; //die
            } else {
                if(neighbours == 3) //Reproduction
                    return 1; //revive
            }
        }
        return cells[i][j].isAlive(); //State did not change
    }
    
    /**
     *  Creates the next generation from the current cells in the universe
     */
    public void createNextGen() {
        Cell[][] newGen = new Cell[height][width]; //Array for the new generation
        
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                newGen[i][j] = new Cell(checkCell(i, j));
            }    
        }
        cells = newGen;
    }
    
}
