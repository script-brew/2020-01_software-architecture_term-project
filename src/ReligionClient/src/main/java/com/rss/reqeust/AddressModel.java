package com.rss.reqeust;

import com.google.gson.annotations.SerializedName;
import com.rss.entity.Address;

public class AddressModel {
    @SerializedName("id")
    private int id;
    @SerializedName("city")
    private String city;
    @SerializedName("gu")
    private String gu;
    @SerializedName("dong")
    private String dong;
    @SerializedName("zibun")
    private int zibun;
    @SerializedName("postalCode")
    private String postalCode;
    @SerializedName("apartment")
    private String apartment;

    public AddressModel() {
        id = 0;
    }
    public AddressModel(String city, String gu, String dong, int zibun, String postalCode, String apartment) {
        this();
        this.city = city;
        this.gu = gu;
        this.dong = dong;
        this.zibun = zibun;
        this.postalCode = postalCode;
        this.apartment = apartment;
    }

    public Address toAddress() {
        Address address = new Address(city, gu, dong, zibun, postalCode, apartment);
        address.setId(id);
        return address;
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

    public int getZibun() {
        return zibun;
    }

    public void setZibun(int zibun) {
        this.zibun = zibun;
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
