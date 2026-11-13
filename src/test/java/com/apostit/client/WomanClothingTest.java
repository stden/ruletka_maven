package com.apostit.client;

import org.junit.Test;

import static com.apostit.shared.categories.WomenClothing.*;
import static org.junit.Assert.assertEquals;

/**
 * Одежда
 */
public class WomanClothingTest {
    @Test
    public void test() {
        double[] rus = {40, 42, 44, 46, 48, 50, 52, 54, 56, 58};
        double[] eur = {34, 36, 38, 40, 42, 44, 46, 48, 50, 52};
        double[] USA = {6, 8, 10, 12, 14, 16, 18, 20, 22, 24};
        for (int i = 0; i < rus.length; i++) {
            assertEquals(eur[i], RusToEur(rus[i]), 0.001);
            assertEquals(USA[i], RusToUSA(rus[i]), 0.001);
        }
    }

    @Test
    public void test2() {
        // UK	                6	8	10	12	14	16	18	20	22
        // USA	                4	6	8	10	12	14	16	18	20
        // Russia	            40	42	44	46	48	50	52	54	56
        // Spain/France     	34	36	38	40	42	44	46	48	50
        // Italy	            38	40	42	44	46	48	50	52	54
        // Germany	            32	34	36	38	40	42	44	46	48
        // Japan	            3	5	7	9	11	13	15	17	19
        // Dominican Republic	10	12	14	16	18	20	22	24	26
        assertEquals(34.0, UK_Spain(6), 0.001);
        assertEquals(34.0, UK_France(6), 0.001);
        assertEquals(38.0, UK_Italy(6), 0.001);
        assertEquals(32.0, UK_Germany(6), 0.001);
        assertEquals(3.0, UK_Japan(6), 0.001);

        assertEquals(50.0, UK_Spain(22), 0.001);
        assertEquals(50.0, UK_France(22), 0.001);
        assertEquals(54.0, UK_Italy(22), 0.001);
        assertEquals(48.0, UK_Germany(22), 0.001);
        assertEquals(19.0, UK_Japan(22), 0.001);
    }
}
