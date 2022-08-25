package com.solvd.hospital.medicine.instrument;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Saw extends Instrument{

    private static final Logger LOGGER = LogManager.getLogger(Saw.class);

    private String name;
    private int quantity;

    public Saw(String name, int quantity) {
        super(name, quantity);
    }

    public void useScalpel() {
        LOGGER.info("use instrument scalpel");
    }
}
