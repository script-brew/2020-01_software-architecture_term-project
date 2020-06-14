package com.rss.respond;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("code")
    private int code;
    @SerializedName("error")
    private String error;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
