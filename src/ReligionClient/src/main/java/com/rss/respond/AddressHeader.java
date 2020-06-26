package com.rss.respond;

import com.google.gson.annotations.SerializedName;

public class AddressHeader {
    @SerializedName("errorMessage")
    private String errorMessage;
    @SerializedName("countPerPage")
    private String countPerPage;
    @SerializedName("totalCount")
    private String totalCount;
    @SerializedName("errorCode")
    private String errorCode;
    @SerializedName("currentPage")
    private String currentPage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCountPerPage() {
        return countPerPage;
    }

    public void setCountPerPage(String countPerPage) {
        this.countPerPage = countPerPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "AddressHeader{" +
                "errorMessage='" + errorMessage + '\'' +
                ", countPerPage=" + countPerPage +
                ", currentPage=" + currentPage +
                ", errorCode='" + errorCode + '\'' +
                ", totalCount='" + totalCount + '\'' +
                '}';
    }
}
