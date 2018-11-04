import java.util.Scanner;
class PageRank {
	Digraph digraph;
	PageRank(Digraph g) {
		digraph = new Digraph(g);
		printver();
	}
	public void printver(){
		int vertex = digraph.V();
		int edge = digraph.E();
		System.out.println(vertex + " vertices, " + edge + " edges");
		for (int i = 0; i < vertex; i++) {
			System.out.print(i + ":");
			System.out.print(" " + digraph.adj(i));
			System.out.println();
		}
	}
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices

		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph


		// Create page rank object and pass the graph object to the constructor

		// print the page rank object

		// This part is only for the final test case

		// File path to the web content
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
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}
