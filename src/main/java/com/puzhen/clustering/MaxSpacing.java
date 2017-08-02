package com.puzhen.clustering;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class MaxSpacing {

	public int get(UnionFind uf, 
			SimpleWeightedGraph<String, DefaultWeightedEdge> graph, int size) {
		int spacing = 9999999;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (uf.connected(i, j)) continue;
				// if distance(i,j) < spacing
				int distance = (int) graph.getEdgeWeight(graph.getEdge(
						String.valueOf(i + 1), String.valueOf(j + 1)));
				if (distance < spacing) 
					spacing = distance;
			}
		}
		return spacing;
	}
}
