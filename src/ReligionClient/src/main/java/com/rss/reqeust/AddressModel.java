package com.rss.reqeust;

public class AddressModel {
    private int id;
    private String city;
    private String gu;
    private String dong;
    private String postalCode;
    private String apartment;

    public AddressModel() {
        id = 0;
    }
    public AddressModel(String city, String gu, String dong, String postalCode, String apartment) {
        this();
        this.city = city;
        this.gu = gu;
        this.dong = dong;
        this.postalCode = postalCode;
        this.apartment = apartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
