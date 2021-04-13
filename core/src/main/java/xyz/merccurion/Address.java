package xyz.merccurion;

public class Address {
    private int streetNo;
    private String barangay;
    private String city;
    private int zip;

    public Address() {}
    public Address(int streetNo, String barangay, String city, int zip) {
        this.streetNo = streetNo;
        this.barangay = barangay;
        this.city = city;
        this.zip = zip;
    }
    
    public int getStreetNo() {
        return streetNo;
    }
    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public String getBarangay() {
        return barangay;
    }
    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }
}