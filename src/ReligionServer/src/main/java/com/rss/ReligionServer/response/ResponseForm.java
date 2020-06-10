package com.rss.ReligionServer.response;

public class ResponseForm {
    private int code;
    private int id;
    private String error;

    public ResponseForm(int code, int id, String error) {
        this.code = code;
        this.id = id;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseForm{" +
                "code=" + code +
                ", id=" + id +
                ", error='" + error + '\'' +
                '}';
    }
}
