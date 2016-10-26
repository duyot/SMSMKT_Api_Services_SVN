package com.vivas.service.impl.rest;

import com.vivas.dto.*;
import com.vivas.persistent.DBUtils;
import com.vivas.service.interfaces.TCBService;
import org.springframework.context.annotation.Scope;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.Connection;

/**
 * Created by duyot on 9/16/2016.
 */
@Path("/Services")
public class TCBServiceRestImpl implements TCBService {
    @POST
    @Path("/SendSMS")
    @Produces({"application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    @Override
    public SMSResponse sendSMS(SMSRequest smsRequest) {
        return new SMSResponse("3434","REST_CODE","DESC","SIG");
    }

    @POST
    @Path("/SendSMSBlank")
    @Produces({"application/xml","application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    public SMSResponse sendSMSBlank() {
        Connection con = DBUtils.getConnection();
        if(con != null){
            return new SMSResponse("3434","SUCCESS","DESC","SIG");
        }else{
            return new SMSResponse("3434","FAIL","DESC","SIG");
        }

    }

    @Override
    public ListSMSResponse sendSMSList(ListSMSRequest lstSMListSMSRequest) {
        return null;
    }

    @Override
    public ReconcileResponse SMSReconcile(ReconcileRequest reconcileRequest) {
        return null;
    }

    @Override
    public ListReconcileResponse SMSReconcileList(ListReconcileRequest listReconcileRequest) {
        return null;
    }

    @Override
    public UpdateMsgTypeResult updateMsgType(MsgType msgType) {
        return null;
    }
}
