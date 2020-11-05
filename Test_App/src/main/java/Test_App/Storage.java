package Test_App;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Transaction> Storage = new ArrayList<Transaction>();

    public List<Transaction> getLoadedTransactions(){
        return Storage;
    }

    private static final String FILE_NAME = "C:\\Test_App\\Test_App\\src\\main\\java\\Test_App\\Transaction.json";

    private static final Type TRANSACTION_TYPE = new TypeToken<List<Transaction>>() {
    }.getType();

    public void addTransaction(Transaction transaction){
        Storage.add(transaction);
    }

    public void saveFile() throws IOException {
        Gson gson = new Gson();
        gson.toJson(Storage, new FileWriter(FILE_NAME));
    }

    public void read() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(FILE_NAME));
        Storage = gson.fromJson(reader, TRANSACTION_TYPE);
    }

    public void write(Transaction transaction) {

    }


    public void update() {

    }


}
