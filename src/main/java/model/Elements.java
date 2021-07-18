package model;

public enum Elements {
    EMPTY(' '),
    CROSS('X'),
    NOUGHT('O');

    final char symbol;

    Elements(char symbol) {
        this.symbol = symbol;
    }

    public char getElement() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
