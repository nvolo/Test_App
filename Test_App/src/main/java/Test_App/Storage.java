package Test_App;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class Storage {

    private static Storage instance;

    private List<Transaction> storage;

    private Storage() {
        storage = new ArrayList<>();
        read();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public List<Transaction> getLoadedTransactions() {
        return storage;
    }

    private static final String FILE_NAME = "Storage.json";

    public void addTransaction(Transaction transaction) {
        storage.add(transaction);
    }

    public void saveFile() throws IOException {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(storage, writer);
        }
    }

    public void read() {
        File storageFile = new File(FILE_NAME);
        try {
            if (!storageFile.exists() && !storageFile.createNewFile()) {
                //
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        storage = gson.fromJson(reader, new TypeToken<List<Transaction>>() {
        }.getType());
        if (storage == null) {
            storage = new ArrayList<>();
        }
    }

    public int getTotal() {
        return storage.stream()
                .mapToInt(Transaction::getAmount)
                .sum();
    }
}
