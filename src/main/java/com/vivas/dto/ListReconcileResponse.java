package com.vivas.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by duyot on 9/14/2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListReconcileResponse {

    @XmlElement(name="ReconcileResponse")
    List<ReconcileResponse> lstReconcileResponses;

    public ListReconcileResponse(List<ReconcileResponse> lstReconcileResponses) {
        this.lstReconcileResponses = lstReconcileResponses;
    }

    public ListReconcileResponse() {
    }

    public List<ReconcileResponse> getLstReconcileResponses() {
        return lstReconcileResponses;
    }

    public void setLstReconcileResponses(List<ReconcileResponse> lstReconcileResponses) {
        this.lstReconcileResponses = lstReconcileResponses;
    }

    @Override
    public String toString() {
        return "ListReconcileResponse{" +
                "lstReconcileResponses=" + lstReconcileResponses +
                '}';
    }
}
