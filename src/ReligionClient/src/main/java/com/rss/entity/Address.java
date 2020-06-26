package com.rss.entity;

public class Address {
    private int id;
    private String city; //시
    private String gu; //구
    private String dong; //동
    private String postalCode; //우편번호
    private int zibun;
    private String apartment; //건물이름

    public Address(String city, String gu, String dong, int zibun, String postalCode, String apartment) {
        this.city = city;
        this.gu = gu;
        this.dong = dong;
        this.zibun = zibun;
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

    @Override
    public String toString() {
        return postalCode + "\n"
                + city + " " + gu + " " + dong + " " + zibun + " ";
    }
}
