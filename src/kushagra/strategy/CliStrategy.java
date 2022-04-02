package kushagra.strategy;

import kushagra.constant.AppConstants;
import kushagra.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CliStrategy implements InputStrategy {
    private Board board;
    private BufferedReader bufferedReader;

    @Override
    public Board setBoard() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        board = new Board(AppConstants.BOARD_SIZE);
        this.setSnakeList();
        this.setLadderList();
        this.setPlayerList();
        this.setDice();
        return board;
    }

    private void setSnakeList() throws IOException {
        System.out.println("No. of Snakes and start-end pairs");
        int snakes = Integer.parseInt(bufferedReader.readLine());
        while (snakes-- > 0) {
            int start = Integer.parseInt(bufferedReader.readLine());
            int end = Integer.parseInt(bufferedReader.readLine());
            board.setSnakeList(new Snake(start, end));
        }
    }

    private void setLadderList() throws IOException {
        System.out.println("No. of Ladders and start-end pairs");
        int ladders = Integer.parseInt(bufferedReader.readLine());
        while (ladders-- > 0) {
            int start = Integer.parseInt(bufferedReader.readLine());
            int end = Integer.parseInt(bufferedReader.readLine());
            board.setLadderList(new Ladder(start, end));
        }
    }

    private void setPlayerList() throws IOException {
        System.out.println("Enter no of players and Names");
        int players = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < players; i++) {
            String name = bufferedReader.readLine();
            board.setPlayerList(new Player(name, i));
        }
    }

    private void setDice() throws IOException {
        System.out.println("Enter dice values");
        int first = Integer.parseInt(bufferedReader.readLine());
        int last = Integer.parseInt(bufferedReader.readLine());
        board.setDice(new Dice(first, last));

    }
}
