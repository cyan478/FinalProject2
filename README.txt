DIRECTIONS/HOW TO RUN:
1. Download the program Processing.
2. Open the folder Battleship in Processing.
3. Click the "RUN" button(looks like a play button) on the upper left corner.
4. Click the squares to make a move.

EXPLANATION:
Battleship is a 2 player game where the player plays against a computer. The goal is to find and sink the computer's ships on a 5x5 gameboard. When clicked, the blue tiles represent a missed shot(only hitting water) while the red represents a successful hit. As for the algorithm of the Battleship game, 2 matrices are used per board. One matrix is the shown matrix, revealing what spots the player has hit. The other board can be considered the answer board because it shows the solution to the board, including the location of each ship. Each time the user clicks on an opponent's square, the value of the shown board will be changed to the value of the solution board of the same indences. Then, the computer will make a random move on the user's board. For each move, the program will check how many ship tiles have been attacked. When all the ship tiles have been attacked, the program will show who won/if the game resulted in a tie.