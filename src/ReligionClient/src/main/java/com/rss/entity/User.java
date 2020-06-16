package com.rss.entity;

import com.google.gson.annotations.SerializedName;
import com.rss.reqeust.SignUpRequest;

public class User {
    private int id;
    private String email;
    private String password;
    private String name;
    private String number;
    private String birthDay;
    private UserKind kind;

    public User(String email, String password, String name, String number, String birthDay, UserKind kind) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.number = number;
        this.birthDay = birthDay;
        this.kind = kind;
    }

    public SignUpRequest toSignUpRequest() {
        SignUpRequest signUpRequest = new SignUpRequest(id, email, password, name, number, birthDay, kind.toString());
        return signUpRequest;
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

    public UserKind getKind() {
        return kind;
    }

    public void setKind(UserKind kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", birthDay=" + birthDay +
                ", kind=" + kind +
                '}';
    }
}
