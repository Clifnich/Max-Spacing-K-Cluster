package com.puzhen.clustering;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import junit.framework.TestCase;

public class TestGraphBuilder extends TestCase {

	GraphBuilder builder = new GraphBuilder();
	
	SimpleWeightedGraph<String, DefaultWeightedEdge>
		graph = builder.build("clustering1");
	
	public TestGraphBuilder(String name) {
		super(name);
	}

	public void test0() {
		assertTrue(builder != null);
	}
	
	public void testBuild() {
		assertTrue(graph != null);
	}
	
	public void testBuild1() {
		assertEquals(6, graph.vertexSet().size());
	}	
	
	public void testEdgeWeight() {
		assertEquals(1, graph.getEdgeWeight(graph.getEdge("1", "2")), 1e-9);
	}
}
