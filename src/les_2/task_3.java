package les_2;

import java.util.Arrays;
import java.util.function.Function;

public class task_3 {
    private static Function<Double, Double> fun(int i) {
        return switch (i) {
            case 1 -> x -> Math.pow(x, 2) - 10 * x + 15;
            case 2 -> x -> 2 * Math.sin(x + Math.PI / 3);
            case 3 -> x -> Math.pow(Math.E, Math.sqrt(x));
            default -> x -> x;
        };
    }

    public static void main(String[] args) {
        int[] rand = SimpleRand.randArray(20);
        double A = 0, B = 100, C = 10;
        int L = (int)Math.abs(A-B)/(int)C + 1;
/*
        Function<Double,Double> fun_1 = x -> Math.pow(x,2) - 10*x + 15;
        Function<Double,Double> fun_2 = x -> 2 * Math.sin(x + Math.PI/3);
        Function<Double,Double> fun_3 = x -> Math.pow(Math.E,Math.sqrt(x));
*/
        double[][] res = new double[4][L];
        for (int i = 0; i < 4; i++) {
            Function<Double,Double> f = fun(i);
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = f.apply(A+j*C);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.printf("|%10.2f|", res[i][j]);
            }
            System.out.println();
        }
    }
}

