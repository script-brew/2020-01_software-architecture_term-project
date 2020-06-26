package com.rss.reqeust;

import com.google.gson.annotations.SerializedName;
import com.rss.entity.Facility;

public class FacilityModel {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("number")
    private String number;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("kind")
    private String kind;
    @SerializedName("regUserId")
    private int regUserId;
    @SerializedName("address")
    private AddressModel address;

    public FacilityModel(int id, String name, String number, String description, String url, String kind, int regUserId, AddressModel address) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.description = description;
        this.url = url;
        this.kind = kind;
        this.regUserId = regUserId;
        this.address = address;
    }

    public Facility toFacility() {
        Facility facility = new Facility(name, address.toAddress(), number, description, url, kind, regUserId);
        facility.setId(id);
        return facility;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
