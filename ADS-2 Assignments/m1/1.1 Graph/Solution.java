import java.util.Scanner;
/**.
 * { item_description }
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        /**.
         * { item_description }
         */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    // time complexity for the main method is N
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int n =  sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        switch (word) {
            case"List":
                if (n == 0 && m == 0) {
                    System.out.println(n + " vertices, " + m + " edges");
                    System.out.println("No edges");
                    break;
                }
                String vertex1 = sc.nextLine();
                String[] tokens = vertex1.split(",");
                GraphList graphlist = new GraphList(n);
                for (int i = 0; i < n; i++) {
                    graphlist.addVertex(tokens[i]);
                }
                String line1;
                String[] input = new String[m];
                for (int i = 0; i < m; i++) {
                    line1 = sc.nextLine();
                    input = line1.split(" ");
                        graphlist.addEdge(Integer.parseInt(input[0]),
                         Integer.parseInt(input[1]));
                }
                if (Integer.parseInt(input[0])
                 == Integer.parseInt(input[1])) {
                    break;
                } else {
                    System.out.println(graphlist.toString());
                }
                break;
            case"Matrix":
                if (n == 0 && m == 0) {
                    System.out.println(n + " vertices, " + m + " edges");
                    System.out.println("No edges");
                    break;
                }
                String vertices = sc.nextLine();
                String[] strinput = vertices.split(",");
                GraphMat graphmatrix = new GraphMat(n);
                for (int i = 0; i < n; i++) {
                    graphmatrix.addVertex(strinput[i]);
                }
                String line;
                String[] input1 = new String[m];
                for (int i = 0; i < m; i++) {
                    line = sc.nextLine();
                    input1 = line.split(" ");
                    graphmatrix.addEdge(Integer.parseInt(input1[0]),
                     Integer.parseInt(input1[1]));
                }
                if (Integer.parseInt(input1[0])
                 == Integer.parseInt(input1[1])) {
                    break;
                } else {
                    System.out.println(graphmatrix.toString());
                }
                break;
            default:
            break;
        }
    }
}
