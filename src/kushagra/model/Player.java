package kushagra.model;

public class Player {
    private final String name;
    private final int playerId;
    private int position;

    public Player(String name, int playerId){
        this.name = name;
        this.position = 0;
        this.playerId = playerId;
    }
    public String getName(){
        return this.name;
    }
    public int getPosition(){
        return this.position;
    }
    public void setPosition(int position){
        this.position = position;
    }
    public int getPlayerId(){
        return this.playerId;
    }
}
