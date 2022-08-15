package com.solvd.hospital.utils;

import com.solvd.hospital.human.patient.Patient;

public class CureTestGeneric<T> {

    private String name;
    private T doc;
    private Patient pat;

    public CureTestGeneric(String name, T doc, Patient pat) {
        this.name = name;
        this.doc = doc;
        this.pat = pat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getDoc() {
        return doc;
    }

    public void setDoc(T doc) {
        this.doc = doc;
    }

    public Patient getPat() {
        return pat;
    }

    public void setPat(Patient pat) {
        this.pat = pat;
    }
}
