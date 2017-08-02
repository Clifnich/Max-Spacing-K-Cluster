package com.puzhen.clustering;

import java.util.*;

public class UnionFind {

	/** node ---- > leader */
    private Map<Integer, Integer> leaderMap;
    private Map<Integer, Set<Integer>>  componentMap;

    public UnionFind(int size) {
        leaderMap = new HashMap<Integer, Integer>();
        componentMap = new HashMap<Integer, Set<Integer>>();
        // at the very beginning, every vertex is its own leader
        for (int i = 0; i < size; i++) {
            leaderMap.put(i, i);
            Set<Integer> treeSet = new HashSet<Integer>();
            treeSet.add(i);
            componentMap.put(i, treeSet);
        }
    }

    /**
     * Find a node's leader
     * @param node
     * @return the index of the required leader
     */
    public int find(int node) {
        return leaderMap.get(node);
    }

    /**
     * Unite two components so that the elements of both components
     * now have the same leader.
     * @param node1
     * @param node2
     */
    public void unite(int node1, int node2) {
        int leader1 = leaderMap.get(node1);
        int leader2 = leaderMap.get(node2);
        Set<Integer> set1 = componentMap.get(leader1);
        Set<Integer> set2 = componentMap.get(leader2);

        if (leader1 == leader2) return;
        if (set1.size() > set2.size()) {
            for (Integer i : set2) {
                // change leader for every node in set2
                leaderMap.replace(i, leader1);
            }
            // delete leader2 from the component map
            set1.addAll(set2);
            componentMap.remove(leader2);
        } else {
            for (Integer i : set1)
                leaderMap.replace(i, leader2);
            componentMap.remove(leader1);
            set2.addAll(set1);
        }
    }

    /**
     * This method judges whether two nodes have the same leader
     * @param node1
     * @param node2
     * @return
     */
    public boolean connected(int node1, int node2) {
        return (leaderMap.get(node1).intValue() == leaderMap.get(node2).intValue());
    }

    public int count() {
        return componentMap.keySet().size();
    }
}
