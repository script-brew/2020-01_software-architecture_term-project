package com.rss.respond;

import com.google.gson.annotations.SerializedName;

//API key = devU01TX0FVVEgyMDIwMDYyNzAwNTYxMjEwOTkwODk=
public class AddressBody {
    @SerializedName("roadAddr") //��ü ���θ� �ּ�
    private String roadAddr;

    @SerializedName("roadAddrPart1") // ���θ��ּ�
    private String roadAddrPart1;

    @SerializedName("jibunAddr") //�����ּ�
    private String jibunAddr;

    @SerializedName("engAddr") //�����ּ�
    private String engAddr;

    @SerializedName("zipNo") //�����ȣ
    private String zipNo;

    @SerializedName("admCd") //���������ڵ�
    private String admCd;

    @SerializedName("mMgSn") //���θ��ڵ�
    private String mMgSn;

    @SerializedName("bdMgSn") //�ǹ�������ȣ
    private String bdMgSn;

    @SerializedName("bdKdcd") //�������ÿ���(1:����, 0:�����)
    private String bdKdcd;

    @SerializedName("siNm") //�õ���
    private String siNm;
    @SerializedName("sggNm") //��
    private String ssgNm;

    @SerializedName("emdNm") //������
    private String emdNm;

    @SerializedName("Rn") //���θ�
    private String Rn;

    @SerializedName("udrtYn") //���Ͽ���
    private String udrtYn;

    @SerializedName("buldMnnm") //�ǹ�����
    private String buldMnnm;

    @SerializedName("buldSlno") //�ǹ��ι�(���� ���0)
    private String buldSlno;

    @SerializedName("mtYn") //�꿩��(0:����, 1:��)
    private String mtYn;

    @SerializedName("lnbrMnnm") //��������(����)
    private int lnbrMnnm;

    @SerializedName("lnbrSlno") //�����ι�(ȣ) ���� ��� 0
    private int lnbrSlno;

    @SerializedName("emdNo") //���� �Ϸù�ȣ
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
