package Day3.JUnit.BasicJUnit;

public class TaskManager {
    public static String longRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

class TaskManagerTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskPerformance() {
        String result = TaskManager.longRunningTask();
        assertEquals("Task Completed", result);
    }
}