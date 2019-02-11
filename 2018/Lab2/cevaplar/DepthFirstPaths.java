/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {

    private boolean[] marked; // Has dfs() been called for this vertex?
    private int[] edgeTo; // last vertex on known path to this vertex
    private final int s; // source

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }


    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                // w is parent of v
                edgeTo[w] = v; // you get to v from w for the first time
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        // parent of a node v: 
        //        from which vertex you get to v on the pathway from s to v
        
        // get parent of v, get parent of parent of v etc.. 
        // until you get source s
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        In in = new In("tinyG2.txt");
        Graph G = new Graph(in);

        int s = 0;
        DepthFirstPaths search = new DepthFirstPaths(G, s);

        System.out.println(search.pathTo(6));
        System.out.println(search.pathTo(7));
    }
}