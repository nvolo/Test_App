package Test_App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transaction {

    private String date;
    private String category;
    private int amount;
    private LocalDateTime recordDate;

    public Transaction(String category, int amount) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.dateFormat);
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
        return new SimpleDateFormat(Constants.dateFormat).parse(this.getDate());
    }

    public String getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }
}
