package com.puzhen.clustering;

import junit.framework.TestCase;

public class TestCluster extends TestCase {

	Cluster cluster = new Cluster();
	GraphBuilder builder = new GraphBuilder();
	
	public TestCluster(String name) {
		super(name);
	}

	public void test0() {
		assertTrue(cluster != null);
	}
	
	public void test1() {
		
		UnionFind uf = cluster.clust(builder.build("tinytinycluster"), 2);
		assertEquals(2, uf.count());
	}
	
	public void test2() {
		UnionFind uf = cluster.clust(builder.build("tinytinycluster"), 1);
		assertEquals(1, uf.count());
		assertTrue(uf.connected(1, 0));
	}
	
	public void test3() {
		UnionFind uf = cluster.clust(builder.build("fourptcluster"), 4);
		assertEquals(4, uf.count());
		assertFalse(uf.connected(1, 0));
	}
	
	
}
