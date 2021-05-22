import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Board board;
    private final List<Player> players;
    private int currentPlayerIndex;
    private final Dice dice;
    private final List<Player> wonPlayers;

    public Game(Board board, List<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.dice = dice;
        this.wonPlayers = new ArrayList<>();
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

    public void showResults() {
        System.out.println("Winning player ranks are as follows :");
        for(int i=0; i<wonPlayers.size(); i++) {
            Player player = wonPlayers.get(i);
            System.out.println("Player : " + player.getName() + ". Rank : " + (i+1));
        }
        System.out.println("Player : " + players.get(0).getName() + " lost");
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    private void updateNextPlayer() {
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % players.size();
    }

    private void checkFinalPosition(Player player) {
        if (player.getCurrentPosition().equals(board.getFinalPosition())) {
            System.out.println("Player : " + player.getName() + " wins");
            players.remove(player);
            wonPlayers.add(player);
        }
    }

    private boolean isGameFinished() {
        return this.players.size() == 1;
    }
}
