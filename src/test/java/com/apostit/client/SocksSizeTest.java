package com.apostit.client;

import com.apostit.shared.categories.SocksSize;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Размеры носков
 */
public class SocksSizeTest {
    @Test
    public void test() {
        assertEquals(9.5, SocksSize.EuropeToUK(39.0), 0.001);
        assertEquals(12.5, SocksSize.EuropeToUK(45.0), 0.001);
    }
}
