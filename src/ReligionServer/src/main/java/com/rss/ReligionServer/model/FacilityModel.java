package com.rss.ReligionServer.model;

public class FacilityModel {
    private int id;
    private String name;
    private int number;
    private String description;
    private String url;
    private String kind;
    private int regUserId;
    private int addressId;

    public FacilityModel(int id, String name, int number, String description, String url, String kind, int regUserId, int addressId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.description = description;
        this.url = url;
        this.kind = kind;
        this.regUserId = regUserId;
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(int regUserId) {
        this.regUserId = regUserId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
