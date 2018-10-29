import java.util.Scanner;
class GraphMat {
    private String[] tokens;
    private int[][] matrix;
    private int vertices;
    private int edges;
    GraphMat() {
    }
    GraphMat(Scanner scan) {
        this.vertices = Integer.parseInt(scan.nextLine());
        matrix = new int[vertices][vertices];
        edges = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        for (int i = 0; i < edges; i++) {
            String[] inputs = scan.nextLine().split(" ");
            addE(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }
    }

    public void addE(int vertexOne, int vertexTwo) {
        matrix[vertexOne][vertexTwo] = 1;
        matrix[vertexTwo][vertexOne] = 1;
    }
    public void print() {
        String str = "";
        str += vertices + " vertices, " + edges + " edges" + "\n";
        if (edges > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    str += matrix[i][j] + " ";
                }
                str += "\n";
            }
            System.out.println(str);
        } else {
             str += "No edges";
            System.out.println(str);
        }
    }
}