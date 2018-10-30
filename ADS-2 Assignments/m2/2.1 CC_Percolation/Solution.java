import java.util.Scanner;
/**
 * class.
 **/
final class Solution {
    /**
     constructor.
     **/
    private Solution() {
        /**
         constructor.
         **/
    }
    /**
     main function.
     * @param args String.
     **/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.nextLine());
        Percolate obj = new Percolate(input);
        while (sc.hasNextLine()) {
            String[] inputs = sc.nextLine().split(" ");
            obj.open(Integer.parseInt(inputs[0]) - 1,
                Integer.parseInt(inputs[1]) - 1);
        }
        System.out.println(obj.isPercolate());
    }

}
/**
 * class.
 **/
class Percolate {
    /** grid boolean.
    **/
    private boolean[][] grid;
    /** object.
    **/
    private WeightedQuickUnionUF obj;
    /**
     * int size.
    **/
    private int size;
    /**
     * @param size1 int.
     **/
    Percolate(final int size1) {
        this.size = size1;
        grid = new boolean[size][size];
        obj = new WeightedQuickUnionUF(size * size + 2);
    }
    /**
     * @param row int.
     * @param column int.
     **/
    public void open(final int row, final int column) {
        if (grid[row][column]) {
            return;
        }
        grid[row][column] = true;
        if (row == 0) {
            obj.union(convert(row, column), size * size);
        }
        if (row == size - 1) {
            obj.union(convert(row, column), size * size + 1);
        }
        if (row < size - 1 && grid[row + 1][column]) { //bottom element
            obj.union(convert(row, column),
                convert(row + 1, column));
        }
        if (row > 0 && grid[row - 1][column]) { //top element
            obj.union(convert(row, column),
                convert(row - 1, column));
        }
        if (column > 0 && grid[row][column - 1]) { //left element
            obj.union(convert(row, column),
             convert(row, column - 1));
        }
        if (column < size - 1 && grid[row][column + 1]) {
            obj.union(convert(row, column),
             convert(row, column + 1));
        }


    }
    /**
    * @return true or false.
     **/
    public boolean isPercolate() {
        return obj.connected(size * size, size * size + 1);
    }
/**
 * @param i int.
 * @param j int.
 * @return i*size+j.
 **/
    public int convert(final int i, final int j) {
        return i * size + j;
    }
}
