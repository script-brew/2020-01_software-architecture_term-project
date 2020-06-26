package com.rss.respond;

import com.google.gson.annotations.SerializedName;

public class RespondFormat {
    @SerializedName("results")
    private AddressFormat format;

    public AddressFormat getFormat() {
        return format;
    }

    public void setFormat(AddressFormat format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "RespondFormat{" +
                "format=" + format +
                '}';
    }
}
