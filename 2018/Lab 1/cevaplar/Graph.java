import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Graph implements IGraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	// create an empty graph with V vertices
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}

	// create a graph from input stream
	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	// add an edge v-w
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	// vertices adjacent to v
	public Bag<Integer> adj(int v) {
		return adj[v];
	}

	// number of vertices
	public int V() {
		return V;
	}

	// number of edges
	public int E() {
		return E;
	}

	// degree of vertex v in graph G
	public int degree(Graph G, int v) {
		int degree = 0;
		for (int w : G.adj(v)) {
			degree++;
		}
		return degree;
		
	}

	// maximum degree in graph G
	public int maxDegree(Graph G) {
		int max = 0;
		for (int v = 0; v < G.V(); v++) {
			if (degree(G, v) > max) {
				max = degree(G, v);
			}
		}
		return max;
	}

	// average degree in graph G
	public int avgDegree(Graph G) {
		return 2 * G.E() / G.V();
	}

	// number of self loops in graph G
	public int numberOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (v == w) {
					count++;
					System.out.println(v);
				}
			}
		}
		return count / 2;
	}

	public String toString() {
		String s = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (int w : this.adj[v]) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph G = new Graph(in);
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				StdOut.println(v + " - " + w);
			}
		}
		System.out.println(G);
	}
}
