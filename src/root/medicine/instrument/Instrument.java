package root.medicine.instrument;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.property.Address;

public class Instrument {
    protected static Logger LOGGER = LogManager.getLogger(Instrument.class);

    private String name;
    private int quantity;

    public Instrument(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void use() {
        LOGGER.info("use instrument");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
