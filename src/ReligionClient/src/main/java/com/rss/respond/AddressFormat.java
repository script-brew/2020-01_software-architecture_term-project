package com.rss.respond;

import com.google.gson.annotations.SerializedName;
import org.checkerframework.checker.guieffect.qual.SafeEffect;

import java.util.List;

public class AddressFormat {
    @SerializedName("common")
    private AddressHeader header;

    @SerializedName("juso")
    private List<AddressBody> body;

    public AddressHeader getHeader() {
        return header;
    }

    public void setHeader(AddressHeader header) {
        this.header = header;
    }

    public List<AddressBody> getBody() {
        return body;
    }

    public void setBody(List<AddressBody> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "AddressFormat{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
