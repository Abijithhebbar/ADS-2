import java.util.Scanner;
class GraphList {
    private int vertices;
    private int edges;
    private Bag<Integer>[] adj;
    private String[] tokens;
    GraphList() {
    }
    GraphList(Scanner scan) {
        this.vertices = Integer.parseInt(scan.nextLine());
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
        int edges = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        for (int i = 0; i < edges; i++) {
            String[] inputs = scan.nextLine().split(" ");
            addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }
    }
    public int vertices() {
        return vertices;
    }
    public int edges() {
        return edges;
    }
    public void addEdge(int vertexOne, int vertexTwo) {
        if (vertexOne != vertexTwo) {
            adj[vertexOne].add(vertexTwo);
            adj[vertexTwo].add(vertexOne);
            edges++;
        } else {
            return;
        }
    }
    public Iterable<Integer> adj(int vertex) {
        return adj[vertex];
    }
    // public boolean hasEdge(int vertexOne, int vertexTwo) {

    // }
    public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(vertices + " vertices, " + edges + " edges" + "\n");
        if (edges > 0) {
            for (int i = 0; i < vertices; i++) {
                s.append(tokens[i] + ": ");
                for (int j : adj[i]) {
                    s.append(tokens[j] + " ");
                }
                s.append("\n");
            }
            return s.toString();
        } else {
            s.append("No edges");
            return s.toString();
        }
    }
}