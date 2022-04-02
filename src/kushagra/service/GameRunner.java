package kushagra.service;

import kushagra.exception.InvalidInputException;
import kushagra.model.*;
import kushagra.strategy.CliStrategy;
import kushagra.strategy.FileStrategy;
import kushagra.strategy.InputStrategy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameRunner {
    private static final int BOARD_SIZE = 100;
    private Board board;
    private BufferedReader bufferedReader;
    private int totalPlayers;
    private InputStrategy inputStrategy;
    public void setBoard() throws IOException,InvalidInputException{
        System.out.println("----------------Snake And Ladder----------------");
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 - CLI input");
        System.out.println("2 - File Input");
        int option = Integer.parseInt(bufferedReader.readLine());
        switch (option){
            case 1:
                inputStrategy = new CliStrategy();
                this.board = inputStrategy.setBoard();
                break;
            case 2:
                inputStrategy = new FileStrategy();
                this.board = inputStrategy.setBoard();
                break;
            default:
                throw new InvalidInputException();
        }
        totalPlayers = this.board.getTotalPlayers();
    }
    public void startGame() throws InterruptedException {
        int playerId = 0;
        while (true){
            Player player = this.board.getPlayer(playerId);
            int diceValue = this.board.getDiceValue();
            int currentPosition = this.movePlayer(playerId, player, diceValue);
            if(currentPosition != -1) {
                System.out.println(player.getName() + " rolled a " + diceValue + " and moved from " + player.getPosition() + " to " + currentPosition);
                if (currentPosition == this.board.getEnd()) {
                    System.out.println(player.getName() + " wins the game");
                    break;
                }
                this.board.updatePlayerPosition(playerId, currentPosition);
            }
            Thread.sleep(1000);
            playerId = (playerId+1)%totalPlayers;
        }
    }
    private int movePlayer(int playerId, Player player, int diceValue){
        int currentPosition = player.getPosition();
        if(currentPosition + diceValue > this.board.getEnd()){
            return -1;
        }
        currentPosition = currentPosition + diceValue;
        while(this.board.getEndPostionOfSnake(currentPosition)!=null || this.board.getEndPostionOfLadder(currentPosition)!=null){
            if(this.board.getEndPostionOfSnake(currentPosition)!=null){
                currentPosition = this.board.getEndPostionOfSnake(currentPosition).getEnd();
            }
            else{
                currentPosition = this.board.getEndPostionOfLadder(currentPosition).getEnd();
            }
        }
        return currentPosition;
    }
}
