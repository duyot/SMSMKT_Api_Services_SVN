package com.vivas.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by duyot on 9/12/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListSMSRequest {
    @XmlTransient
    public String ip;

    @XmlElement(name = "SMSRequest")
    List<SMSRequest> lstSMSRequest;

    @Override
    public String toString() {
        return "ListSMSRequest{" +
                "lstSMSRequest=" + lstSMSRequest +
                "IP =" + ip +
                '}';
    }

    public ListSMSRequest(List<SMSRequest> lstSMSRequest) {
        this.lstSMSRequest = lstSMSRequest;
    }

    public ListSMSRequest() {
    }

    public List<SMSRequest> getLstSMSRequest() {
        return lstSMSRequest;
    }

    public void setLstSMSRequest(List<SMSRequest> lstSMSRequest) {
        this.lstSMSRequest = lstSMSRequest;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
