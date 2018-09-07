package gameoflife;

/**
 *
 * @author Yaniv Levin
 */
public class Cell {
    private int status;
    
    /**
     *  Initializes a cell
     * 
     * @param status    The status of the cell: alive = 1, 0 = dead
     */
    public Cell(int status) {
        this.status = status;
    }
    
    /**
     *  Returns the status of the cell
     * 
     * @return  1 if the cell is alive, 0 if the cell is dead
     */
    public int isAlive() {
        return status;
    }
    
    @Override
    public String toString() {
        return Integer.toString(status);
    }
    
}
