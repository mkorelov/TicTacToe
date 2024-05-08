package BackEnd;

// Create new game when start game button is clicked and add game logic via methods that can be called after each move
public class Game {
    private int[] arr;
    private int turn;   // 0 : X and 1 : O

    public Game() {
        arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        turn = 0;
    }

    public String move(int pos) {
        if (arr[pos] == -1) {
            arr[pos] = turn;
            turn = (turn + 1) % 2;
            if (arr[pos] == 0) {
                return "X";
            } if (arr[pos] == 1) {
                return "O";
            }
        }
        return null;
    }

    public boolean gameOver() {
        return false;
    }
}
