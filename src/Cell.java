import java.util.Objects;

public class Cell {

    private final int pos;

    public Cell(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return pos == cell.pos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos);
    }
}
