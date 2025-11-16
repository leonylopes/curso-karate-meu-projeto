import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import static org.junit.jupiter.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;


class RunTest {

    private static final Logger log = getLogger(RunTest.class);

    @Test
    void runTests() {

        Runner.Builder testBuilder = Runner.path("classpath:projeto");

        testBuilder.tags("smoke").tags("~ignore");

        String env = System.getProperty("karate.env");
        String tags = System.getProperty("karate.options");

        String threadsProperty = System.getProperty("threads");
        int numberOfThreads = 1;

        if (threadsProperty != null) {
            try {
                numberOfThreads = Integer.parseInt(threadsProperty);
            } catch (NumberFormatException err) {
                log.warn(err.toString());
                log.warn("Fallback to single thread execution");
            }
        }

        Results results = testBuilder.parallel(numberOfThreads);

    }

}
