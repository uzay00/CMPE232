package Lecture2;

public class DepthFirstSearch {

    private boolean[] marked; 
    private int count;

    /*
    Goal: Find all vertices reachable/ connected to s
    Idea: Suupose you are looking for a treasure in a maze, 
          before going to next level, you want to look every place 
          in a systematic way.
    */
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /*
    Use recursion
        Mark each visited vertex (keep track of edge taken to this vertex)
        return (retreat/ go back) to previous caller vertex
    */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) { // 1,2 is the neighbor of v=0
            if (!marked[w]) {
                dfs(G, w); // w=1
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        In in = new In("tinyTree.txt");
        Graph G = new Graph(in);

        int s = 4; // start from vertex 4
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        // which vertices are reachable?
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v)) {
                System.out.print(v + " ");
            }
        }
        // if number of reachable vertices are equal to V -> connected graph
        System.out.println();
        if (search.count() != G.V()) {
            System.out.print("NOT ");
        }
        System.out.println("connected");
    }
}
