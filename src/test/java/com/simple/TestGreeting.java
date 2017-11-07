package com.simple;

import org.junit.Assert;
import org.junit.Test;

import com.simple.Greeting;

public class TestGreeting {

	@Test
	public void testGreeting() {

		Greeting msg = new Greeting();
		Assert.assertEquals("GOOD", msg.getStatus());
	}
	
	@Test
	public void testMain() {
		Greeting.main(new String[0]);
	}
}
