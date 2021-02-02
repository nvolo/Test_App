//package Test_App;
//
//import java.text.ParseException;
//import java.util.Comparator;
//
//class SortByDate implements Comparator<Transaction> {
//
//    @Override
//    public int compare(Transaction o1, Transaction o2) {
//        try {
//            if (o1.getRecordDate() != null && o2.getRecordDate() != null) {
//                return o1.getRecordDate().compareTo(o2.getRecordDate());
//            } else return 0;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//}
