package com.vivas.dto;

import javax.xml.bind.annotation.*;

/**
 * Created by duyot on 10/14/2016.
 */
@XmlRootElement(name = "MsgType")
@XmlAccessorType(XmlAccessType.FIELD)
public class MsgType {
    @XmlTransient
    private String ip;
    @XmlElement(name="MsgType")
    private String msgType;
    @XmlElement(name="FromTime")
    private String fromTime;
    @XmlElement(name="ToTime")
    private String toTime;
    @XmlElement(name="Signature")
    private String Signature;
    @XmlElement(name="Delta")
    private int delta;

    public MsgType(String ip, String msgType, String fromTime, String toTime, String signature, int delta) {
        this.ip = ip;
        this.msgType = msgType;
        this.fromTime = fromTime;
        this.toTime = toTime;
        Signature = signature;
        this.delta = delta;
    }

    public MsgType() {
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
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    @Override
    public String toString() {
        return "MsgType{" +
                "ip='" + ip + '\'' +
                ", msgType='" + msgType + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", Signature='" + Signature + '\'' +
                ", delta=" + delta +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
