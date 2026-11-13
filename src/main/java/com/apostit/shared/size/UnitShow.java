package com.apostit.shared.size;

import static java.lang.Math.round;

/**
 * Показывать в единицах измерения
 */
public class UnitShow {
    public static final String SUFFIX = ".0";
    static final double inch = 2.54; // Дюйм в сантиметрах
    public static Units units = Units.CM;

    public static String toValue(double d) {
        String s = "" + round(d * 10.0) / 10.0;
        if (units == Units.INCH)
            s = "" + round(d / inch * 10.0) / 10.0;
        if (s.endsWith(SUFFIX))
            s = s.substring(0, s.length() - SUFFIX.length());
        return s;
    }
}
