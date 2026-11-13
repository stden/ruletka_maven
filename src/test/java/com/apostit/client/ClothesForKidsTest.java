package com.apostit.client;

import com.apostit.shared.categories.ClothesForKids;
import org.junit.Test;

import static com.apostit.shared.categories.ClothesForKids.*;
import static org.junit.Assert.assertEquals;

/**
 * Тесты для одежды для малышей
 */
public class ClothesForKidsTest {
    @Test
    public void table() {
        check(45, 50, 41, 43, 41, 43, 41, 43, 50);
        check(51, 56, 43, 45, 43, 45, 43, 45, 56);
        check(57, 62, 45, 47, 45, 47, 45, 47, 62);
        check(63, 68, 47, 49, 46, 48, 47, 49, 68);
        check(69, 74, 49, 51, 47, 49, 49, 51, 74);
        check(75, 80, 51, 53, 48, 50, 51, 53, 80);
        check(81, 86, 52, 54, 49, 51, 52, 54, 86);
        check(87, 92, 53, 55, 50, 52, 53, 56, 92);
        check(93, 98, 54, 56, 51, 53, 55, 58, 98);
        check(99, 104, 55, 57, 52, 54, 57, 60, 104);
        check(105, 110, 56, 58, 53, 55, 59, 62, 110);
        check(111, 116, 57, 59, 54, 56, 61, 64, 116);
        check(117, 122, 58, 62, 55, 58, 63, 67, 122);
        check(123, 128, 61, 65, 57, 59, 66, 70, 128);
        check(129, 134, 64, 68, 58, 61, 69, 73, 134);
        check(135, 140, 67, 71, 60, 62, 72, 76, 140);
        check(141, 146, 70, 74, 61, 64, 75, 78, 146);
    }

    /**
     * @param h1    Рост, см, от
     * @param h2    Рост, см, до
     * @param bust1 Грудь, см, от
     * @param bust2 Грудь, см, до
     * @param w1    Талия, см, от
     * @param w2    Талия, см, до
     * @param hips1 Бедра, см, от
     * @param hips2 Бедра, см, до
     * @param size  Размер
     */
    private void check(int h1, int h2, int bust1, int bust2, int w1, int w2, int hips1, int hips2, int size) {
        // http://www.xuru.org/rt/PR.asp
        System.out.println(size + " " + bust1);
        assertEquals(h1, Size_h1(size));
        assertEquals(h2, Size_h2(size));
        assertEquals(bust1, Size_bust1(size), 1);
        assertEquals(bust2, Size_bust2(size), 1);
        assertEquals(w1, Size_w1(size), 1);
        assertEquals(w2, Size_w2(size));
        assertEquals(hips1, Size_hips1(size), 1);
        assertEquals(hips2, Size_hips2(size), 1);
    }

    /**
     * http://golondon.about.com/od/shopping/ig/Clothing-Size-Charts/Children-s-Clothing-Sizes.htm
     */
    @Test
    public void t1() {
        assertEquals("18 m", h1_UK(80));
        assertEquals("24 m", h1_UK(86));
        assertEquals("2-3", h1_UK(92));
        assertEquals("18-24 m", h1_US(80));
        assertEquals("23/24 m", h1_US(86));

        assertEquals("18 m", ClothesForKids.h1_Australia(80));
        assertEquals("2", ClothesForKids.h1_Australia(86));

    }

}
