package com.apostit.client;

import com.apostit.shared.categories.Shirts;
import org.junit.Test;

import static com.apostit.shared.Converter.*;
import static org.junit.Assert.assertEquals;


/**
 * Сорочки
 */
public class ShirtsTest {
    @Test
    public void test() {
        check(37, 37, S, 14.5, 37);
        check(38, 38, S, 15, 38);
        check(39, 39, M, 15.5, 39);
        check(40, 40, M, 15.5, 40);
        check(41, 41, L, 16, 41);
        check(42, 42, L, 16.5, 42);
        check(43, 43, L, 17, 43);
        check(44, 44, XL, 17.5, 44);
        check(45, 45, XXL, 18, 45);
        check(46, 46, XXL, 18, 46);
    }

    /**
     * @param russian       Российский размер
     * @param neck          Окружность шеи (см)
     * @param international Международный размер
     * @param USA           США
     * @param europe        Европа
     */
    private void check(int russian, int neck, String international, double USA, int europe) {
        assertEquals(russian + " => " + neck, neck, Shirts.Rus_Neck(russian));
        assertEquals(russian + " => " + international, international, Shirts.Rus_International(russian));
        assertEquals(russian + " => " + USA, USA, Shirts.Rus_USA(russian), 0.001);
        assertEquals(russian + " => " + europe, europe, Shirts.Rus_Europe(russian));
    }
}
