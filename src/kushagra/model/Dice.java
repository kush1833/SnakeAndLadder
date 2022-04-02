package kushagra.model;

public class Dice {
    private final int first;
    private final int last;

    public Dice(int first, int last){
        this.first = first;
        this.last = last;
    }

    public int getFirst(){
        return this.first;
    }

    public int getLast() {
        return this.last;
    }
}
