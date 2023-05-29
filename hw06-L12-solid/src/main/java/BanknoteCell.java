public class BanknoteCell {
    private final Banknote nominalValue;
    private int count;

    public BanknoteCell(Banknote value, int count) {
        this.nominalValue = value;
        this.count = count;
    }

    public void pull(int count) {
        this.count -= count;
    }

    public void put(int count) {
        this.count += count;
    }

    public Banknote getNominalValue() {
        return nominalValue;
    }

    public int getTotalValue() {
        return nominalValue.getValue() * count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "[" +
                "nominalValue=" + nominalValue +
                ", count=" + count +
                ']';
    }
}
