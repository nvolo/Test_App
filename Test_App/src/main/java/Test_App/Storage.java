package Test_App;

import Test_App.notifications.NotificationHandler;
import Test_App.notifications.NotificationManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public final class Storage {

    public static final String GET_TRANSACTIONS_NOTIFICATION = "getLoadedTransactions(): success";
    public static final String ADD_TRANSACTION_NOTIFICATION = "addTransaction(): success";
    public static final String GET_SUM_NOTIFICATION = "getTotalTransactionSum(): success";
    public static final String CREATE_TRANSACTIONS_TABLE_NOTIFICATION = "createTestTransactionTable(): success";
    public static final String DROP_TRANSACTIONS_TABLE_NOTIFICATION = "dropTestTransactionsTable(): success";

    private DataBaseConection dataBaseConection = DataBaseConection.getInstance();
    private static Storage instance;
    private List<Transaction> storage;

    private Storage() {
        NotificationHandler.register(new NotificationManager());
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public List<Transaction> getLoadedTransactions() throws SQLException {

        List<Transaction> list = new LinkedList<>();

        ResultSet result = dataBaseConection
                .select("*")
                .from("[Test_App].[dbo].[transactions]")
                .orderBy("date", false)
                .executeQuery();

        while (result.next()) {
            int id = result.getInt("id");
            String data = result.getString("date");
            int type = result.getInt("type");
            int category = result.getInt("category");
            int sum = result.getInt("sum");
            String comment = result.getString("comment");

            Transaction transaction = new Transaction(id, data, type, category, sum, comment);

            list.add(transaction);
        }
        NotificationHandler.sendNotification(GET_TRANSACTIONS_NOTIFICATION);
        return list;
    }


    public void addTransaction(Transaction transaction) throws SQLException {

        List<String> columns = Arrays.asList("date", "type", "category", "sum", "comment");

        List<String> values = new ArrayList<>();

        values.add("'2021-01-01'");
        values.add(String.valueOf(transaction.getType()));
        values.add(String.valueOf(transaction.getCategory()));
        values.add(String.valueOf(transaction.getSum()));
        values.add("'++++++'");

        dataBaseConection.insert("[Test_App].[dbo].[transactions]", columns, values)
                .executeUpdate();
        NotificationHandler.sendNotification(ADD_TRANSACTION_NOTIFICATION);
    }

    public int getTotalTransactionSum() throws SQLException {
        ResultSet result = DataBaseConection.getInstance()
                .select("")
                .sum("([sum])")
                .as("sum")
                .from("[Test_App].[dbo].[transactions]")
                .executeQuery();
        int sum = 0;
        while (result.next()) {
            sum = result.getInt("sum");
        }
        NotificationHandler.sendNotification(GET_SUM_NOTIFICATION);
        return sum;
    }

    public void createTestTransactionTable() throws SQLException {
        List<String> rows = Arrays.asList("id int", "date datetime", "type int", "category int", "sum int" , "comment varchar(255)");
        dataBaseConection
                .createTable("TRANSACTION_TEST", rows)
                .execute();
        NotificationHandler.sendNotification(CREATE_TRANSACTIONS_TABLE_NOTIFICATION);
    }

    public void dropTestTransactionsTable() throws SQLException {
        dataBaseConection.dropTable("[Test_App].[dbo].[TRANSACTION_TEST]")
                .execute();
        NotificationHandler.sendNotification(DROP_TRANSACTIONS_TABLE_NOTIFICATION);
    }
}
