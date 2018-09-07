package gameoflife;

/**
 *
 * @author Yaniv Levin
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Game gol;
       int width, height, infectAfter, maxGenerations;
       if(args.length < 5) { //Checking for sufficient number of arguments
           System.out.println("Not enough parameters, please use this format: "
                   + "[width] [height] [infect-after] [​max-generations​] [seed]");
           return;
       }

       try { //Checking for valid integers
           width = Integer.parseInt(args[0]);
           height = Integer.parseInt(args[1]); 
           infectAfter = Integer.parseInt(args[2]); 
           maxGenerations = Integer.parseInt(args[3]); 
        } catch (NumberFormatException e) { 
           System.out.println("Illegal argument (not a valid number), please try again.");
           return;
        }
       
       try {
            gol = new Game(width, height, infectAfter, maxGenerations, args[4]); //Create the game
       } catch (IllegalArgumentException e) {
           System.out.println(e.getMessage());
           return;
       }
       
       gol.startGame(); //Run the game
    }
    
}
