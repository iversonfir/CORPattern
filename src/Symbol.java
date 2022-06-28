public enum Symbol {
    HERO('H'),FIRE('F'),WATER('W');
    private final char representation;

    Symbol(char representation) {
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }
}
