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
 		Digraph digraph = new Digraph(sc);
 		DirectedCycle directedcycle = new DirectedCycle(digraph);
 		if(directedcycle.hasCycle()) {
 			System.out.println("Cycle exists.");
 		} else {
 			System.out.println("Cycle doesn't exists.");
 		}

 	}
 }