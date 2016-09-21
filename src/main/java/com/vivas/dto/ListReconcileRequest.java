package com.vivas.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by duyot on 9/14/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListReconcileRequest {

    @XmlElement(name="ReconcileRequest")
    List<ReconcileRequest> lstReconcileRequests;

    @XmlTransient
    private String ip;

    public ListReconcileRequest(List<ReconcileRequest> lstReconcileRequests) {
        this.lstReconcileRequests = lstReconcileRequests;
    }

    public ListReconcileRequest() {
    }

    public List<ReconcileRequest> getLstReconcileRequests() {
        return lstReconcileRequests;
    }

    public void setLstReconcileRequests(List<ReconcileRequest> lstReconcileRequests) {
        this.lstReconcileRequests = lstReconcileRequests;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "ListReconcileRequest{" +
                "lstReconcileRequests=" + lstReconcileRequests +
                "ip=" + ip +
                '}';
    }
}
