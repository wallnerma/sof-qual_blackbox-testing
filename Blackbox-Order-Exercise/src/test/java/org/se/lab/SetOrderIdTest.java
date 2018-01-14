package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SetOrderIdTest
{
	private Order order;

	@Before
	public void setup()
	{
		order = new Order();		
		
	}

	
	// Version 1: use a single test method for each test case
	@Test
	public void setOrderIdTest_0SizeMin()
	{
		order.setOrderId("00");
	}

	@Test
	public void setOrderIdTest_9SizeMin()
	{
		order.setOrderId("99");
	}

	@Test
	public void setOrderIdTest_0SizeMax()
	{
		order.setOrderId("0000000000");
	}

	@Test
	public void setOrderIdTest_9SizeMax()
	{
		order.setOrderId("9999999999");
	}

	@Test
	public void setOrderIdTest_0SizeTooSmall()
	{
		try {
			order.setOrderId("0");
			Assert.fail();
		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("Wrong order id: 0", ex.getMessage());
		}

	}

	@Test
	public void setOrderIdTest_0SizeTooBig()
	{
		try {
			order.setOrderId("00000000000");
			Assert.fail();
		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("Wrong order id: 00000000000", ex.getMessage());
		}

	}

	@Test
	public void setOrderIdTest_wrongChar()
	{
		try {
			order.setOrderId("a0");
			Assert.fail();
		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("Wrong order id: a0", ex.getMessage());
		}

	}

	@Test
	public void setOrderIdTest_wrongChar2()
	{
		try {
			order.setOrderId("0a");
			Assert.fail();
		} catch (IllegalArgumentException ex) {
			Assert.assertEquals("Wrong order id: 0a", ex.getMessage());
		}

	}
	
	// Version 2: use a map of test cases

	@Test
	public void orderIdWithMapTest() {
		Map<String, IllegalArgumentException> testCases = new HashMap<String, IllegalArgumentException>();

		testCases.put("00", null);
		testCases.put("99", null);
		testCases.put("0000000000", null);
		testCases.put("9999999999", null);

		testCases.put("0", new IllegalArgumentException("Wrong order id: 0"));
		testCases.put("9", new IllegalArgumentException("Wrong order id: 9"));
		testCases.put("00000000000", new IllegalArgumentException("Wrong order id: 00000000000"));
		testCases.put("99999999999", new IllegalArgumentException("Wrong order id: 99999999999"));
		testCases.put("0a", new IllegalArgumentException("Wrong order id: 0a"));
		testCases.put("a0", new IllegalArgumentException("Wrong order id: a0"));
		testCases.put("012a456", new IllegalArgumentException("Wrong order id: 012a456"));
		testCases.put("0/", new IllegalArgumentException("Wrong order id: 0/"));
		testCases.put("0:", new IllegalArgumentException("Wrong order id: 0:"));

		runtest(testCases);

	}

	public void runtest(Map<String, IllegalArgumentException> testCases) {
		for (String testText : testCases.keySet()) {
			try {
				order.setOrderId(testText);
				if (testCases.get(testText) != null) {
					Assert.fail();
				}
			}
			catch (IllegalArgumentException ex) {
				Assert.assertEquals(testCases.get(testText).getMessage(), ex.getMessage());
			}
		}

	}




}
