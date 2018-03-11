package Lecture3;

public class CC {

    private boolean[] marked;
    private int[] id; // compoenent ID array
    private int count; // current component count

    public CC(Graph G) {
        // initialize all vertices v as unmarked
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            // for each unmarked vertex v run a different DFS
            if (!marked[s]) {
                // In one DFS all reachable vertex in one compoenent will be assigned to same compoennet
                dfs(G, s);
                // When DFS finishes for one component, increase component count 
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count; // current compoenent ID is 'count'
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w]; // connected if same component ID
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        In in = new In("tinyG.txt");
        Graph G = new Graph(in);
        
        CC cc = new CC(G);
        int M = cc.count();
        System.out.println(M + " components");
        // each component is a bag
        Bag<Integer>[] components; //  components = array of bags
        components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) {
            // For every compoenent get subgraph
            components[i] = new Bag<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            // add v to the i'th component where i = v's component ID
            int i = cc.id(v); // i is the component ID
            components[i].add(v);
        }
        for (int i = 0; i < M; i++) {
            System.out.print("\t"+ i + "th component:  ");
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
