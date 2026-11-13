package com.apostit.shared.size;

import static java.lang.Math.abs;

/**
 * Диапазон размеров
 */
public class Range extends Size {
    private final double from;
    private final double to;

    public Range(double from, double to) {
        super(from + " " + to);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        if (abs(to - from) < 1e-13)
            return UnitShow.toValue(from);

        return UnitShow.toValue(from) + "-" + UnitShow.toValue(to);
    }
}
