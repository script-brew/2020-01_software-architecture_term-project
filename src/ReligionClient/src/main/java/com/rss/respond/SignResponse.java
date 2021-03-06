package com.rss.respond;

import com.google.gson.annotations.SerializedName;

public class SignResponse {
    @SerializedName("id")
    int id;
    @SerializedName("code")
    int code;
    @SerializedName("error")
    String error;

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
