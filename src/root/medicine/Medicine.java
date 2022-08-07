package root.medicine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import root.human.property.Address;

import java.math.BigDecimal;

public class Medicine {
    protected static Logger LOGGER = LogManager.getLogger(Medicine.class);

    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;

    public Medicine(String name, String description, BigDecimal price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


    public void takeMedicine() {
        LOGGER.info("take medicine");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}