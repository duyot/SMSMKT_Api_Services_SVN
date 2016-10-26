package com.vivas.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by duyot on 10/14/2016.
 */
@XmlRootElement(name = "UpdateMsgTypeResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateMsgTypeResult {
    @XmlElement(name="MsgType")
    private String msgType;
    @XmlElement(name="FromTime")
    private String fromTime;
    @XmlElement(name="ToTime")
    private String toTime;
    @XmlElement(name="Delta")
    private int delta;
    @XmlElement(name="Signature")
    private String signature;
    @XmlElement(name="RespCode")
    private String respCode;
    @XmlElement(name="RespDesc")
    private String respDesc;


    public UpdateMsgTypeResult(String msgType, String fromTime, String toTime, int delta, String signature, String respCode, String respDesc) {
        this.msgType = msgType;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.delta = delta;
        this.signature = signature;
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public UpdateMsgTypeResult() {
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    @Override
    public String toString() {
        return "UpdateMsgTypeResult{" +
                "msgType='" + msgType + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", delta=" + delta +
                ", signature='" + signature + '\'' +
                ", respCode='" + respCode + '\'' +
                ", respDesc='" + respDesc + '\'' +
                '}';
    }
}
