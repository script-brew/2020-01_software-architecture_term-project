package com.rss.respond;

import com.google.gson.annotations.SerializedName;

public class SignResponse {
    @SerializedName("code")
    int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
