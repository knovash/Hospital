package com.solvd.hospital.medicine.instrument;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Scalpel extends Instrument {

    private static final Logger LOGGER = LogManager.getLogger(Scalpel.class);

    private String name;
    private int quantity;

    public Scalpel(String name, int quantity) {
        super(name, quantity);
    }

    public void useScalpel() {
        LOGGER.info("use instrument scalpel");
    }
}
