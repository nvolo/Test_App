package Test_App.listeners;

import java.io.FileNotFoundException;

public interface DataReloadListener {

    /**
     * Loads fresh data from storage and applies it to the page.
     */
    void reloadStorage() throws FileNotFoundException;
}
