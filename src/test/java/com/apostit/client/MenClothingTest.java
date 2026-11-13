package com.apostit.client;

import com.apostit.shared.categories.MenClothing;
import org.junit.Test;

import static com.apostit.shared.Converter.*;
import static com.apostit.shared.categories.MenClothing.*;
import static org.junit.Assert.assertEquals;

/**
 * Мужская одежда
 * Пиджаки, джемпера, жилеты, халаты, свитера, куртки, рубашки
 * http://www.kupivip.ru/sizes/men
 */
public class MenClothingTest {

    private WolframAlpha a;

    @Test
    public void test() {
        check(44, 88, 78, 95.6, 61, S, 36, 36, 38, 42);
        check(46, 92, 82, 98.6, 62, S, 38, 38, 40, 44);
        check(48, 96, 84, 101.6, 63, M, 40, 40, 42, 46);
        check(50, 100, 88, 104.6, 64, M, 42, 42, 44, 48);
        check(52, 104, 92, 107.6, 65, L, 42, 42, 46, 50);
        check(54, 108, 96, 110.6, 66, L, 44, 44, 48, 52);
        check(56, 112, 100, 113.6, 67, XL, 46, 46, 50, 54);
        check(58, 116, 104, 116.6, 68, XL, 48, 48, 52, 56);
        check(60, 120, 108, 119.6, 69, XXL, 50, 50, 54, 58);
        check(62, 124, 112, 122.6, 70, XXL, 52, 52, 56, 60);
        check(64, 128, 116, 125.6, 71, XXXL, 54, 54, 58, 62);
        check(66, 132, 120, 128.6, 72, XXXL, 56, 56, 60, 64);
        check(68, 136, 124, 131.6, 73, XXXL, 58, 58, 62, 66);
        check(70, 140, 128, 134.6, 74, XXXL, 60, 60, 64, 68);
    }

    /**
     * @param russian       Российский размер
     * @param chest         Обхват груди (см)
     * @param waist         Обхват талии (см)
     * @param hips          Обхват бедер (см)
     * @param sleeve        Длина рукава (см)
     * @param international Международный размер
     * @param england       Англия
     * @param USA           США
     * @param europe        Европа
     * @param italy         Италия
     */
    private void check(int russian, int chest, int waist, double hips, int sleeve, String international, int england, int USA, int europe, int italy) {
        assertEquals(russian + " => " + chest, chest, Rus_Chest(russian));
        assertEquals(russian + " => " + waist, waist, Rus_Waist(russian));
        assertEquals(russian + " => " + international, international, Rus_International(russian));
        assertEquals(russian + " => " + england, england, Rus_England(russian));
        assertEquals(russian + " => " + europe, europe, Rus_Europe(russian));
        assertEquals(russian + " => " + italy, italy, Rus_Italy(russian));
    }

    @Test
    public void test2() {
        assertEquals(XS, Rus_International(40));
        assertEquals(XS, Rus_International(42));
    }

    /**
     * http://ru.wikipedia.org/wiki/Размеры_одежды
     */
    @Test
    public void checkWikipedia() {
        // Таблица МУЖСКИХ размеров одежды: XS S M L XL XXL XXXL
        String man[][] = { // {XS, "44"}, - не проходит
                {S, "46"}, {M, "48"}, //{L, "50"},
                //{XL, "52"},
                //{XXL, "54"},
                // {XXXL, "58"}
        };
        for (String[] test : man) {
            String international = test[0];
            int russian = Integer.parseInt(test[1]);
            assertEquals(russian + " -> " + international, international, Rus_International(russian));
        }
    }

    @Test
    public void MensCoats_UK_Spain() {
        int[] UK = {36, 38, 40, 42, 44, 46, 48, 50};
        int[] Spain = {46, 48, 51, 54, 56, 59, 62, 64};
        for (int i = 0; i < UK.length; i++) {
            final int u = UK[i];
            final int s = Spain[i];
            assertEquals(u + " -> " + s, s, MenClothing.UK_Spain(u));
        }
    }

    @Test
    public void EuropeToJapan() {
        assertEquals(S, EU_Japan(44));
        assertEquals(M, EU_Japan(48));
        assertEquals(L, EU_Japan(50));
        assertEquals(LL, EU_Japan(54));
    }

    @Test
    public void UK_German_Test() {
        assertEquals(42, UK_German(32));
        assertEquals(50, UK_German(40));
        assertEquals(52, UK_German(42));
    }

    @Test
    public void tableCheck() {
        a = new WolframAlpha();
        check2(0, 81.3, 61, 40, 37);
        check2(2, 83.8, 63.5, 42, 38);
        check2(4, 86.4, 71.1, 44, 39);
        check2(6, 88.9, 73.7, 46, 40);
        check2(8, 91.4, 76.2, 46, 41);
        check2(10, 95.3, 74.9, 47, 42);
        check2(12, 97.8, 77.5, 48, 43);
        check2(14, 102.9, 82.6, 50, 44);
        check2(16, 105.4, 86.4, 52, 45);
        check2(18, 113, 92.7, 54, 46);
        System.out.println(a.quadratic());
    }

    /**
     * quadratic fit {{81.3, 0}, {83.8, 2}, {86.4, 4}, {88.9, 6}, {102.9, 14}, {105.4, 16}}
     * linear fit {{81.3, 0}, {83.8, 2}, {86.4, 4}, {88.9, 6}, {102.9, 14}, {105.4, 16}}
     */
    private void check2(int USA, double bust, double waist, int russian, int shoulders) {
        a.Add(russian, waist);
        assertEquals(russian + " -> " + waist, waist, MenClothing.Rus_Waist2(russian), 3);
        assertEquals(bust + " -> " + USA, USA, MenClothing.Bust_USA(bust));
        assertEquals(waist + " -> " + USA, USA, MenClothing.waist_USA(waist), 2);
    }
}