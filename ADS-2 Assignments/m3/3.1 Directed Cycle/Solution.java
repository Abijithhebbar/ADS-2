import java.util.Scanner;
/**.
 * Solution class.
 **/
 final class Solution {
 	/**.
 	 * Default constructor.
 	 **/
 	private Solution() {
 		//unsed.
 	}
 	/**
 	 * @param args String.
 	 */
 	public static void main(final String[] args) {
 		Scanner sc =new Scanner(System.in);

 		int vertex = Integer.parseInt(sc.nextLine());
        int edge = Integer.parseInt(sc.nextLine());
        Digraph digraph = new Digraph(vertex);
 		DirectedCycle directedcycle = new DirectedCycle(digraph);
 		for (int i = 0; i < edge; i++) {
 			String[] input = sc.nextLine().split(" ");
            digraph.addEdge(Integer.parseInt(input[0]),
                         Integer.parseInt(input[1]));
 		}
 		if(directedcycle.hasCycle()) {
 			System.out.println("Cycle exists.");
 		} else {
 			System.out.println("Cycle doesn't exists.");
 		}

 	}
 }