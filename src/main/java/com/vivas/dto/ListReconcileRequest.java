package com.vivas.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by duyot on 9/14/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListReconcileRequest {

    @XmlElement(name="ReconcileRequest")
    List<ReconcileRequest> lstReconcileRequests;

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
}
