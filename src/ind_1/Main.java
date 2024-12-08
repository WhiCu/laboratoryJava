package ind_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = TreeConstructor.from("src\\ind_1\\Tree_test.txt").adjacencyMatrix();
        for(int[] line: matrix)
            System.out.println(Arrays.toString(line));


    }
}
