import java.util.*;
import java.util.stream.Collectors;

public class BanknoteContainer {
    private final List<BanknoteCell> cells;

    public BanknoteContainer(List<BanknoteCell> cells) {
        this.cells = cells;
    }

    public void putCash(List<Banknote> banknotes) {
        banknotes.stream()
                .collect(Collectors.groupingBy(banknote -> banknote, Collectors.counting()))
                .forEach((banknote, count) -> getCell(banknote).put(Math.toIntExact(count)));
    }

    public List<Banknote> pullCash(int value) throws AtmException {
        TreeMap<Banknote, Integer> readyForPullMap = getReadyForPullMap(value);
        List<Banknote> banknotes = new ArrayList<>();

        if (value == getReadyForPullValue(readyForPullMap)) {
            readyForPullMap.forEach((banknote, count) -> {
                banknotes.addAll(getBanknotes(banknote, count));
                getCell(banknote).pull(count);
            });
        } else {
            throw new AtmException();
        }
        return banknotes;
    }


    public int getBalance() {
        return cells.stream()
                .map(BanknoteCell::getTotalValue)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<BanknoteCell> getCells() {
        return cells;
    }

    private List<Banknote> getBanknotes(Banknote banknote, int count) {
        List<Banknote> banknotes = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            banknotes.add(banknote);
        }
        return banknotes;
    }

    private TreeMap<Banknote, Integer> getReadyForPullMap(int value) {
        Comparator<Banknote> banknoteReverseOrder = (b1, b2) -> b2.getValue() - b1.getValue();
        TreeMap<Banknote, Integer> readyForPull = new TreeMap<>(banknoteReverseOrder);
        cells.stream()
                .map(BanknoteCell::getNominalValue)
                .sorted(banknoteReverseOrder)
                .forEach(banknote -> {
                    int readyForPullValue = getReadyForPullValue(readyForPull);
                    readyForPull.put(banknote, getCountBanknotesFromAmount(banknote, value - readyForPullValue));
                });
        return readyForPull;
    }

    private int getReadyForPullValue(Map<Banknote, Integer> readyForPull) {
        return readyForPull.entrySet().stream()
                .map(entry -> entry.getKey().getValue() * entry.getValue())
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int getCountBanknotesFromAmount(Banknote banknote, int value) {
        BanknoteCell cell = getCell(banknote);
        return value < cell.getTotalValue() ? value / banknote.getValue() : cell.getCount();
    }

    private BanknoteCell getCell(Banknote banknote) {
        return cells.stream()
                .filter(cell -> banknote.equals(cell.getNominalValue()))
                .findFirst().orElse(null);
    }
}