import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Board board = new Board(100);
        List<IPiece> iPieces = new ArrayList<>();

        int noOfSnakes = scanner.nextInt();
        for (int i = 0; i < noOfSnakes; i++) {
            iPieces.add(new Snake(board.getPosition(scanner.nextInt()), board.getPosition(scanner.nextInt())));
        }
        int noOfLadders = scanner.nextInt();
        for (int i = 0; i < noOfLadders; i++) {
            iPieces.add(new Ladder(board.getPosition(scanner.nextInt()), board.getPosition(scanner.nextInt())));
        }

        board.setPieces(iPieces);

        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(scanner.next(), board));
        }

        Dice dice = new Dice(1, 6);
        System.out.println("Game started");
        Game game = new Game(board, players, dice);
        game.start();
        game.showResults();
        System.out.println("Game finished");
    }
}
