package com.vivas.dto;

import javax.xml.bind.annotation.*;

/**
 * Created by duyot on 9/12/2016.
 */
@XmlRootElement(name = "SMSRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class SMSRequest {
    @XmlTransient
    private String ip;
    @XmlElement(name="MsgID")
    private String MsgID;
    @XmlElement(name="Sender")
    private String Sender;
    @XmlElement(name="Mobinumber")
    private String Mobinumber;
    @XmlElement(name="MsgText")
    private String MsgText;
    @XmlElement(name="MsgType")
    private String MsgType;
    @XmlElement(name="MsgTime")
    private String MsgTime;
    @XmlElement(name="MoID")
    private String MoID;
    @XmlElement(name="Priority")
    private int Priority;
    @XmlElement(name="LocalTime")
    private String LocalTime;
    @XmlElement(name="Extension")
    private String Extension;
    @XmlElement(name="Signature")
    private String Signature;

    public SMSRequest() {
    }

    @Override
    public String toString() {
        return "SMSRequest{" +
                "MsgID='" + MsgID + '\'' +
                ", IP='" + ip + '\'' +
                ", Sender='" + Sender + '\'' +
                ", Mobinumber='" + Mobinumber + '\'' +
                ", MsgText='" + MsgText + '\'' +
                ", MsgType='" + MsgType + '\'' +
                ", MsgTime='" + MsgTime + '\'' +
                ", MoID='" + MoID + '\'' +
                ", Priority='" + Priority + '\'' +
                ", LocalTime='" + LocalTime + '\'' +
                ", Extension='" + Extension + '\'' +
                ", Signature='" + Signature + '\'' +
                '}';
    }

    public SMSRequest(String msgID, String sender, String mobinumber, String msgText, String msgType, String moID, int priority, String localTime, String extension, String signature) {
        MsgID = msgID;
        Sender = sender;
        Mobinumber = mobinumber;
        MsgText = msgText;
        MsgType = msgType;
        MoID = moID;
        Priority = priority;
        LocalTime = localTime;
        Extension = extension;
        Signature = signature;
    }

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getMobinumber() {
        return Mobinumber;
    }

    public void setMobinumber(String mobinumber) {
        Mobinumber = mobinumber;
    }

    public String getMsgText() {
        return MsgText;
    }

    public void setMsgText(String msgText) {
        MsgText = msgText;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMoID() {
        return MoID;
    }

    public void setMoID(String moID) {
        MoID = moID;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public String getLocalTime() {
        return LocalTime;
    }

    public void setLocalTime(String localTime) {
        LocalTime = localTime;
    }

    public String getExtension() {
        return Extension;
    }

    public void setExtension(String extension) {
        Extension = extension;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public String getMsgTime() {
        return MsgTime;
    }

    public void setMsgTime(String msgTime) {
        MsgTime = msgTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
