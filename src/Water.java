public class Water extends Sprite{
    public Water(int coordinate) {
        super(Symbol.WATER, coordinate);
    }

    @Override
    public String toString() {
        return "Water{" +
                "symbol=" + symbol +
                ", coordinate=" + coordinate +
                '}';
    }
}
