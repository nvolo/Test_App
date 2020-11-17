package Test_App;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class Storage {

    private static List<Transaction> Storage;
    private static Storage storageClass;

    public List<Transaction> getLoadedTransactions(){
        return Storage;
    }

    private static final String FILE_NAME = "Storage.json";

    private static final Type TRANSACTION_TYPE = new TypeToken<List<Transaction>>() {
    }.getType();

    public void addTransaction(Transaction transaction){
        Storage.add(transaction);
    }

    public void saveFile() throws IOException {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(Storage, writer);
        }
    }

    public void read() throws IOException {
        File storageFile = new File(FILE_NAME);
        if(!storageFile.exists() && !storageFile.createNewFile()){
            //
        }
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(FILE_NAME));
        Storage = gson.fromJson(reader, new TypeToken<List<Transaction>>() {}.getType());
    }

    public static Storage getStorage() {
        if (storageClass == null) {
            storageClass = new Storage();
            Storage = new ArrayList<Transaction>();
        }
        return storageClass;
    }
}
