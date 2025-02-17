package junit.performancetestingtest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.performancetesting.PerformanceTester;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class PerformanceTesterTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)  // Test fails if execution exceeds 2 seconds
    void testLongRunningTask_ShouldFail() {
        String result = PerformanceTester.longRunningTask();
        assertEquals("Task Completed", result);
    }
}
