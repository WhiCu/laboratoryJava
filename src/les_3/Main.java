package les_3;

public class Main {
    public static void main(String[] args) {
        Bus A = new Bus(54,0,400);
        Bus B = new Bus(45,0,500);
        B.setNumOfOccupPlaces(45);
        A.setNumOfOccupPlaces(10);
        if (A.getCostOfOccupSeats()>11_000){
            System.out.printf("A - выгодно: цена - %d = занятых мест -%d", A.getCostOfOccupSeats(), A.getNumOfOccupPlaces());
        }else {
            System.out.printf("A - невыгодно: цена - %d = занятых мест -%d", A.getCostOfOccupSeats(), A.getNumOfOccupPlaces());
        }
        System.out.println();
        if (B.getCostOfOccupSeats()>11_000){
            System.out.printf("B - выгодно: цена - %d = занятых мест -%d", B.getCostOfOccupSeats(), B.getNumOfOccupPlaces());
        }else {
            System.out.printf("B - невыгодно: цена - %d = занятых мест -%d", B.getCostOfOccupSeats(),B.getNumOfOccupPlaces());
        }
    }
}
