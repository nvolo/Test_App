package Test_App;
import java.util.Comparator;

class SortByDate implements Comparator<Transaction> {

    @Override
    public int compare(Transaction o1, Transaction o2) {
        if(o1.recordDate != null && o2.recordDate != null){
            return o1.recordDate.compareTo(o2.recordDate);
        }  else return 0;
    }
}
