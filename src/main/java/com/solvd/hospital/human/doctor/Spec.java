package com.solvd.hospital.human.doctor;

public enum Spec {
    CARD("spec. Cardiologist"), DENT("spec. Dentist"), EMER("spec. Emergency"), INFECT("spec. Infectiologist"), SURG("spec. Surgeon");

    private final String displayName;

    Spec(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}