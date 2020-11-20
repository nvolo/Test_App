package Test_App;

public class Transaction {

    private int id;
    public String category;
    public int amount;

    public Transaction(int id, String category, int amount) {
        this.id = id;
        this.category = category;
        this.amount = amount;
    }

    public Transaction getCurrentTransaction() {
        return this;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }
}
