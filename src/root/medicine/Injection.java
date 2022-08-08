package root.medicine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Injection {

    static final Logger LOGGER = LogManager.getLogger(Injection.class);

    public int id;

    public Injection(int id) {
        this.id = id;
    }

    public void sleep() {
        LOGGER.info("im sleep");
    }

    public void takeInjection() {
        LOGGER.info("injection implement show info    " + id);
    }

}
