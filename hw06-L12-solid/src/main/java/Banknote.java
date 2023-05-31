public enum Banknote {
    R50 (50),
    R100 (100),
    R200 (200),
    R500 (500),
    R1000 (1000),
    R2000 (2000),
    R5000 (5000);

    private final int value;

    Banknote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
