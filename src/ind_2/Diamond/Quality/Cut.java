package ind_2.Diamond.Quality;

public enum Cut {
    Fair((byte) 1),
    Good((byte)2),
    VeryGood((byte)3),
    Premium((byte)4),
    Ideal((byte)5);

    private final byte cut;
    Cut(byte cut){
        this.cut = cut;
    }

    public static Cut Stoc(String cut) {
        if (cut == null) {
            throw new IllegalArgumentException("Clarity string cannot be null");
        }

        return switch (cut) {
            case "Fair" -> Fair;
            case "Good" -> Good;
            case "Very Good" -> VeryGood;
            case "Premium" -> Premium;
            case "Ideal" -> Ideal;
            default -> throw new IllegalArgumentException("Unknown clarity: " + cut);
        };
    }
}
