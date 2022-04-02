package kushagra;

import kushagra.exception.InvalidInputException;
import kushagra.service.GameRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.ExportException;

public class SnakeAndLadderMain {

    public static void main(String[] args) {
        try {
            GameRunner gameRunner = new GameRunner();
            gameRunner.setBoard();
            gameRunner.startGame();
        }
        catch (InvalidInputException e){
            System.out.println(e.toString());
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
