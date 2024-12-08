package les_2;

import java.util.Arrays;

public class task_6 {
    private static String[] vrychnyu(String[] old){
        String[] current = new String[old.length];
        for(int i = 0; i < old.length; i++) {
            current[i] = old[i];
        }
        return current;
    }
    public static void main(String[] args) {
        String[] milStr = new String[1_000_000];
        Arrays.fill(milStr,"ABC");
        long start,finish;
        //
        start = System.nanoTime();
        vrychnyu(milStr);
        finish = System.nanoTime();
        System.out.println("test_1 : Прошло времени, нс: " + (finish-start));
        //
        start = System.nanoTime();
        Arrays.copyOf(milStr,milStr.length);
        finish = System.nanoTime();
        System.out.println("test_2 : Прошло времени, нс: " + (finish-start));
        //
        start = System.nanoTime();
        String[] newStr = new String[1_000_000];
        System.arraycopy(milStr,0,newStr,0,milStr.length);
        finish = System.nanoTime();
        System.out.println("test_3 : Прошло времени, нс: " + (finish-start));
    }
}
