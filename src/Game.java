import java.util.List;

public class Game {

    private final Board board;
    private final List<Player> players;
    private int currentPlayerIndex;
    private final Dice dice;

    public Game(Board board, List<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.dice = dice;
    }

    public void start() {
        while (true) {
            Player player = getCurrentPlayer();
            player.makeTurn(dice);
            checkFinalPosition(player);
            if (isGameFinished()) {
                return;
            }
            updateNextPlayer();
        }
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void updateNextPlayer() {
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % players.size();
    }

    public void checkFinalPosition(Player player) {
        if (player.getCurrentPosition().equals(board.getFinalPosition())) {
            System.out.println("Player : " + player.getName() + " wins");
            players.remove(player);
        }
    }

    public boolean isGameFinished() {
        return this.players.size() == 1;
    }
}
