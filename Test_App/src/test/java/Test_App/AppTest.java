/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Test_App;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AppTest {

    Storage storage;

    @BeforeEach
    public void beforeEach() {
        storage = Storage.getInstance();
        storage.createStorageFile();
    }

    @AfterEach
    public void afterEach() {
        storage.deleteFile();
    }

    @Test
    public void testGetInstance () {
        assertNotNull(storage, "Storage can`t be NULL!");
    }

    @Test
    public void testAddTransaction() {
        Transaction transaction = new Transaction("Salary", 200);
        storage.addTransaction(transaction);
        assertTrue(storage.getLoadedTransactions().contains(transaction), "Wrong transaction!");
    }

    @Test
    public void testSaveFile() throws IOException {
        assertDoesNotThrow(() -> storage.saveFile(), "Can not save file!");
    }

    @Test
    public void testRead() throws FileNotFoundException, InterruptedException {
        storage.read();
        assertNotNull(storage.getLoadedTransactions(), "Can not read transactions");
    }

    @Test
    public void testReadCatch() throws InterruptedException {
        storage.deleteFile();
        await().atMost(2, TimeUnit.SECONDS)
                .untilAsserted(() -> assertFalse(storage.ifFileExist(),"File still exist"));
        assertThrows(FileNotFoundException.class, () -> storage.read(), "Exception didn`t throw");
    }
}
