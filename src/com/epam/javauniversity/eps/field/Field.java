package com.epam.javauniversity.eps.field;

public class Field {
    private final int width;
    private final int height;
    private final double fieldFactor;

    public Field(int width, int height, double fieldFactor) {
        this.width = width;
        this.height = height;
        this.fieldFactor = fieldFactor;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getFieldFactor() {
        return fieldFactor;
    }
}
