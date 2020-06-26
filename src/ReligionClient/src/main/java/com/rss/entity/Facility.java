package com.rss.entity;

public class Facility {
    private int id;
    private String name;
    private Address address;
    private String number;
    private String description;
    private String url;
    private String kind;
    private int regUserId;

    public Facility() {
        id = 0;
    }
    public Facility(String name, Address address, String number, String description, String url, String kind, int regUserId) {
        this();
        this.name = name;
        this.address = address;
        this.number = number;
        this.description = description;
        this.url = url;
        this.kind = kind;
        this.regUserId = regUserId;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Facility{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", kind=" + kind +
                ", regUserId=" + regUserId +
                '}';
    }
}
