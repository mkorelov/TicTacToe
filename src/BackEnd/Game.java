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
    private int[] board;
    private int turn;       // 0 = X, 1 = O
    private int moves;
    private int winner;     // 0 = X, 1 = O, -1 = draw
    private static final int GRIDSIZE = 9;
    private static final int ALTERNATETURNS = 2;

    /**
     * The default constructor which initializes the logic of the game.
     */
    public Game() {
        board = new int[GRIDSIZE];
        for (int i = 0; i < board.length; i++) {
            board[i] = -1;
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
        if (board[pos] == -1) {
            moves += 1;
            board[pos] = turn;
            turn = (turn + 1) % ALTERNATETURNS;
            if (board[pos] == 0) {
                return "X";
            } if (board[pos] == 1) {
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
        if (moves == GRIDSIZE) {
            winner = -1;
            return true;
        }

        // if player 1 (X) wins horizontally
        if (board[0] == 0 && board[1] == 0 && board[2] == 0) {
            winner = 0;
            return true;
        }
        if (board[3] == 0 && board[4] == 0 && board[5] == 0) {
            winner = 0;
            return true;
        }
        if (board[6] == 0 && board[7] == 0 && board[8] == 0) {
            winner = 0;
            return true;
        }

        // if player 2 (O) wins horizontally
        if (board[0] == 1 && board[1] == 1 && board[2] == 1) {
            winner = 1;
            return true;
        }
        if (board[3] == 1 && board[4] == 1 && board[5] == 1) {
            winner = 1;
            return true;
        }
        if (board[6] == 1 && board[7] == 1 && board[8] == 1) {
            winner = 1;
            return true;
        }

        // if player 1 (X) wins vertically
        if (board[0] == 0 && board[3] == 0 && board[6] == 0) {
            winner = 0;
            return true;
        }
        if (board[1] == 0 && board[4] == 0 && board[7] == 0) {
            winner = 0;
            return true;
        }
        if (board[2] == 0 && board[5] == 0 && board[8] == 0) {
            winner = 0;
            return true;
        }

        // if player 2 (O) wins vertically
        if (board[0] == 1 && board[3] == 1 && board[6] == 1) {
            winner = 1;
            return true;
        }
        if (board[1] == 1 && board[4] == 1 && board[7] == 1) {
            winner = 1;
            return true;
        }
        if (board[2] == 1 && board[5] == 1 && board[8] == 1) {
            winner = 1;
            return true;
        }

        // if player 1 (X) wins diagonally
        if (board[0] == 0 && board[4] == 0 && board[8] == 0) {
            winner = 0;
            return true;
        }
        if (board[2] == 0 && board[4] == 0 && board[6] == 0) {
            winner = 0;
            return true;
        }

        // if player 2 (O) wins diagonally
        if (board[0] == 1 && board[4] == 1 && board[8] == 1) {
            winner = 1;
            return true;
        }
        if (board[2] == 1 && board[4] == 1 && board[6] == 1) {
            winner = 1;
            return true;
        }

        return false;
    }
}