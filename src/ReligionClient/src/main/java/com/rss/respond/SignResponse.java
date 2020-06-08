package com.rss.respond;

import com.google.gson.annotations.SerializedName;

public class SignResponse {
    @SerializedName("id")
    int id;
    @SerializedName("code")
    int code;

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