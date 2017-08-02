package com.puzhen.clustering;

import java.util.Set;

import org.apache.log4j.Logger;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Cluster {

	final static Logger logger = Logger.getLogger(Cluster.class);
	
	/**
	 * This method clusters a graph into k components using
	 * union find data structure.
	 * @param graph
	 * @param k
	 * @return
	 */
	public UnionFind clust(SimpleWeightedGraph<String, DefaultWeightedEdge> graph, int k) {
		int size = graph.vertexSet().size();
		Set<String> vertices = graph.vertexSet();
		UnionFind uf = new UnionFind(size);
		while (uf.count() != k) {
			logger.info("Now uf count is: " + uf.count());
			int minDistance = 999999;
			int idea1 = 0, idea2 = 0;
			for (String u : vertices) {
				for (String v : vertices) {
					if (u.equals(v)) continue;
					if (uf.connected(Integer.valueOf(u) - 1, Integer.valueOf(v) - 1)) 
						continue;
					//logger.info("Comparing " + u + " and " + v);
					int distance = (int) graph.getEdgeWeight(graph.getEdge(u, v));
					if (distance < minDistance) {
						minDistance = distance;
						idea1 = Integer.valueOf(u) - 1;
						idea2 = Integer.valueOf(v) - 1;
					}
				}
			}
			if (idea1 != idea2)
				uf.unite(idea1, idea2);
		}
		return uf;
	}
}
