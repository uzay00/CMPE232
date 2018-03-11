
public interface IGraph {

	public void addEdge(int v, int w); // add an edge v-w

	public Bag<Integer> adj(int v); // vertices adjacent to v

	public int V(); // number of vertices

	public int E(); // number of edges

	public int degree(Graph G, int v); // degree of vertex v in graph G

	public int maxDegree(Graph G); // maximum degree in graph G

	public int avgDegree(Graph G); // average degree in graph G

	public int numberOfSelfLoops(Graph G); // number of self loops in graph G

	public String toString();

}
