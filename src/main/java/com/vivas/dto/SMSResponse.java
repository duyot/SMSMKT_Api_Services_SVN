package com.vivas.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by duyot on 9/12/2016.
 */
@XmlRootElement(name = "SMSResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SMSResponse {
    @XmlElement(name="MsgID")
    private String MsgID;
    @XmlElement(name="RespCode")
    private String RespCode;
    @XmlElement(name="RespDesc")
    private String RespDesc;
    @XmlElement(name="Signature")
    private String Signature;

    public SMSResponse() {
    }

    public SMSResponse(String msgID, String respCode, String respDesc, String signature) {
        MsgID = msgID;
        RespCode = respCode;
        RespDesc = respDesc;
        Signature = signature;
    }

    public String getMsgID() {
        return MsgID;
    }

    public void setMsgID(String msgID) {
        MsgID = msgID;
    }

    public String getRespCode() {
        return RespCode;
    }

    public void setRespCode(String respCode) {
        RespCode = respCode;
    }

    public String getRespDesc() {
        return RespDesc;
    }

    public void setRespDesc(String respDesc) {
        RespDesc = respDesc;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    @Override
    public String toString() {
        return "SMSResponse{" +
                "MsgID='" + MsgID + '\'' +
                ", RespCode='" + RespCode + '\'' +
                ", RespDesc='" + RespDesc + '\'' +
                ", Signature='" + Signature + '\'' +
                '}';
    }
}
