package com.apostit.client;

import com.apostit.shared.size.UnitShow;
import com.apostit.shared.size.Units;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тесты конвертирования
 */
public class ConverterTest {
    @Test
    public void convertToInches() {
        UnitShow.units = Units.CM; // Вывод в сантиметрах
        assertEquals("23", UnitShow.toValue(23));
        assertEquals("23.2", UnitShow.toValue(23.2));
        UnitShow.units = Units.INCH; // Вывод в дюймах
        assertEquals("9.1", UnitShow.toValue(23));
    }
}
