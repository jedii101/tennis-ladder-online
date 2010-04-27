package com.will.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class PingServiceTest {

    @Test
    public void testPing() {
	assertTrue(new PingService().ping(5000, "http://www.google.ca"));
	assertFalse(new PingService().ping(5000, "http://www.xxgoogle.ca"));
    }

}
