package les_2;

public class task_1 {
    public static void main(String[] args) {
        int[] rand = SimpleRand.randArray(20);
        int sumRand = 0, countRand = 0;
        for (int i = 0; i < rand.length; i++) {
            rand[i] = SimpleRand.rand(0, 1000);
            if (String.valueOf(rand[i]).contentEquals(new StringBuilder(String.valueOf(rand[i])).reverse()) && String.valueOf(rand[i]).length() == 3) {
                System.out.println(rand[i]);
                sumRand += rand[i];
                countRand++;
            }
        }
        System.out.printf("\n|%-6d - sum|\n|%-4d - count|", sumRand, countRand);

    }
}
