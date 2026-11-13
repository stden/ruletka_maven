package com.apostit.client;

import com.apostit.shared.categories.ChildShoes;
import org.junit.Test;

import static com.apostit.shared.categories.ChildShoes.*;
import static org.junit.Assert.assertEquals;

/**
 * Детская обувь
 */
public class ChildShoesTest {
    double delta = 0.0001;
    private WolframAlpha a;

    /**
     * http://shoes.about.com/od/sizemeasurementcharts/a/kidssizechart.htm
     */
    @Test
    public void europeToJapanTest() {
        double delta = 1.01;
        assertEquals(12.5, europeToJapan(20.0), delta);
        assertEquals(13.0, europeToJapan(21.0), delta);
        assertEquals(13.5, europeToJapan(22.0), delta);
        assertEquals(14.0, europeToJapan(23.5), delta);
        assertEquals(15.0, europeToJapan(24.5), delta);
        assertEquals(16.0, europeToJapan(25.5), delta);
        assertEquals(17.5, europeToJapan(27.5), delta);
        assertEquals(17.5, europeToJapan(27.5), delta);
        assertEquals(18.5, europeToJapan(28.5), delta);
        assertEquals(19.0, europeToJapan(30.0), delta);
        assertEquals(20.0, europeToJapan(31.0), delta);
        assertEquals(20.5, europeToJapan(31.5), delta);
        assertEquals(21, europeToJapan(32.5), delta);
        assertEquals(21.5, europeToJapan(33), delta);
        assertEquals(22.0, europeToJapan(33.5), delta);
    }

    @Test
    public void US_EuroTest() {
        assertEquals(20, US_Euro(5.0), delta);
        assertEquals(21, US_Euro(5.5), delta);
        assertEquals(24, US_Euro(8.0), delta);
        assertEquals(25, US_Euro(8.5), delta);
        assertEquals(27, US_Euro(10), delta);
        assertEquals(29, US_Euro(11.5), delta);
    }

    @Test
    public void US_UK_Test() {
        assertEquals(5.5, US_UK(6.5), delta);
        assertEquals(8.5, US_UK(9.5), delta);
        assertEquals(10.5, US_UK(11.5), delta);
        assertEquals(12, US_UK(13), delta);
        assertEquals(13, US_UK(1), delta);
        assertEquals(1, US_UK(2), delta);
    }

    @Test
    public void checkTable() {
        a = new WolframAlpha();
        check(8, 7.5, 24, 15, 19, 152);
        check(8.5, 8, 24.5, 15.5, 20, 156);
        check(9, 8.5, 25.5, 16, 21, 160);
        check(9.5, 9, 26, 16.5, 22, 164);
        check(10, 9.5, 26.5, 17, 22.5, 168);
        check(10.5, 10, 27.5, 17.3, 23, 173);
        check(11, 10.5, 28, 17.5, 24, 177);
        check(11.5, 11, 28.5, 18, 25, 181);
        check(12, 11.5, 29.5, 18.5, 26, 185);
        check(12.5, 12, 30, 19, 27, 190);
        check(13, 12.5, 30.5, 19.5, 28, 194);
        check(13.5, 13, 31.5, 20, 29, 198);
        System.out.println(a.quadratic());
    }

    /**
     * @param US    U.S.
     * @param UK    U.K.
     * @param EU    E.U.
     * @param Japan Japan (CM)
     * @param China China
     * @param mm    мм.
     */
    private void check(double US, double UK, double EU, double Japan, double China, double mm) {
        a.Add(US, mm);
        assertEquals(EU, ChildShoes.US_EU(US), 0.001);
        assertEquals(China, ChildShoes.US_China(US), 0.51);
        assertEquals(mm, ChildShoes.US_mm(US), 0.51);
    }
}
