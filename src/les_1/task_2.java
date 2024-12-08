package les_1;

public class task_2 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 37; j++) {
                System.out.print("_");
            }
            System.out.println();
            System.out.print("|");
            for (int j = 1; j < 10; j++) {
                System.out.printf("%3d|",i*j);
            }
            System.out.println();
        }
        for (int i = 0; i < 37; i++) {
            System.out.print("_");
        }
    }
}
