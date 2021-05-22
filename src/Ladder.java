public class Ladder implements IPiece {

    private final Cell start;
    private final Cell end;

    public Ladder(Cell start, Cell end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Cell getSource() {
        return this.start;
    }

    @Override
    public Cell getDestination() {
        return this.end;
    }
}
