package by.vladiyss.sample.domain;

public class OrderDeliveryAddress {
    private final String country;
    private final String region;
    private final String town;
    private final String address;
    private final String postalCode;

    public OrderDeliveryAddress(String country, String region, String town, String address, String postalCode) {
        this.country = country;
        this.region = region;
        this.town = town;
        this.address = address;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getTown() {
        return town;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
