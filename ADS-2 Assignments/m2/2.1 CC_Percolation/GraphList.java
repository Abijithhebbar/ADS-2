/**.
 * Interface for graph.
 */
interface Graph {
    /**
     * vertex.
     */
    int vert();
    /**
     * edge variable.
     */
    int edge();
    /**
     * Adds an edge.
     *
     * @param v { parameter_description }
     * @param w { parameter_description }
     */
    void addEdge(int v, int w);
    /**.
     * { function_description }
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    Iterable<Integer> adj(int v);
    /**.
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
}
/**.
 * List of graphs.
 */
class GraphList implements Graph {
    /**.
     * vertex.
     */
    private int ver;
    /**.
     * edge.
     */
    private int edg;
    /**.
     * array of bag type.
     */
    private Bag<Integer>[] adj;
    /**.
     * string[].
     */
    private String[] vertexes;
    /**.
     * size.
     */
    private int size = 0;
    /**
     * Initializes an empty graph with V vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  vt number of vertices
     */
    GraphList(final int vt) {
        this.ver = vt;
        this.edg = 0;
        vertexes = new String[ver];
        size = 0;
        adj = (Bag<Integer>[]) new Bag[ver];
        for (int v = 0; v < ver; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Returns the number of vertices in this graph.
     * time complexity is 1 in average case.
     * @return the number of vertices in this graph
     */
    public int vert() {
        return ver;
    }

    /**
     * Returns the number of edges in this graph.
     * time complexity is 1 in average case
     * @return the number of edges in this graph
     */
    public int edge() {
        return edg;
    }
    /**.
     * Adds a vertex.
     * time complexity is 1
     * @param v string.
     */
    public void addVertex(final String v) {
        vertexes[size] = v;
        size++;
    }
    /**.
     * Determines if it has edge.
     * time complexity is O(N).
     * @param v v.
     * @param w w.
     * @return True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        for (int i : adj[w]) {
            if (i == w) {
                return true;
            }
        }
        return false;
    }
    /**
     * Adds the undirected edge v-w to this graph.
     * time complexity is 1 in avg case
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     */
    public void addEdge(final int v, final int w) {
        if (v == w) {
            System.out.println(ver + " vertices, " + edg + " edges");
            System.out.println("No edges");
            return;
        }
        if (!hasEdge(v, w)) {
            edg++;
        }
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * Returns the vertices adjacent to vertex.
     * time complexity is 1 in average case
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     * time complexity is O(1).
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(final int v) {
        return adj[v].size();
    }

    /**
     * Returns a string representation of this graph.
     * time complexity is O(N^2).
     * @return the number of vertices <em>V</em>, followed by
     * the number of edges <em>E</em>,
     * followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        String s = "";
        s += ver + " vertices, " + edg + " edges" + '\n';
        for (int v = 0; v < ver; v++) {
            s += vertexes[v] + ": ";
            for (int w : adj[v]) {
                s += vertexes[w] + " ";
            }
            s += '\n';
        }
        return s;
    }

}