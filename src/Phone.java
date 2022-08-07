public class Phone {

    //fields
    private String countryCode;
    private String cityCode;
    private String localNumber;

    //constructors
    public Phone(String countryCode, String cityCode, String localNumber) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.localNumber = localNumber;
    }

    //methods

    //setters and getters

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