package BackEnd;

public class Game {
    private int[] arr;
    private int turn;   // 0 : X and 1 : O
    private int moves;
    private int winner; // 0 : X and 1 : O and -1 : draw

    public Game() {
        arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        turn = 0;
        moves = 0;
        winner = -1;
    }

    public String move(int pos) {
        if (arr[pos] == -1) {
            moves += 1;
            arr[pos] = turn;
            turn = (turn + 1) % 2;
            if (arr[pos] == 0) {
                return "X";
            } if (arr[pos] == 1) {
                return "O";
            }
        }
        return "";  // return arr[pos], but it regenerates the position
    }

    public int getWinner() {
        return this.winner;
    }

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
