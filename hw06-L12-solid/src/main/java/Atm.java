import java.util.List;

public class Atm {
    private BanknoteContainer container;

    public Atm(BanknoteContainer container) {
        this.container = container;
    }

    public void putBanknotes(List<Banknote> banknotes) {
        container.putCash(banknotes);
        System.out.println("Внесены купюры:" + banknotes);
    }

    public void pullBanknotes(int value) {
        try {
            System.out.println("Выданы купюры: " + container.pullCash(value));
        } catch (AtmException ex) {
            System.out.println("В банкомате недостаточно купюр");
        }
    }

    public void getBalance() {
        System.out.println("--Остаток денежных средст: " + container.getBalance());
        System.out.println("--информация по ячейкам: " + container.getCells());
    }

}
