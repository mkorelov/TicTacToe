///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               Game.java
//
// Date:               May 29, 2024
// Author:             Michael Korelov
// Email:              korelovmichael@gmail.com
//
///////////////////////////////////////////////////////////////////////////////
//
// Online sources:   UCSD CSE 110 Professor Miranda Lab 1
//
//////////////////////////// 80 columns wide //////////////////////////////////

package BackEnd;

/**
 * This class contains the game logic for Tic-Tac-Toe. The instance variables
 * are an array (arr) that keeps track of what squares on the game board are 
 * used, a flag (turn) that keeps track of what symbol's turn is next, a 
 * variable (moves) that keeps track of how many moves have been made, and a 
 * variable (winner) that indicates the result of the game.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
public class Game {
    private int[] arr;
    private int turn;       // 0 = X, 1 = O
    private int moves;
    private int winner;     // 0 = X, 1 = O, -1 = draw
    private static final int GRIDSIZE = 9;
    private static final int ALTERNATETURNS = 2;

    /**
     * The default constructor which initializes the logic of the game.
     */
    public Game() {
        arr = new int[GRIDSIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        turn = 0;
        moves = 0;
        winner = -1;
    }

    /**
     * Marks the grid with the most recent player's selection.
     *
     * @param int pos The box in the grid that was clicke on.
     * @return Returns which symbol was used. "X", "O", or "".
     */
    public String move(int pos) {
        if (arr[pos] == -1) {
            moves += 1;
            arr[pos] = turn;
            turn = (turn + 1) % ALTERNATETURNS;
            if (arr[pos] == 0) {
                return "X";
            } if (arr[pos] == 1) {
                return "O";
            }
        }
        return "";
    }

    /**
     * A getter method that determines the winner.
     *
     * @return Returns which player won the game, where 0 = X, 1 = O and 
     * -1 = draw.

     */
    public int getWinner() {
        return this.winner;
    }

    /**
     * Checks to see if their is a winner or no more moves left to make.
     *
     * @return Returns true if a player won or all 9 squares are full. Else
     * returns false.
     */
    public boolean gameOver() {
        // if all blocks are full
        if (moves == 9) {
            winner = -1;
            return true;
        }

        // if player 1 (X) wins horizontally
        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
            winner = 0;
            return true;
        }
        if (arr[3] == 0 && arr[4] == 0 && arr[5] == 0) {
            winner = 0;
            return true;
        }
        if (arr[6] == 0 && arr[7] == 0 && arr[8] == 0) {
            winner = 0;
            return true;
        }

        // if player 2 (O) wins horizontally
        if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1) {
            winner = 1;
            return true;
        }
        if (arr[3] == 1 && arr[4] == 1 && arr[5] == 1) {
            winner = 1;
            return true;
        }
        if (arr[6] == 1 && arr[7] == 1 && arr[8] == 1) {
            winner = 1;
            return true;
        }

        // if player 1 (X) wins vertically
        if (arr[0] == 0 && arr[3] == 0 && arr[6] == 0) {
            winner = 0;
            return true;
        }
        if (arr[1] == 0 && arr[4] == 0 && arr[7] == 0) {
            winner = 0;
            return true;
        }
        if (arr[2] == 0 && arr[5] == 0 && arr[8] == 0) {
            winner = 0;
            return true;
        }

        // if player 2 (O) wins vertically
        if (arr[0] == 1 && arr[3] == 1 && arr[6] == 1) {
            winner = 1;
            return true;
        }
        if (arr[1] == 1 && arr[4] == 1 && arr[7] == 1) {
            winner = 1;
            return true;
        }
        if (arr[2] == 1 && arr[5] == 1 && arr[8] == 1) {
            winner = 1;
            return true;
        }

        // if player 1 (X) wins diagonally
        if (arr[0] == 0 && arr[4] == 0 && arr[8] == 0) {
            winner = 0;
            return true;
        }
        if (arr[2] == 0 && arr[4] == 0 && arr[6] == 0) {
            winner = 0;
            return true;
        }

        // if player 2 (O) wins diagonally
        if (arr[0] == 1 && arr[4] == 1 && arr[8] == 1) {
            winner = 1;
            return true;
        }
        if (arr[2] == 1 && arr[4] == 1 && arr[6] == 1) {
            winner = 1;
            return true;
        }

        return false;
    }
}