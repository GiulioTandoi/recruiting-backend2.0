package it.recruiting.sviluppo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PrincipalTests {
	@BeforeClass
	public static void initClass() {
		System.out.println("initClass()");
	}

	@AfterClass
	public static void endClass() {
		System.out.println("endClass()");
	}

	@Before
	public void initMethod() {
		System.out.println("initMethod()");
	}

	@After
	public void endMethod() {
		System.out.println("end Method");
	}

	@Test
	public void test1() {
		System.out.println("Test 1");
		assertTrue(true);
		assertFalse(false);
	}

	@Test
	public void test2() {
		System.out.println("Test 2");
		assertTrue(false);
	}

	@Test
	public void test3() throws Exception {
		System.out.println("Test 3");
		throw new Exception();
	}

	@Test(timeout = 100)
	public void xyzTesting() throws InterruptedException {
		System.out.println("Test xyzTesting");
		// fallirà per timeout scaduto
		Thread.sleep(200);
		assertTrue(true);
	}

	@Test(expected = java.lang.Exception.class)
	public void nuovoTest() throws Exception {
		System.out.println("Test nuovoTest");
		assertTrue(true);
		throw new Exception();
	}

}