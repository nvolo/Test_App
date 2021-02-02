package Test_App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transaction {

    private int id;
    private String date;
    private int type;
    private int category;
    private int sum;
    private String comment;


    // from database
    public Transaction(int id, String date, int type, int category, int sum, String comment) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.category = category;
        this.sum = sum;
        this.comment = comment;

    }

    // from UI
    public Transaction(int category, int sum, int type) {
        this.category = category;
        this.sum = sum;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getCategory() {
        return category;
    }

    public int getSum() {
        return sum;
    }

    public int getType() {
        return type;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }
}
