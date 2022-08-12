package root.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    static final Logger LOGGER = LogManager.getLogger(Test.class);

    public static void main(String[] args) {

        // test
        LOGGER.info("test");
    }
}
