package com.apostit.shared.size;

/**
 * Размер как строка - базовый класс
 */
public class Country extends Size {

    public Country(String size) {
        super(size);
    }

    public Country(int value) {
        super(Integer.toString(value));
    }

    public Country(double size) {
        super(Double.toString(size));
        String s = Double.toString(size);
        if (s.endsWith(".0"))
            s = s.substring(0, s.length() - 2);
        this.size = s;
    }

}
