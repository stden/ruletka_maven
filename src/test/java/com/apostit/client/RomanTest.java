package com.apostit.client;

import org.junit.Test;

import static com.apostit.shared.RomanNumeral.toRoman;
import static org.junit.Assert.assertEquals;

public class RomanTest {
    /**
     * Конвертация чисел в римскую систему счисления
     */
    @Test
    public void testToRoman() {
        assertEquals("0", toRoman(0));
        assertEquals("I", toRoman(1));
        assertEquals("II", toRoman(2));
        assertEquals("III", toRoman(3));
        assertEquals("IV", toRoman(4));
        assertEquals("V", toRoman(5));
        assertEquals("VI", toRoman(6));
        assertEquals("VII", toRoman(7));
        assertEquals("VIII", toRoman(8));
        assertEquals("IX", toRoman(9));
        assertEquals("CMXCIX", toRoman(999));
        assertEquals("MMXIII", toRoman(2013));
    }
}
