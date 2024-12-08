package les_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class task_2 {
    public static void main(String[] args) {
        int[] rand = SimpleRand.randArray(20);
        for (int i = 0; i < rand.length; i++) {
            rand[i] = SimpleRand.rand(0, 1000);
        }
        System.out.println(Arrays.stream(rand).max().getAsInt());

    }
}
