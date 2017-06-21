package com.epam.javauniversity.eps.input;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputTest {
    InputData input;

    @Before
    public void initialization() {
        input = new InputData(10, 7, 0.9);
    }

    @Test
    public void testGetWidth() throws Exception {
        Assert.assertEquals(10, input.getWidth());
    }

    @Test
    public void testGetHeight() throws Exception {
        Assert.assertEquals(7, input.getHeight());
    }

    @Test
    public void testGetFieldFactor() throws Exception {
        Assert.assertEquals(0.9, input.getFieldFactor());
    }
}