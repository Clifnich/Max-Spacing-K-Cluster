package com.puzhen.clustering;

import junit.framework.TestCase;

public class TestUnionFind extends TestCase {

    public TestUnionFind(String name) {
        super(name);
    }

    public void test0() {
        UnionFind uf = new UnionFind(2);
        assertEquals(0, uf.find(0));
        assertEquals(1, uf.find(1));
    }

    public void test1() {
        UnionFind uf = new UnionFind(3);
        uf.unite(0, 1);
        int leader = uf.find(0);
        uf.unite(0, 2);
        assertEquals(leader, uf.find(2));
    }

    /**
     * Test on a slightly bigger data set
     */
    public void test2() {
        UnionFind uf = new UnionFind(5);
        uf.unite(1, 2);
        uf.unite(1, 3);
        assertEquals(2, uf.find(3));
    }

    public void testConnect() {
        UnionFind uf = new UnionFind(2);
        uf.unite(0, 1);
        assertTrue(uf.connected(0, 1));
    }

    public void testConnect1() {
        UnionFind uf = new UnionFind(3);
        uf.unite(1, 0);
        uf.unite(2, 1);
        assertTrue(uf.connected(2, 0));
    }

    public void testCount() {
        UnionFind uf = new UnionFind(2);
        assertEquals(2, uf.count());
    }

    public void testCount1() {
        UnionFind uf = new UnionFind(2);
        uf.unite(0, 1);
        assertEquals(1, uf.count());
    }
    
    public void test4() {
	//SimpleWeightedGraph<String, DefaultWeightedEdge> graph = (new GraphBuilder()).build("clustering1.txt");
	UnionFind uf = new UnionFind(350);
	int big = 208;
	uf.unite(0, big);
	assertTrue(uf.connected(0, big));
    }
}
