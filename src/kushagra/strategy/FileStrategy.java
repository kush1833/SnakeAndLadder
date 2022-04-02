package kushagra.strategy;

import kushagra.constant.AppConstants;
import kushagra.model.*;

import java.io.*;

public class FileStrategy implements InputStrategy{
    private BufferedReader bufferedReader;
    private File file;
    private Board board;
    private boolean isSetSnakeList;
    private boolean isSetLadderList;
    private boolean isSetPlayerList;

    @Override
    public Board setBoard() throws IOException {
        file = new File(AppConstants.FILE_PATH);
        bufferedReader = new BufferedReader(new FileReader(file));
        board = new Board(AppConstants.BOARD_SIZE);
        isSetLadderList = false;
        isSetSnakeList = false;
        isSetPlayerList = false;

        String s;
        while((s = bufferedReader.readLine()) != null){
            if(!isSetSnakeList){
                int n = Integer.parseInt(s);
                for(int i=0;i<n;i++){
                    int start = Integer.parseInt(bufferedReader.readLine());
                    int end = Integer.parseInt(bufferedReader.readLine());
                    board.setSnakeList(new Snake(start, end));
                }
                isSetSnakeList = true;
            }
            else if(!isSetLadderList){
                int n = Integer.parseInt(s);
                for(int i=0;i<n;i++){
                    int start = Integer.parseInt(bufferedReader.readLine());
                    int end = Integer.parseInt(bufferedReader.readLine());
                    board.setLadderList(new Ladder(start, end));
                }
                isSetLadderList = true;
            }
            else if(!isSetPlayerList){
                int n = Integer.parseInt(s);
                for(int i=0;i<n;i++){
                    String name = bufferedReader.readLine();
                    board.setPlayerList(new Player(name, i));
                }
                isSetPlayerList = true;
            }
            else{
                int first = Integer.parseInt(s);
                int last = Integer.parseInt(bufferedReader.readLine());
                board.setDice(new Dice(first, last));
            }
        }
        System.out.println("File input done");
        return board;
    }
}
