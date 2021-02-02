package Test_App;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public final class Storage {
    private DataBaseConection dataBaseConection = DataBaseConection.getInstance();
    private static Storage instance;
    private List<Transaction> storage;

    private Storage() {
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public List<Transaction> getLoadedTransactions() throws SQLException {

        List list = new LinkedList();

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

            Transaction transaction = new Transaction (id, data, type, category, sum, comment);

            list.add(transaction);
        }
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
            sum  = result.getInt("sum");
        }
        return sum;
    }

    public void createTestTransactionTable() throws SQLException {
        List<String> rows = Arrays.asList("id int", "date datetime", "type int", "category int", "sum int" , "comment varchar(255)");
        dataBaseConection
                .createTable("TRANSACTION_TEST", rows)
                .execute();
    }

    public void dropTestTransactionsTable() throws SQLException {
        dataBaseConection.dropTable("[Test_App].[dbo].[TRANSACTION_TEST]")
                .execute();

    }
}
