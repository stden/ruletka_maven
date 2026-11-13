package com.apostit.shared;

/**
 * Римские числа
 */
public class RomanNumeral {
    // Таблица для перевода в римскую систему счисления
    static X[] table = new X[]{
            new X("M", 1000), new X("CM", 900), new X("D", 500), new X("CD", 400),
            new X("C", 100), new X("XC", 90), new X("L", 50), new X("XL", 40),
            new X("X", 10), new X("IX", 9), new X("V", 5), new X("IV", 4),
            new X("I", 1),
    };

    public static String toRoman(int input) {
        if (input < 0 || input > 3999)
            return "Invalid Roman Number Value";
        if (input == 0)
            return "0";
        StringBuilder s = new StringBuilder("");
        for (X x : table) {
            while (input >= x.arabic) {
                s.append(x.roman);
                input -= x.arabic;
            }
        }
        return s.toString();
    }

    static class X {
        public final String roman;
        public final int arabic;

        public X(String roman, int arabic) {
            this.roman = roman;
            this.arabic = arabic;
        }
    }
}
