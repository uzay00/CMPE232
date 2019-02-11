package Lecture4;
import Lecture3.Bag;

/**
 *
 * @author uzaycetin
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In("tinyDG.txt"));
        System.out.println(G + "\n\n\n\n");
        
        
        Bag<Integer> sources = new Bag<Integer>();
        for (int i = 1; i < 3; i++) {
            sources.add(i);
        }
        DirectedDFS reachable = new DirectedDFS(G, sources);
        for (int v = 0; v < G.V(); v++) {
            if (reachable.marked(v)) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
    }
}
