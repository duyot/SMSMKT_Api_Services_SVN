package com.vivas.dto;

import javax.xml.bind.annotation.*;

/**
 * Created by duyot on 9/14/2016.
 */
//@XmlRootElement(name = "ReconcileRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReconcileRequest {
    @XmlElement(name="MsgID")
    private String MsgID;
    @XmlElement(name="Signature")
    private String Signature;

    @XmlTransient
    private String ip;

    public ReconcileRequest(String msgID, String signature) {
        MsgID = msgID;
        Signature = signature;
    }

    public ReconcileRequest() {
    }

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "ReconcileRequest{" +
                "MsgID='" + MsgID + '\'' +
                ", Signature='" + Signature + '\'' +
                ", IP='" + ip + '\'' +
                '}';
    }
}
