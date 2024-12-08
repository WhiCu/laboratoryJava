package ind_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class TreeConstructor {
    public static Tree from(String filePath) {
        Tree<Integer> tree = null;
        try (Scanner file = new Scanner(new FileReader(filePath))) {
            if (file.hasNextInt()) {
                tree = new Tree<>(file.nextInt());
                file.nextLine();
            }
            while (file.hasNext()) {
                String[] line = file.nextLine().split(" ");
                System.out.println(Arrays.toString(line));
                switch (line[0]) {
                    case "A":
                        tree.addEdge(Integer.parseInt(line[1]) - 1, Integer.parseInt(line[2]) - 1);
                        break;
                    case "R":
                        tree.removeEdge(Integer.parseInt(line[1]) - 1, Integer.parseInt(line[2]) - 1);
                        break;
                    case "F":
                        tree.addAllEdge(Integer.parseInt(line[1]) - 1);
                        break;
                    case "I":
                        tree.removeAllEdge(Integer.parseInt(line[1]) - 1);
                        break;
                    case "C":
                        tree.swapVertex(Integer.parseInt(line[1]) - 1, Integer.parseInt(line[2]) - 1);
                        break;
                    case "Add":
                        tree.addVertex();
                        break;
                    default:
                        System.out.println("Заглушка");
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Нет такого файла");
            System.out.println(ex);
        }
        return tree;
    }
}
