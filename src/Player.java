public class Player {

    private final String name;
    private Cell pos;
    private final Board board;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        this.pos = board.getInitialPosition();
    }

    public void makeTurn(Dice dice) {
        int throwValue = dice.getThrowValue();
        System.out.println("Dice thrown by player : " + name + ". Value returned : " + throwValue);
        Cell nextPosition = this.board.getNextPosition(this.pos, throwValue);
        System.out.println("Player moved from position " + this.pos.getPos() + " to " + nextPosition.getPos());
        this.pos = nextPosition;
    }

    public Cell getCurrentPosition() {
        return this.pos;
    }

    public String getName() {
        return this.name;
    }
}
