package com.rss.respond;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("code")
    private int code;


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
}
