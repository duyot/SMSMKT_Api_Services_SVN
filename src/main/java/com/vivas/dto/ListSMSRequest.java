package com.vivas.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by duyot on 9/12/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListSMSRequest {
    @XmlElement(name = "SMSRequest")
    List<SMSRequest> lstSMSRequest;

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
}
