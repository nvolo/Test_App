package Test_App;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transaction {

    private String date;
    public String category;
    public int amount;

    public Transaction(String category, int amount) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        this.date = dtf.format(LocalDateTime.now());
        this.category = category;
        this.amount = amount;
    }

    public Transaction getCurrentTransaction() {
        return this;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }
}
