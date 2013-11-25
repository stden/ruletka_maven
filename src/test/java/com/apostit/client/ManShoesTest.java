package com.apostit.client;

import com.apostit.shared.categories.ManShoes;
import org.junit.Test;

import static com.apostit.shared.categories.ManShoes.*;
import static org.junit.Assert.assertEquals;

/**
 * Мужская обувь
 * http://www.onlineconversion.com/clothing_shoes_mens.htm
 */
public class ManShoesTest {

    WolframAlpha a;

    @Test
    public void convert2() {
        double delta = 0.001;
        assertEquals(3.0, UK_US(2.5), delta);
        assertEquals(14.0, UK_US(13.5), delta);
    }

    @Test
    public void convert() {
        double delta = 0.5;
        assertEquals(34.0, UK_Europe(2.5), delta);
        assertEquals(35.0, UK_Europe(3.0), delta);
        assertEquals(36.0, UK_Europe(4.0), delta);
        assertEquals(38.5, UK_Europe(6.0), delta);
        assertEquals(39.0, UK_Europe(6.5), delta);
        assertEquals(41.0, UK_Europe(7.0), delta);
        assertEquals(42.0, UK_Europe(8.0), delta);
        assertEquals(43.0, UK_Europe(8.5), delta);
        assertEquals(43.5, UK_Europe(9.0), delta);
        assertEquals(44.0, UK_Europe(9.5), delta);
        assertEquals(44.0, UK_Europe(10.0), delta);
        assertEquals(44.5, UK_Europe(10.5), delta);
        assertEquals(45.0, UK_Europe(11.0), delta);
        assertEquals(48.5, UK_Europe(13.5), delta);
    }

    @Test
    public void UK_France_Test() {
        double delta = 0.5;
        assertEquals(37, ManShoes.UK_France(2.5), delta);
        assertEquals(44.5, ManShoes.UK_France(9.0), delta);
        assertEquals(49.0, ManShoes.UK_France(13.5), delta);
    }

    @Test
    public void US_Italy_Test() {
        double delta = 0.001;
        assertEquals(39, ManShoes.US_Italy(6.0), delta);
        assertEquals(39.5, ManShoes.US_Italy(6.5), delta);
        assertEquals(46.5, ManShoes.US_Italy(12.0), delta);
    }

    @Test
    public void table() {
        a = new WolframAlpha();

        check(22.5, 35, 4);
        check(23, 36, 4.5);
        check(23.5, 36.5, 5);
        check(24, 37, 5.5);
        check(24.5, 37.5, 6);
        check(25, 38, 6.5);
        check(25.5, 39, 7);
        check(26, 40, 7.5);
        check(26.5, 41, 8);
        check(27, 42, 8.5);
        check(27.5, 43, 10);
        check(28, 44, 11);
        check(28.5, 45, 12);
        check(29, 46, 13);

        System.out.println(a.quadratic());
    }

    private void check(double len, double russia, double UK) {
        a.Add(len, UK);
        assertEquals(russia, ManShoes.Len_Russia(len), 0.5);
        assertEquals(UK, ManShoes.Len_UK(len), 0.5);
    }

    /**
     * http://shoes.about.com/od/sizemeasurementcharts/a/mensintsize.htm
     */
    @Test
    public void US_China_table() {
        a = new WolframAlpha();
        menIntSize(5, 38, 4.5, 37.5, -1, -1, 4.5);
        menIntSize(5.5, 39, 5, 38, -1, -1, 5);
        menIntSize(6, 39.5, 5.5, 38.5, 25, 24, 5.5);
        menIntSize(6.5, 40, 6, 39, -1, 24.5, 6);
        menIntSize(7, 41, 6.5, 40, 26, 25, 6.5);
        menIntSize(7.5, -1, 7, 40.5, -1, 25.5, 7);
        menIntSize(8, 42, 7.5, 41, 27, -1, 7.5);
        menIntSize(8.5, 43, 8, 42, -1, 26, 8);
        menIntSize(9, 43.5, 8.5, 42.5, 28, 26.5, 8.5);
        menIntSize(9.5, 44, 9, 43, -1, 27, 9);
        menIntSize(10, 44.5, 9.5, 44, 29, 27.5, 9.5);
        menIntSize(10.5, 45, 10, 44.5, -1, 28, 10);
        menIntSize(11, 46, -1, 45, 30, 29, 10.5);
        menIntSize(11.5, -1, 11, 45.5, -1, 29.5, -1);
        menIntSize(12, 47, -1, 46, 31, 30, -1);
        menIntSize(13, 48.5, 12, 47.5, 32, 31, -1);

        System.out.println(a.quadratic());
    }

    private void menIntSize(double US, double China, double Australia, double Europe, int Mexico, double Japan, double UK) {
        if (China > 0)
            a.Add(US, China);
        if (China > 0)
            assertEquals(China, US_China(US), 0.5);
    }
}
