package log4jTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
    static final Logger log = LogManager.getLogger(TestLogger.class.getName());

    public static void main(String[] args) {
        log.debug("DEGUG message!");
        log.info("INFO message");
    }
}
