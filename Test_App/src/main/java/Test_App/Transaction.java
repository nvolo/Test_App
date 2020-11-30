package Test_App;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transaction {

    private String date;
    public String category;
    public int amount;
    public LocalDateTime recordDate;

    public Transaction(String category, int amount) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        this.recordDate = LocalDateTime.now();
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
    public Date getRecordDate() throws ParseException {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(this.getDate());
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }
}
