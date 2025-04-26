package Day3.JUnit.BasicJUnit;

public class DatabaseConnection {
    private boolean connected;

    public void connect() {
        connected = true;
        System.out.println("Database connected.");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Database disconnected.");
    }

    public boolean isConnected() {
        return connected;
    }
}

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(), "Database should be connected after setUp");
    }

    @Test
    void testAnotherConnection() {
        assertTrue(dbConnection.isConnected(), "Database should still connect fresh before this test");
    }
}