package com.rss.respond;

import com.google.gson.annotations.SerializedName;

//API key = devU01TX0FVVEgyMDIwMDYyNzAwNTYxMjEwOTkwODk=
public class AddressBody {
    @SerializedName("roadAddr") //전체 도로명 주소
    private String roadAddr;

    @SerializedName("roadAddrPart1") // 도로명주소
    private String roadAddrPart1;

    @SerializedName("jibunAddr") //지번주소
    private String jibunAddr;

    @SerializedName("engAddr") //영문주소
    private String engAddr;

    @SerializedName("zipNo") //우편번호
    private String zipNo;

    @SerializedName("admCd") //행정구역코드
    private String admCd;

    @SerializedName("mMgSn") //도로명코드
    private String mMgSn;

    @SerializedName("bdMgSn") //건물관리번호
    private String bdMgSn;

    @SerializedName("bdKdcd") //공동주택여부(1:공동, 0:비공동)
    private String bdKdcd;

    @SerializedName("siNm") //시도명
    private String siNm;
    @SerializedName("sggNm") //구
    private String ssgNm;

    @SerializedName("emdNm") //읍명동명
    private String emdNm;

    @SerializedName("Rn") //도로명
    private String Rn;

    @SerializedName("udrtYn") //지하여부
    private String udrtYn;

    @SerializedName("buldMnnm") //건물본번
    private String buldMnnm;

    @SerializedName("buldSlno") //건물부번(없는 경우0)
    private String buldSlno;

    @SerializedName("mtYn") //산여부(0:대지, 1:산)
    private String mtYn;

    @SerializedName("lnbrMnnm") //지번본번(번지)
    private int lnbrMnnm;

    @SerializedName("lnbrSlno") //지번부번(호) 없는 경우 0
    private int lnbrSlno;

    @SerializedName("emdNo") //읍명동 일련번호
    private String emdNo;

    public String getRoadAddr() {
        return roadAddr;
    }

    public void setRoadAddr(String roadAddr) {
        this.roadAddr = roadAddr;
    }

    public String getRoadAddrPart1() {
        return roadAddrPart1;
    }

    public void setRoadAddrPart1(String roadAddrPart1) {
        this.roadAddrPart1 = roadAddrPart1;
    }

    public String getJibunAddr() {
        return jibunAddr;
    }

    public void setJibunAddr(String jibunAddr) {
        this.jibunAddr = jibunAddr;
    }

    public String getEngAddr() {
        return engAddr;
    }

    public void setEngAddr(String engAddr) {
        this.engAddr = engAddr;
    }

    public String getZipNo() {
        return zipNo;
    }

    public void setZipNo(String zipNo) {
        this.zipNo = zipNo;
    }

    public String getAdmCd() {
        return admCd;
    }

    public void setAdmCd(String admCd) {
        this.admCd = admCd;
    }

    public String getmMgSn() {
        return mMgSn;
    }

    public void setmMgSn(String mMgSn) {
        this.mMgSn = mMgSn;
    }

    public String getBdMgSn() {
        return bdMgSn;
    }

    public void setBdMgSn(String bdMgSn) {
        this.bdMgSn = bdMgSn;
    }

    public String getBdKdcd() {
        return bdKdcd;
    }

    public void setBdKdcd(String bdKdcd) {
        this.bdKdcd = bdKdcd;
    }

    public String getSiNm() {
        return siNm;
    }

    public void setSiNm(String siNm) {
        this.siNm = siNm;
    }

    public String getSsgNm() {
        return ssgNm;
    }

    public void setSsgNm(String ssgNm) {
        this.ssgNm = ssgNm;
    }

    public String getEmdNm() {
        return emdNm;
    }

    public void setEmdNm(String emdNm) {
        this.emdNm = emdNm;
    }

    public String getRn() {
        return Rn;
    }

    public void setRn(String rn) {
        Rn = rn;
    }

    public String getUdrtYn() {
        return udrtYn;
    }

    public void setUdrtYn(String udrtYn) {
        this.udrtYn = udrtYn;
    }

    public String getBuldMnnm() {
        return buldMnnm;
    }

    public void setBuldMnnm(String buldMnnm) {
        this.buldMnnm = buldMnnm;
    }

    public String getBuldSlno() {
        return buldSlno;
    }

    public void setBuldSlno(String buldSlno) {
        this.buldSlno = buldSlno;
    }

    public String getMtYn() {
        return mtYn;
    }

    public void setMtYn(String mtYn) {
        this.mtYn = mtYn;
    }

    public int getLnbrMnnm() {
        return lnbrMnnm;
    }

    public void setLnbrMnnm(int lnbrMnnm) {
        this.lnbrMnnm = lnbrMnnm;
    }

    public int getLnbrSlno() {
        return lnbrSlno;
    }

    public void setLnbrSlno(int lnbrSlno) {
        this.lnbrSlno = lnbrSlno;
    }

    public String getEmdNo() {
        return emdNo;
    }

    public void setEmdNo(String emdNo) {
        this.emdNo = emdNo;
    }

    @Override
    public String toString() {
        return "AddressBody{" +
                "roadAddr='" + roadAddr + '\'' +
                ", roadAddrPart1='" + roadAddrPart1 + '\'' +
                ", jibunAddr='" + jibunAddr + '\'' +
                ", engAddr='" + engAddr + '\'' +
                ", zipNo='" + zipNo + '\'' +
                ", admCd='" + admCd + '\'' +
                ", mMgSn='" + mMgSn + '\'' +
                ", bdMgSn='" + bdMgSn + '\'' +
                ", bdKdcd='" + bdKdcd + '\'' +
                ", siNm='" + siNm + '\'' +
                ", ssgNm='" + ssgNm + '\'' +
                ", emdNm='" + emdNm + '\'' +
                ", Rn='" + Rn + '\'' +
                ", udrtYn='" + udrtYn + '\'' +
                ", buldMnnm='" + buldMnnm + '\'' +
                ", buldSlno='" + buldSlno + '\'' +
                ", mtYn='" + mtYn + '\'' +
                ", lnbrMnnm=" + lnbrMnnm +
                ", lnbrSlno=" + lnbrSlno +
                ", emdNo='" + emdNo + '\'' +
                '}';
    }
}
