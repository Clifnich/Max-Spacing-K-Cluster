package com.puzhen.clustering;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import junit.framework.TestCase;

public class TestMaxSpacing extends TestCase {

	MaxSpacing spacing = new MaxSpacing();
	Cluster cluster = new Cluster();
	GraphBuilder builder = new GraphBuilder();
	
	public TestMaxSpacing(String name) {
		super(name);
	}

	public void test0() {
		assertTrue(spacing != null);
	}
	
	public void test1() {
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph = builder.build("tinytinycluster");
		UnionFind uf = cluster.clust(graph, 2);
		assertEquals(1, spacing.get(uf, graph, 2));
	}
	
	public void test2() {
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph = builder.build("tinytinycluster");
		UnionFind uf = cluster.clust(graph, 1);
		assertEquals(9999999, spacing.get(uf, graph, 2));
	}
}
