package com.apostit.shared.size;

/**
 * Диапазон размеров
 */
public class Len extends Size {
    private final double value;

    public Len(double value) {
        super(Double.toString(value));
        this.value = value;
    }

    @Override
    public String toString() {
        return UnitShow.toValue(value);
    }
}
