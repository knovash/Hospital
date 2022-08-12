package root.human.property;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Address {

    static final Logger LOGGER = LogManager.getLogger(Address.class);

    private String country;
    private String city;
    private String street;
    private Integer houseNumber;

    public Address(String country, String city, String street, int houseNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String toString() {
        return ("Address: " + this.country + " " + this.city + " " + this.street + " " + this.houseNumber);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Address other = (Address) object;
        return this.houseNumber == other.houseNumber &&
                this.country.equals(other.country) &&
                this.city.equals(other.city) &&
                this.street.equals(other.street);
    }

    public int hashCode() {
        int result = houseNumber;

        LOGGER.info("country: " + this.country + " " + this.country.hashCode());
        LOGGER.info("city: " + this.city + " " + this.city.hashCode());
        LOGGER.info("street: " + this.street + " " + this.street.hashCode());
        LOGGER.info("houseNumber: " + this.houseNumber + " " + this.houseNumber.hashCode());

        result =
                this.country.hashCode() +
                        this.city.hashCode() +
                        this.street.hashCode();
        LOGGER.info("HASH: " + result);
        return result;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
}