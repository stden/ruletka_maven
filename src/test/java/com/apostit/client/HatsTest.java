package com.apostit.client;

import org.junit.Test;

import static com.apostit.shared.categories.Hats.Europe_US;
import static org.junit.Assert.assertEquals;

/**
 * Шляпы
 */
public class HatsTest {

    @Test
    public void test2() {
        assertEquals(6.0, Europe_US(54), 0.001);
        assertEquals(6.75, Europe_US(55), 0.001);
        assertEquals(6.0, Europe_US(54), 0.001);
        assertEquals(6.0, Europe_US(54), 0.001);
    }
}