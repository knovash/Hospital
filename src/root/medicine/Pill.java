package root.medicine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pill {

    static final Logger LOGGER = LogManager.getLogger(Pill.class);

    public Pill(String name) {
        this.name = name;
    }

    public String name;

    public void say() {
        LOGGER.info("say hello");
    }

    public void takePill() {
        LOGGER.info("pill implement show info   " + name);
    }


}
