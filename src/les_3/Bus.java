package les_3;

public class Bus {
    private int numOfSeats;
    private int numOfOccupPlaces;
    private int costOfSeat;

    public Bus() {
        this.numOfSeats = 0;
        this.numOfOccupPlaces = 0;
    }

    public Bus(Bus bus) {
        this.numOfOccupPlaces = bus.numOfOccupPlaces;
        this.numOfSeats = bus.numOfSeats;
        this.costOfSeat = bus.costOfSeat;
    }

    public Bus(int numOfSeats, int numOfOccupPlaces, int costOfSeat) {
        this.numOfSeats = numOfSeats;
        this.numOfOccupPlaces = numOfOccupPlaces;
        this.costOfSeat = costOfSeat;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public int getNumOfOccupPlaces() {
        return numOfOccupPlaces;
    }

    public void setNumOfOccupPlaces(int numOfOccupPlaces) {
        this.numOfOccupPlaces = Math.min(numOfOccupPlaces, numOfSeats);
    }

    public int getCostOfSeat() {
        return costOfSeat;
    }

    public void setCostOfSeat(int costOfSeat) {
        this.costOfSeat = costOfSeat;
    }

    public boolean busOccupancy() {
        return numOfOccupPlaces == numOfSeats;
    }

    public int getCostOfOccupSeats() {
        return costOfSeat*numOfOccupPlaces;
    }
}
