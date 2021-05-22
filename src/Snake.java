public class Snake implements IPiece {

    private final Cell head;
    private final Cell tail;

    public Snake(Cell head, Cell tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public Cell getSource() {
        return this.head;
    }

    @Override
    public Cell getDestination() {
        return this.tail;
    }
}
