package ind_2.Diamond.Quality;

public enum Clarity {
    Fl((byte) 1),
    IF((byte) 2),
    VVS1((byte) 3),
    VVS2((byte) 4),
    VS1((byte) 5),
    VS2((byte) 6),
    SI1((byte) 7),
    SI2((byte) 8),
    I1((byte) 9),
    I2((byte) 10),
    I3((byte) 11);

    private final byte quality;

    Clarity(byte quality) {
        this.quality = quality;
    }

    public static Clarity Stoc(String clarity) {
        if (clarity == null) {
            throw new IllegalArgumentException("Clarity string cannot be null");
        }

        return switch (clarity) {
            case "Fl" -> Fl;
            case "IF" -> IF;
            case "VVS1" -> VVS1;
            case "VVS2" -> VVS2;
            case "VS1" -> VS1;
            case "VS2" -> VS2;
            case "SI1" -> SI1;
            case "SI2" -> SI2;
            case "I1" -> I1;
            case "I2" -> I2;
            case "I3" -> I3;
            default -> throw new IllegalArgumentException("Unknown clarity: " + clarity);
        };
    }
}
