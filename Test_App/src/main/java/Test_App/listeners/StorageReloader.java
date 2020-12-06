package Test_App.listeners;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StorageReloader {

    private static List<DataReloadListener> listeners = new ArrayList<>();

    public static void registerListener(DataReloadListener listener) {
        listeners.add(listener);
    }

    public static void deregisterListener(DataReloadListener listener) {
        listeners.remove(listener);
    }

    public static void reloadStorage() throws FileNotFoundException {
        for (DataReloadListener listener : listeners) {
            listener.reloadStorage();
        }
    }
}
