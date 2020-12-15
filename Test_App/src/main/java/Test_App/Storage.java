package Test_App;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Storage {

    private static Storage instance;

    private List<Transaction> storage;

    private Storage() {
        storage = new ArrayList<>();
        createStorageFile();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public List<Transaction> getLoadedTransactions() {
        Collections.sort(storage, new SortByDate());
        Collections.reverse(storage);
        return storage;
    }

//    private ClassLoader classLoader = getClass().getClassLoader();
//
//    private File resource = new File(classLoader.getResource( "Storage.json").getFile());
//
//    private final InputStream inputStream  = Storage.class.getClassLoader().getResourceAsStream("Storage.json");
//    String FILE_NAME = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

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

    public void read() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(FILE_NAME));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
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

    public void createStorageFile(){
        File storageFile = new File(FILE_NAME);
        try {
            if (!storageFile.exists() && !storageFile.createNewFile()) {
                //
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile() {
        File storageFile = new File(FILE_NAME);
        storageFile.delete();
    }

    public boolean ifFileExist() {
        File storageFile = new File(FILE_NAME);
        return storageFile.exists();
    }
}
