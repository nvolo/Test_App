package Test_App;

public class Transaction {
    private int id;
    private String category;
    private String amount;

    public Transaction () {

    }

    public Transaction(int id, String category, String amount){
        this.id = id;
        this.category = category;
        this.amount = amount;
    }

    public Transaction getCurrentTransaction(){
        return this;
    }



}
