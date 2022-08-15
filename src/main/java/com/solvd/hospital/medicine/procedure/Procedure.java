package com.solvd.hospital.medicine.procedure;

import com.solvd.hospital.medicine.Medicine;
import com.solvd.hospital.medicine.instrument.Instrument;

import java.math.BigDecimal;

public class Procedure {

    private String name;
    private String description;
    private BigDecimal price;
    private Instrument instrument;
    private Medicine medicine;

    public Procedure(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
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

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}