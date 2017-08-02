package com.puzhen.clustering;

import java.io.*;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

/*
 * This class builds the graph for this project.
 */
public class GraphBuilder {

	static final Logger logger = Logger.getLogger(GraphBuilder.class);
	
	/**
	 * This method creates a weighted undirected graph from file,
	 * we assume that the file is under fortesting folder.
	 * @param filename
	 * @return
	 */
	public SimpleWeightedGraph<String, DefaultWeightedEdge>
		build(String filename) {
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			 = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		try {
			Scanner scanner = new Scanner(new FileInputStream(new File("fortesting" + File.separator + filename)));
			int n = scanner.nextInt(); scanner.nextLine();
			for (int i = 1; i <= n; i++)
				graph.addVertex(String.valueOf(i));
			while (scanner.hasNext()) {
				String[] elements = scanner.nextLine().split(" ");
				DefaultWeightedEdge e = graph.addEdge(elements[0], elements[1]);
				graph.setEdgeWeight(e, Double.valueOf(elements[2]));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			logger.error("Error when reading from file");
		}
		return graph;
	}
}
