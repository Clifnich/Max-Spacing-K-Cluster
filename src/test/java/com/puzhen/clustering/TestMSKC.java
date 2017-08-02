package com.puzhen.clustering;

import junit.framework.TestCase;

public class TestMSKC extends TestCase {

	MSKC mskc = new MSKC();
	
	public TestMSKC(String name) {
		super(name);
	}

	public void test0() {
		assertEquals(5, mskc.compute("clustering1", 2));
	}
	
	public void test1() {
		assertEquals(3, mskc.compute("clustering1", 4));
	}
	
	public void test2() {
		assertEquals(100, mskc.compute("clustering2", 2));
	}
	
	public void test3() {
		assertEquals(1, mskc.compute("tinytinycluster", 2));
	}
}
