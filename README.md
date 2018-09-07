# Game Of Life
This is a Java implementation of Conway's Game of Life plus a new Infection phase.

The game works with the **[original rules](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)** until the infection phase which changes the rules to:
* Any dead cell with a single live neighbour lives on to the next generation.
* Any live cell with no horizontal or vertical live neighbours dies.

# How to run
The main function can be found in GameOfLife.java
When running the game add the following parameters:

`[width] [height] [infect-after] [max-generations] [seed]`

Parameter | Description
---|---
width | The width of the universe.
height | The height of the universe.
infect-after | The number of generations after which the infection stage will start.
max-generations | The maximum number of generations that can be created. Including all phases of the game.
seed | The initial state of the universe.

**Example:**

`3 3 5 10 "101001110"`
