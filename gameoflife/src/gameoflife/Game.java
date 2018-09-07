package gameoflife;

/**
 *
 * @author Yaniv Levin
 */
public class Game {
    private int infectAfter;
    private int maxGenerations;
    private Universe universe;
    
    /**
     *  Initializes the game
     * 
     * @param width             The width of the game's universe
     * @param height            The height of the game's universe
     * @param infectAfter       The number of generations after which the infection stage will start
     * @param maxGenerations    The maximum number of generations that can be created including all phases of the game
     * @param seed              The initial state of the universe
     * @throws IllegalArgumentException If one of the arguments is illegal
     */
    public Game(int width, int height, int infectAfter, int maxGenerations, String seed) throws IllegalArgumentException {
        this.infectAfter = infectAfter;
        this.maxGenerations = maxGenerations;
        
        if(width < 1 || height < 1 || infectAfter < 0 || maxGenerations < 0) //Checking for valid numbers
            throw new IllegalArgumentException("Illegal argument, please try again.");
        if(seed.length() != width*height || !seed.matches("[10]*"))  //Checking for valid seed length and content
            throw new IllegalArgumentException("Illegal seed argument, please try again.");
        universe = new Universe(height,width, seed);  //Create the universe
    }
    
    @Override
    public String toString() {
        return universe.toString();
    }
    
    /**
     *  Starts the game!
     */
    public void startGame() {
        
        System.out.print(universe); //Print the initial state of the universe
        for(int gen=1; gen<=maxGenerations; gen++) { //Generations loop
            if(gen == infectAfter+1)
                universe.infect();
            universe.createNextGen();
            System.out.print(universe); //Print the new generation   
        }  
    }
    
}