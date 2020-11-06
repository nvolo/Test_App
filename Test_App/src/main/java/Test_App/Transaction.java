package Test_App;

public class Transaction {
    private int id;
    public String category;
    public String amount;

    public Transaction(int id, String category, String amount){
        this.id = id;
        this.category = category;
        this.amount = amount;
    }

    public Transaction getCurrentTransaction(){
        return this;
    }



}
