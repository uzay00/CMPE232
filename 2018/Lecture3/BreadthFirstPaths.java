/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture3;

public class BreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked; // Is a shortest path to this vertex known?
    private int[] edgeTo; // last vertex on known path to this vertex
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path
    private final int s; // source

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        
        distTo[s] = 0;
        marked[s] = true; // Mark the source as visited
        queue.enqueue(s); // and put it on the queue.
        while (!queue.isEmpty()) {
            int v = queue.dequeue(); // Remove next vertex from the queue.
            for (int w : G.adj(v)) {
                if (!marked[w]) // For every unmarked adjacent vertex,
                {
                    edgeTo[w] = v; // save last edge on a shortest path,
                    distTo[w] = distTo[v] + 1; // distance increases by 1 from parent to child
                    marked[w] = true; // mark it because path is known,
                    queue.enqueue(w); // and add it to the queue.
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public int distTo(int v) {
        return distTo[v];
    }
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        // parent of a node v: 
        //        from which vertex you get to v on the pathway from s to v
        
        // get parent of v, get parent of parent of v etc.. 
        // until you get source s
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
    

    
    public static void main(String[] args) {
        In in = new In("tinyCG.txt");
        Graph G = new Graph(in);

        int s = 0;
        BreadthFirstPaths search = new BreadthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            System.out.print("Path from vertex "+s + " to " + v + ": ");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print("->" + x);
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\n\n");
        for (int v = 0; v < G.V(); v++) {
            System.out.println("Vertex "+ v + " is at distance "+ search.distTo(v) + " from source vertex "+ s);
        }
    }
}
