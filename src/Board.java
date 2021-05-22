import java.util.List;

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
