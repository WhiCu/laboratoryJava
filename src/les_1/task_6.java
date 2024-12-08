package les_1;

import java.util.Scanner;

public class task_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        try {
            num = scanner.nextInt();
            if(num%50 != 0){
                System.out.println("Нет решения");
                return;
            }
            String res = new String();
            int n = num/1000;
            num %= 1000;
            res += String.format("%d*1000 | ", n);
            n = num/100;
            num %= 100;
            res += String.format("%d*100 | ", n);
            n = num/50;
            num %= 50;
            res += String.format("%d*50", n);
            System.out.println(res);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
