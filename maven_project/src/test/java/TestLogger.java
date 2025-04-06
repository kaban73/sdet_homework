import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestLogger {
    private static final Logger logger = LoggerFactory.getLogger(TestLogger.class);

    @Test
    public void testTrace() {
        logger.trace("Trace");
    }
    @Test
    public void testDebug() {
        logger.debug("Debugging");
    }
    @Test
    public void testInfo() {
        logger.info("Hello");
    }
    @Test
    public void testWarn() {
        logger.warn("Warning!");
    }
    @Test
    public void testError() {
        logger.error("Error!!!!!!!");
    }
}
