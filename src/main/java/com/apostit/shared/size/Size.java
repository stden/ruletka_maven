package com.apostit.shared.size;

/**
 * Размер
 */
public class Size {
    protected String size;

    public Size(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size;
    }
}
