package les_1;

import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] years = {"крысы", "коровы", "тигра", "зайца", "дракона", "змеи", "лошади", "овцы",
                "обезьяны", "курицы", "собаки", "свиньи"};
        try {
            int num = scanner.nextInt();
            System.out.println(years[(num-4)%12]);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
