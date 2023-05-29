import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BanknoteCell> cells = List.of(new BanknoteCell(Banknote.R5000, 50),
                new BanknoteCell(Banknote.R2000, 125),
                new BanknoteCell(Banknote.R1000, 250),
                new BanknoteCell(Banknote.R500, 500),
                new BanknoteCell(Banknote.R200, 700),
                new BanknoteCell(Banknote.R100, 1000),
                new BanknoteCell(Banknote.R50, 1000)); //в сумме 1290000
        BanknoteContainer banknoteContainer = new BanknoteContainer(cells);
        Atm atm = new Atm(banknoteContainer);

        atm.pullBanknotes(129950); // Выданы купюры: [R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R5000, R2000, R2000, R500, R200, R200, R50]
        atm.getBalance();// 1160050
        atm.pullBanknotes(13150); // Выданы купюры: [R5000, R5000, R2000, R1000, R100, R50]
        atm.getBalance(); // 1146900
        atm.pullBanknotes(900); // [R500, R200, R200]
        atm.getBalance(); // 1146000
        atm.pullBanknotes(1200000); // Ошибка- в банкомате недостаточно купюр
        atm.getBalance(); // 1146000
        atm.putBanknotes(List.of(Banknote.R5000, Banknote.R5000, Banknote.R2000, Banknote.R500)); // Внесены купюры:[R5000, R5000, R2000, R500]
        atm.getBalance(); // Остаток денежных средст: 1158500
    }
}
