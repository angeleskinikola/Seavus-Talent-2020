public class Address {
    private String street;
    private int streetNumber;
    private String city;
    private int zipCode;

    public Address(String street, int streetNumber, String city, int zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        if ((zipCode > 9999 && zipCode < 100000) || (zipCode > 99999999 && zipCode < 1000000000)) {
            this.zipCode = zipCode;
        } else {
            throw new ZipCodeException();
        }
    }

    @Override
    public String toString() {
        return "Street = " + street +
                "\nStreet number = " + streetNumber +
                "\nCity = " + city +
                "\nZip code = " + zipCode;
    }
}
