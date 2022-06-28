public class Fire extends Sprite{
//    public Fire(int coordinate) {
//        this.coordinate=coordinate;
//        this.symbol=Symbol.FIRE;
//    }


    public Fire(int coordinate) {
        super(Symbol.FIRE,coordinate);
    }

    @Override
    public String toString() {
        return "Fire{" +
                "symbol=" + symbol +
                ", coordinate=" + coordinate +
                '}';
    }
}
