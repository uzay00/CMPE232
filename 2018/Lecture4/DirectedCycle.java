package Lecture4;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; // vertices on a cycle (if one exists)
    private boolean[] onStack; // vertices on recursive call stack

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (this.hasCycle()) { // cycle found return "not a DAG"
                return;
            } else if (!marked[w]) { // No cycle, do DFS
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) { // After v->w, if w is on stack => CYCLE FOUND
                // You come to a new vertex w, but it is on stack => CYCLE !!
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
    
    public static void main(String[] args) {
        Digraph G = new Digraph(new In("tinyDG.txt"));
        System.out.println(G + "\n\n\n\n");
        
        DirectedCycle DC = new DirectedCycle(G);
        
        for (int v : DC.cycle())
            System.out.println(v);
      
    }
}
