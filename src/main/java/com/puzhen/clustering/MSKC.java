package com.puzhen.clustering;

import org.apache.log4j.Logger;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 * The class name stands for:
 * Maximum Spacing, K-clusters
 * @author puqian
 *
 */
public class MSKC {

	static final Logger logger = Logger.getLogger(MSKC.class);
	
	public int compute(String filename, int clusters) {
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph 
			= (new GraphBuilder()).build(filename);
		logger.info("Finish building graph, now clustering...");
		UnionFind uf = (new Cluster()).clust(graph, clusters);
		logger.info("Finish clustering, computing the max spacing..");
		return (new MaxSpacing()).get(uf, graph, graph.vertexSet().size());
	}
	
	public static void main(String[] args) {
		MSKC mskc = new MSKC();
		System.out.println("Max spacing 4-clustering is: " + mskc.compute("clustering1.txt", 4));
	}
}
