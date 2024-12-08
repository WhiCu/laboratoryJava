package les_2;

import java.util.Arrays;

public class task_8 {
    public static void main(String[] args) {
        int[] temp = {-2, -5, -2, -4, 3, -6, -2, -1, 5, 1, 1,
                0, -1, 0, 3, -1, 2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11};
        int countChange = 0, countSummer = 0;
        int l = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] <= 0) {
                if (countSummer < i - l)
                    countSummer = i - l;
                l = i;
            }
            if (temp[l] <= 0) l++;
            if (i != temp.length - 1 && temp[i] < 0 && temp[i + 1] > 0)
                countChange++;
        }
        for (int i = Arrays.stream(temp).min().getAsInt(); i <= Arrays.stream(temp).max().getAsInt(); i++) {
            System.out.printf("%3d|", i);
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == i)
                    if (i == 0)
                        System.out.print("-*-");
                    else
                        System.out.print(" *  ");
                else if (i == 0)
                    System.out.print("---");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
        System.out.printf("%3d|", 0);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(" ");
            System.out.printf("%-2d", i);
        }
        System.out.printf("\n|%-6d - countChange|\n|%-6d - countSummer|", countChange, countSummer);
    }
}
