package ind_2.Diamond.Quality;

public enum Color {
    D((byte) 1),
    E((byte) 2),
    F((byte) 3),
    G((byte) 4),
    H((byte) 5),
    I((byte) 6),
    J((byte) 7);

    private final byte color;
    Color(byte color){
        this.color = color;
    }

    public static Color Stoc(String cut) {
        if (cut == null) {
            throw new IllegalArgumentException("Clarity string cannot be null");
        }

        return switch (cut) {
            case "D" -> D;
            case "E" -> E;
            case "F" -> F;
            case "G" -> G;
            case "H" -> H;
            case "I" -> I;
            case "J" -> J;
            default -> throw new IllegalArgumentException("Unknown clarity: " + cut);
        };
    }
}
