package com.apostit.client;

import com.apostit.shared.categories.Category;
import com.apostit.shared.size.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Проверка размера
 */
public class SizeTest {
    @Test
    public void val() {
        assertEquals("<b>61</b>", Category.val("61"));
    }

    @Test
    public void size() {
        Country size = new Country("XL");
        assertEquals("XL", size.toString());

        Country size2 = new Country(23.0);
        assertEquals("23", size2.toString());

        UnitShow.units = Units.CM;
        Range range = new Range(42, 43);
        assertEquals("42-43", range.toString());

        Range range2 = new Range(23.45, 33.22);
        assertEquals("23.5-33.2", range2.toString());

        Range range3 = new Range(2.33, 2.33);
        assertEquals("2.3", range3.toString());

        Len len = new Len(50);
        assertEquals("50", len.toString());

        UnitShow.units = Units.INCH;
        assertEquals("9.2-13.1", range2.toString());
        assertEquals("19.7", len.toString());
    }

    @Test
    public void EngSize() {
        EngSize size = new EngSize(14.5);
        assertEquals("14 ½", size.toString());
        assertEquals("10", (new EngSize(10.0)).toString());
        assertEquals("0", (new EngSize(0.0)).toString());
    }
}
