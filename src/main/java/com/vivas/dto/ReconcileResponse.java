package com.vivas.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by duyot on 9/14/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ReconcileResponse {
    @XmlElement(name="MsgID")
    private String MsgID;
    @XmlElement(name="MsgLen")
    private int MsgLen;
    @XmlElement(name="MsgCount")
    private int MsgCount;
    @XmlElement(name="Signature")
    private String Signature;
    @XmlElement(name="RespCode")
    private String RespCode;

    public ReconcileResponse(String msgID, int msgLen, int msgCount, String signature, String respCode) {
        MsgID = msgID;
        MsgLen = msgLen;
        MsgCount = msgCount;
        Signature = signature;
        RespCode = respCode;
    }

    public ReconcileResponse() {
    }

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    public int getMsgLen() {
        return MsgLen;
    }

    public void setMsgLen(int msgLen) {
        MsgLen = msgLen;
    }

    public int getMsgCount() {
        return MsgCount;
    }

    public void setMsgCount(int msgCount) {
        MsgCount = msgCount;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public String getRespCode() {
        return RespCode;
    }

    public void setRespCode(String respCode) {
        RespCode = respCode;
    }

    @Override
    public String toString() {
        return "ReconcileResponse{" +
                "MsgID='" + MsgID + '\'' +
                ", MsgLen='" + MsgLen + '\'' +
                ", MsgCount='" + MsgCount + '\'' +
                ", Signature='" + Signature + '\'' +
                ", RespCode='" + RespCode + '\'' +
                '}';
    }
}
