import java.util.Scanner;
import java.util.ArrayList;
/**.
 * { item_description }
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() { }
    /**.
     * { function_description }
     *
     * @param      args  string.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ArrayList<String> name =
            new ArrayList<String>();
        String[] tokens = sc.nextLine().split(" ");
        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
            name.add(tokens[i]);
        }
        EdgeWeightedGraph edgeweightedgraph = new EdgeWeightedGraph(
            Integer.parseInt(input[0]));
        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            String[] c = sc.nextLine().split(" ");
            int vertex1 = name.indexOf(c[0]);
            int vertex2 = name.indexOf(c[1]);
            edgeweightedgraph.addEdge(new Edge(
                             vertex1, vertex2, Double.parseDouble(
                                 c[2])));
        }
        int queries = Integer.parseInt(sc.nextLine());
        DijkstraSP dijkstra;
        for (int i = 0; i < queries; i++) {
            String[] q = sc.nextLine().split(" ");
            int source = name.indexOf(q[0]);
            int destination = name.indexOf(q[1]);
            dijkstra = new DijkstraSP(edgeweightedgraph, source);
            System.out.println((int) dijkstra.distTo(destination));
        }
    }
}
