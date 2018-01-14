package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AddOrderTest {
    private Order order;


    @Before
    public void setup() {
        order = new Order();

    }


    // Version 1: use a single test method for each test case

    @Test
    public void addOrderTest_sizeMin() {
        order.addOrder(1, 0);
    }

    @Test
    public void addOrderTest_sizeMax() {
        order.addOrder(10, 10000);
    }

    @Test
    public void addOrderTest_quantityTooSmall() {
        try {
            order.addOrder(0, 10000);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("Wrong quantity: 0", ex.getMessage());
        }
    }

    @Test
    public void addOrderTest_quantityTooBig() {
        try {
            order.addOrder(11, 10000);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("Wrong quantity: 11", ex.getMessage());
        }
    }

    @Test
    public void addOrderTest_articleNrTooSmall() {
        try {
            order.addOrder(1, -1);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("Wrong articleNr: -1", ex.getMessage());
        }
    }

    @Test
    public void addOrderTest_articleNrTooBig() {
        try {
            order.addOrder(1, 10001);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("Wrong articleNr: 10001", ex.getMessage());
        }
    }


    // Version 2: use a map of test cases

    @Test
    public void addOrderQuantityTest_withMap() {

        Map<Integer, IllegalArgumentException> testCasesQuantity = new HashMap<Integer, IllegalArgumentException>();

        testCasesQuantity.put(1, null);
        testCasesQuantity.put(10, null);
        testCasesQuantity.put(0, new IllegalArgumentException("Wrong quantity: 0"));
        testCasesQuantity.put(11, new IllegalArgumentException("Wrong quantity: 11"));

        runtestQuantity(testCasesQuantity);

    }

    @Test
    public void addOrderArticleNrTest_withMap() {

        Map<Integer, IllegalArgumentException> testCasesArticleNr = new HashMap<Integer, IllegalArgumentException>();

        testCasesArticleNr.put(0, null);
        testCasesArticleNr.put(10000, null);
        testCasesArticleNr.put(-1, new IllegalArgumentException("Wrong articleNr: -1"));
        testCasesArticleNr.put(10001, new IllegalArgumentException("Wrong articleNr: 10001"));

        runtestArticleNr(testCasesArticleNr);
        
    }

    public void runtestQuantity(Map<Integer, IllegalArgumentException> testCases) {
        for (Integer i : testCases.keySet()) {
            try {
                order.addOrder(i, 100);
                if (testCases.get(i) != null) {
                    Assert.fail();
                }
            } catch (IllegalArgumentException ex) {
                Assert.assertEquals(testCases.get(i).getMessage(), ex.getMessage());
            }
        }
    }

    public void runtestArticleNr(Map<Integer, IllegalArgumentException> testCases) {
        for (Integer i : testCases.keySet()) {
            try {
                order.addOrder(5, i);
                if (testCases.get(i) != null) {
                    Assert.fail();
                }
            } catch (IllegalArgumentException ex) {
                Assert.assertEquals(testCases.get(i).getMessage(), ex.getMessage());
            }
        }
    }

}
