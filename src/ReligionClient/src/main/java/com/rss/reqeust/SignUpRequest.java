package com.rss.reqeust;

import com.google.gson.annotations.SerializedName;
import com.rss.entity.User;
import com.rss.entity.UserKind;

public class SignUpRequest {
    @SerializedName("id")
    private int id;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("name")
    private String name;
    @SerializedName("number")
    private String number;
    @SerializedName("birthday")
    private String birthDay;
    @SerializedName("kind")
    private String kind;

    public SignUpRequest(int id, String email, String password, String name, String number, String birthDay, String kind) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.number = number;
        this.birthDay = birthDay;
        this.kind = kind;
    }

    public User toUser() {
        User user = new User(email, password, name, number, birthDay, UserKind.valueOf(kind));
        user.setId(id);
        return user;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
