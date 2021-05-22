import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private final int numCells;
    private final Cell[] cells;
    private List<IPiece> iPieces;

    public Board(int numCells) {
        this.numCells = numCells;
        this.cells = new Cell[numCells + 1];
        for (int i=0; i<numCells+1; i++) {
            this.cells[i] = new Cell(i);
        }
        this.iPieces = new ArrayList<>();
    }

    public void initialize(int numSnakes, int numLadders) {
        Random random = new Random();
        int i=0;
        while(i < numSnakes) {
            int head = 2 + random.nextInt(numCells - 1);
            int tail = random.nextInt(head - 1) + 1;
            boolean isSnakePresent = iPieces.stream()
                    .anyMatch(iPiece -> iPiece.getSource().equals(getPosition(head)));
            if (!isSnakePresent) {
                System.out.println("Snake added. Head : " + getPosition(head).getPos() + " Tail : " +
                        getPosition(tail).getPos());
                iPieces.add(new Snake(getPosition(head), getPosition(tail)));
                i++;
            }
        }
        i=0;
        while(i < numLadders) {
            int end = 2 + random.nextInt(numCells - 1);
            int start = random.nextInt(end - 1) + 1;
            boolean isLadderPresent = iPieces.stream()
                    .anyMatch(iPiece -> iPiece.getSource().equals(getPosition(start)));
            if (!isLadderPresent) {
                System.out.println("Ladder added. Start : " + getPosition(start).getPos() + " End : " +
                        getPosition(end).getPos());
                iPieces.add(new Ladder(getPosition(start), getPosition(end)));
                i++;
            }
        }
    }

    public void setPieces(List<IPiece> iPieces) {
        this.iPieces = iPieces;
    }

    public Cell getPosition(int position) {
        return cells[position];
    }

    public Cell getInitialPosition() {
        return cells[0];
    }

    public Cell getNextPosition(Cell currentPosition, int throwValue) {
        if (currentPosition.getPos() + throwValue > numCells) {
            return currentPosition;
        }
        final Cell cell = cells[currentPosition.getPos() + throwValue];
        return iPieces.stream()
                .filter(iPiece -> iPiece.getSource().equals(cell))
                .map(IPiece::getDestination)
                .findFirst()
                .orElse(cell);
    }

    public Cell getFinalPosition() {
        return cells[numCells];
    }
}
