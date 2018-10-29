import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    Solution() {
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        switch (type) {
        case "List":
            GraphList graphObj = new GraphList(scan);
            System.out.println(graphObj);
            break;
        case "Matrix":
            GraphMat graphMat = new GraphMat(scan);
            graphMat.print();
            break;
        default : break;
        }
    }
}