import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int vertex = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph weightedgraph = new EdgeWeightedGraph(vertex);
		for (int i = 0; i < edges; i++) {
			String[] inp = sc.nextLine().split(" ");
			weightedgraph.addEdge(new Edge(Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Double.valueOf(inp[2])));
		}

		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			System.out.println(weightedgraph);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}