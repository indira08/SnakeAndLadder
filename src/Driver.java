import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input size of board : ");
        Board board = new Board(scanner.nextInt());

        System.out.println("Do you want to initialize board automatically ? : ");
        if (scanner.nextBoolean()) {
            System.out.println("Input number of snakes : ");
            int noOfSnakes = scanner.nextInt();
            System.out.println("Input number of Ladders : ");
            int noOfLadders = scanner.nextInt();
            board.initialize(noOfSnakes, noOfLadders);
        } else {
            List<IPiece> iPieces = new ArrayList<>();
            System.out.println("Input number of snakes : ");
            int noOfSnakes = scanner.nextInt();
            if (noOfSnakes > 0) {
                System.out.println("Input Snakes Data : ");
            }
            for (int i = 0; i < noOfSnakes; i++) {
                iPieces.add(new Snake(board.getPosition(scanner.nextInt()), board.getPosition(scanner.nextInt())));
            }
            System.out.println("Input number of Ladders : ");
            int noOfLadders = scanner.nextInt();
            if (noOfLadders > 0) {
                System.out.println("Input Ladders Data : ");
            }
            for (int i = 0; i < noOfLadders; i++) {
                iPieces.add(new Ladder(board.getPosition(scanner.nextInt()), board.getPosition(scanner.nextInt())));
            }
            board.setPieces(iPieces);
        }

        System.out.println("Input number of players : ");
        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        System.out.println("Input Players Data : ");
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
