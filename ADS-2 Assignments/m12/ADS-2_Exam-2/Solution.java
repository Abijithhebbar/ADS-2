import java.util.Scanner;
import java.util.ArrayList;
/**
 Solution class.
 */
final class Solution {
	/**
	 default constructor.
	 */
private Solution() {

}
/**
 * Main method.
 * @param args String.
 */
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
			weightedgraph.addEdge(new Edge(Integer.parseInt(inp[0]),
				Integer.parseInt(inp[1]), Double.valueOf(inp[2])));
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
			String[] inp = sc.nextLine().split(" ");
			DijkstraUndirectedSP shortpath = new DijkstraUndirectedSP(
				weightedgraph, Integer.parseInt(inp[0]));
			if (shortpath.hasPathTo(Integer.parseInt(inp[1]))) {
        	System.out.println(shortpath.distTo(Integer.parseInt(inp[1])));
     			 } else {
        		System.out.println("No Path Found.");
      			}
			break;

		case "ViaPaths":
			// Handle the case of middlePaths, where three integers are given.
			// First is the source and second is the middle is the one
			// where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
		 String[] input = sc.nextLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int middle = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);
            DijkstraUndirectedSP viapath = new DijkstraUndirectedSP(
            	weightedgraph, start);
            double totalSum = 0.0;
            ArrayList<Integer> route = new ArrayList<>();
            if (viapath.hasPathTo(end)) {
                if (viapath.hasPathTo(middle)) {
                    route.add(start);
                    totalSum += viapath.distTo(middle);
                    for (Edge e : viapath.pathTo(middle)) {
                        int temp = e.either();
                        if (!route.contains(temp)) {
                            route.add(temp);
                        }
                        if (!route.contains(e.other(temp))) {
                            route.add(e.other(temp));
                        }
                    }
                    viapath = new DijkstraUndirectedSP(weightedgraph, middle);
                    if (viapath.hasPathTo(end)) {
                        totalSum += viapath.distTo(end);
                        for (Edge e : viapath.pathTo(end)) {
                            int temp = e.either();
                            if (!route.contains(temp)) {
                                route.add(temp);
                            }
                            if (!route.contains(e.other(temp))) {
                                route.add(e.other(temp));
                            }
                        }
                    }
                }
                System.out.println(totalSum);
                String out = route.toString().replaceAll(",", "");
                out = out.substring(1, out.length() - 1);
                System.out.println(out);
            } else {
                System.out.println("No Path Found.");
            }
            break;

		default:
			break;
		}

	}
}
