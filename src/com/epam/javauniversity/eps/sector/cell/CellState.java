package com.epam.javauniversity.eps.sector.cell;



public enum CellState {
    EMPTY(" - "),
    HUMAN("|X|")
    ;

    private final String text;

    CellState(final String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}