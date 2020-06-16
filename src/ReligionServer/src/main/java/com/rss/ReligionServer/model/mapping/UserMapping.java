package com.rss.ReligionServer.model.mapping;

public class UserMapping {
    private int id;
    private String email;
    private String password;
    private String name;
    private String number;
    private String birthday;
    private String kind;

    public UserMapping(int id, String email, String password, String name, String number, String birthday, String kind) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.number = number;
        this.birthday = birthday;
        this.kind = kind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
