package les_2;

public class SimpleRand {
    public static int rand(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public static int[] randArray(int lengh){
        int[] rand = new int[lengh];
        for (int i = 0; i < rand.length; i++) {
            rand[i] = SimpleRand.rand(0, 1000);
        }
        return rand;
    }
}
