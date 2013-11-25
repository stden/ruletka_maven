package com.apostit.shared.size;

/**
 * Алглийский размер
 */
public class EngSize extends Country {

    public EngSize(double size) {
        super(Double.toString(size));
        String s = Double.toString(size);
        if (s.endsWith(".0"))
            s = s.substring(0, s.length() - 2);
        if (s.endsWith(".5"))
            s = s.replaceFirst("\\.5", " ½");
        this.size = s;
    }

    @Override
    public String toString() {
        return size;
    }
}
