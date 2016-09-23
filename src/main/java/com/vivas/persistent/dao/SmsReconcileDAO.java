package com.vivas.persistent.dao;

import com.google.common.collect.Lists;
import com.vivas.dto.*;
import com.vivas.persistent.DBUtils;
import com.vivas.utils.FunctionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by duyot on 9/21/2016.
 */
public class SmsReconcileDAO {
    Logger log = LoggerFactory.getLogger(SmsReconcileDAO.class);

    public SmsReconcileDAO() {
    }

    public ListReconcileResponse smsReconcileList(ListReconcileRequest listReconcileRequest){
        log.info("Request info: "+ listReconcileRequest.toString());
        ListReconcileResponse lstListReconcileResponse = new ListReconcileResponse();
        List<ReconcileResponse> lstReconcileResponses = Lists.newArrayList();

        List<ReconcileRequest> lstReconcileRequests = listReconcileRequest.getLstReconcileRequests();
        if(FunctionUtils.isListNullOrEmpty(lstReconcileRequests)){
            log.error("No data found in ListSMSRequest");
            lstReconcileResponses.add(FunctionUtils.genReconcileErroResult("",""));
            lstListReconcileResponse.setLstReconcileResponses(lstReconcileResponses);
            return lstListReconcileResponse;
        }

        for(ReconcileRequest i: lstReconcileRequests){
            i.setIp(listReconcileRequest.getIp());
            ReconcileResponse reconcileResponse = smsReconcile(i);
            lstReconcileResponses.add(reconcileResponse);
        }

        lstListReconcileResponse.setLstReconcileResponses(lstReconcileResponses);
        return lstListReconcileResponse;

    }

    public ReconcileResponse smsReconcile(ReconcileRequest reconcileRequest){
        log.info("Request info: "+ reconcileRequest.toString());
        Connection connection = DBUtils.getConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        ReconcileResponse reconcileResponse;
        try {
            String smsReconcileSQL = "begin ?:=pkg_tcb_api.fSmsReconcile(?,?,?); end;";
            cstmt = connection.prepareCall(smsReconcileSQL);
            cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);

            cstmt.setString(2, reconcileRequest.getIp());
            cstmt.setString(3, reconcileRequest.getMsgID());
            cstmt.setString(4, reconcileRequest.getSignature());

            cstmt.executeQuery();

            String smsReconcileResult = cstmt.getString(1);
            log.info("Request result: "+ smsReconcileResult);
            log.info("---------------------------------------");

            return FunctionUtils.getReconcileResponseFromResult(smsReconcileResult);
        } catch (Exception e) {
            log.error("Error: ", e);
            return FunctionUtils.genReconcileErroResult(reconcileRequest.getMsgID(),reconcileRequest.getSignature());
        } finally {
            DBUtils.closeConnection(rs,cstmt,connection);
        }
    }
}
