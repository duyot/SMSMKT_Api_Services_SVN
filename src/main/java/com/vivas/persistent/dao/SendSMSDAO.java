package com.vivas.persistent.dao;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.vivas.dto.ListSMSRequest;
import com.vivas.dto.ListSMSResponse;
import com.vivas.dto.SMSRequest;
import com.vivas.dto.SMSResponse;
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
public class SendSMSDAO {
    Logger log = LoggerFactory.getLogger(SendSMSDAO.class);

    public SendSMSDAO() {
    }

    public ListSMSResponse sendListSMS(ListSMSRequest mtList){
        log.info("Request info: "+ mtList.toString());
        ListSMSResponse lstSMSmsResponse = new ListSMSResponse();
        List<SMSResponse> lstSMSmsResponses = Lists.newArrayList();
        List<SMSRequest> lstSMSRequest = mtList.getLstSMSRequest();

        if(FunctionUtils.isListNullOrEmpty(lstSMSRequest)){
            log.error("No data found in ListSMSRequest");
            lstSMSmsResponses.add(FunctionUtils.genErroResult("","-1","no data found",""));
            lstSMSmsResponse.setLstSMSmsResponses(lstSMSmsResponses);
            return lstSMSmsResponse;
        }

        for(SMSRequest i: lstSMSRequest){
            i.setIp(mtList.getIp());
            SMSResponse smsResponse = sendSMS(i);
            lstSMSmsResponses.add(smsResponse);
        }
        lstSMSmsResponse.setLstSMSmsResponses(lstSMSmsResponses);
        log.info(lstSMSmsResponse.toString());
        return lstSMSmsResponse;

    }

    public SMSResponse sendSMS(SMSRequest mt){
        log.info("Request info: "+ mt.toString());
        Connection connection = DBUtils.getConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        SMSResponse smsResponse;
        try {
            String sendSMSSql = "begin ?:=pkg_tcb_api.fSendSms(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); end;";
            cstmt = connection.prepareCall(sendSMSSql);
            cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);

            cstmt.setString(2, mt.getIp());
            cstmt.setString(3, mt.getMsgID());
            cstmt.setString(4, mt.getSender());
            cstmt.setString(5, mt.getMobinumber());
            cstmt.setString(6, mt.getMsgText());
            cstmt.setString(7, mt.getMsgType());
            cstmt.setString(8, mt.getMsgTime());
            cstmt.setString(9, mt.getMoID());
            cstmt.setString(10, mt.getPriority());
            cstmt.setString(11, mt.getLocalTime());
            cstmt.setString(12, mt.getExtension());
            cstmt.setString(13, mt.getSignature());

            cstmt.executeQuery();

            String sendSMSResult = cstmt.getString(1);
            log.info("Request result: "+ sendSMSResult);

            return FunctionUtils.getResponseFromResult(sendSMSResult);
        } catch (Exception e) {
            log.error("Error: ", e);
            return FunctionUtils.genErroResult(mt.getMsgID(),"-1","error", mt.getSignature());
        } finally {
            DBUtils.closeConnection(rs,cstmt,connection);
        }
    }
}
