package com.apostit.shared.size;

import static com.apostit.shared.size.UnitShow.inch;

/**
 * Диапазон размеров в дюймах
 */
public class Inches extends Range {
    public Inches(double from, double to) {
        super(from * inch, to * inch);
    }
}
