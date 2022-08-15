package com.solvd.hospital.human.property;

public class Phone {

    private String countryCode;
    private String cityCode;
    private String localNumber;

    public Phone(String countryCode, String cityCode, String localNumber) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.localNumber = localNumber;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Phone other = (Phone) object;
        return this.countryCode.equals(other.countryCode) && this.cityCode.equals(other.cityCode) && this.localNumber.equals(other.localNumber);
    }

    public int hashCode() {
        return 31 * this.countryCode.hashCode() + this.cityCode.hashCode() + this.localNumber.hashCode();
    }

    public String toString() {
        return ("Phone: " + this.countryCode + this.cityCode + this.localNumber);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }
}