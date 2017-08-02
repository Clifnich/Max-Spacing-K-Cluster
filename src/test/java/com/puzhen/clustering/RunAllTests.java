package com.puzhen.clustering;


import junit.framework.Test;
import junit.framework.TestSuite;

public class RunAllTests {
	
	public static Test suite() {
		TestSuite suite = new TestSuite(RunAllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestCluster.class);
		suite.addTestSuite(TestGraphBuilder.class);
		suite.addTestSuite(TestMaxSpacing.class);
		suite.addTestSuite(TestMSKC.class);
		suite.addTestSuite(TestUnionFind.class);
		return suite;
	}
}
