package kushagra.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int end;
    private final Map<Integer, Snake> snakeList;
    private final Map<Integer, Ladder> ladderList;
    private final Map<Integer, Player> playerList;
    private Dice dice;

    public Board(int end){
        this.end = end;
        this.snakeList = new HashMap<>();
        this.ladderList = new HashMap<>();
        this.playerList = new HashMap<>();
    }
    public int getEnd() {
        return end;
    }

    public Snake getEndPostionOfSnake(int position) {
        if(snakeList.containsKey(position)){
            return snakeList.get(position);
        }
        return null;
    }

    public Ladder getEndPostionOfLadder(int position) {
        if (ladderList.containsKey(position)){
            return ladderList.get(position);
        }
        return null;
    }

    public void updatePlayerPosition(int playerId, int position){
        this.playerList.get(playerId).setPosition(position);
    }
    public Player getPlayer(int playerID){
        return this.playerList.get(playerID);
    }
    public void setSnakeList(Snake snake){
        this.snakeList.put(snake.getStart(), snake);
    }
    public void setLadderList(Ladder ladder){
        this.ladderList.put(ladder.getStart(), ladder);
    }
    public void setPlayerList(Player player){
        this.playerList.put(player.getPlayerId(), player);
    }
    public void setDice(Dice dice){
        this.dice = dice;
    }
    public Dice getDice(){
        return this.dice;
    }
    public int getDiceValue(){
        return this.dice.getFirst() + (int)(Math.random()*(this.dice.getLast() - this.dice.getFirst() + 1));
    }
    public int getTotalPlayers(){
        return this.playerList.size();
    }
}
