package com.vivas.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by duyot on 9/14/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListSMSResponse {

    @XmlElement(name="SMSResponse")
    List<SMSResponse> lstSMSmsResponses;

    public ListSMSResponse(List<SMSResponse> lstSMSmsResponses) {
        this.lstSMSmsResponses = lstSMSmsResponses;
    }

    public ListSMSResponse() {
    }

    public List<SMSResponse> getLstSMSmsResponses() {
        return lstSMSmsResponses;
    }

    public void setLstSMSmsResponses(List<SMSResponse> lstSMSmsResponses) {
        this.lstSMSmsResponses = lstSMSmsResponses;
    }

    @Override
    public String toString() {
        return "ListSMSResponse{" +
                "lstSMSmsResponses=" + lstSMSmsResponses +
                '}';
    }
}
