import java.util.Scanner;
/**
 * PageRank class.
 */
class PageRank {
	Digraph digraph;
	public PageRank(Digraph g) {
		// int vertex;
		// Digraph digraph = new Digraph(g);
		double outdegree, indegree;
		// vertex = digraph.V();
		// for (int i =0; i < vertex; i++) {
		// 	for (int j : digraph.adj(i)) {
		// 		outdegree = digraph.outdegree(j);
		// 		indegree = digraph.indegree(j);
		// 	}
		// }
		digraph = new Digraph(g);
		int vertex = digraph.V();
		int edge = digraph.E();
		double prnum = 0;
		System.out.println(vertex + " vertices, " + edge + " edges");
		for (int i = 0; i < vertex; i++) {
			System.out.println(i + ":" + digraph.adj(i));
		}
	// 	for (int i = 0; i < vertex; i++) {
	// 		// int[] branches = new int[10];
	// 		// branches = digraph.adj(i);
	// 		for (int j = 0; j < 10; i++) {
	// 			prnum += pr(j);
	// 		// System.out.println(i + ":" + digraph.adj(i));
	// 	}
	// }
		// double prnum = 0;
		// for (int j = 0; j < vertex; j++) {
		// 	int[] branches = new int[10];
		// 	branches = digraph.adj(j);
		// 	for (int i = 0; i < 10; i++) {
		// 		prnum += pr(i);
		// 	}
		// }
		// System.out.println();

	}
	public double pr(int a) {
		double outdegree, indegree;
		outdegree = digraph.outdegree(a);
		indegree = digraph.indegree(a);
		return indegree/outdegree;
	}
	// StringBuilder s = new StringBuilder();
 //        s.append(V + " vertices, " + E + " edges " + NEWLINE);
 //        for (int v = 0; v < V; v++) {
 //            s.append(String.format("%d: ", v));
 //            for (int w : adj[v]) {
 //                s.append(String.format("%d ", w));
 //            }
 //            s.append(NEWLINE);
 //        }
}

class WebSearch {

}


public class Solution {
	public static void main(final String[] args) {
		// read the first line of the input to get the number of vertices

		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph


		// Create page rank object and pass the graph object to the constructor

		// print the page rank object

		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		Digraph digraph = new Digraph(vertices);
		for (int i = 0; i < vertices; i++) {
			String[] tokens = sc.nextLine().split(" ");
			// System.out.println(tokens.length);
			int v = Integer.parseInt(tokens[0]);
			for (int j = 1; j <= tokens.length - 1; j++) {
				int w = Integer.parseInt(tokens[j]);

				digraph.addEdge(v, w);
			}

		}
		PageRank pr = new PageRank(digraph);

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}
