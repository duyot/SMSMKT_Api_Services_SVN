package com.vivas.service.impl.soap;

import com.google.common.collect.Lists;
import com.vivas.dto.*;
import com.vivas.persistent.dao.SendSMSDAO;
import com.vivas.persistent.dao.SmsReconcileDAO;
import com.vivas.persistent.dao.UpdateMsgTypeDAO;
import com.vivas.service.interfaces.TCBService;
import com.vivas.utils.BundleUtils;
import com.vivas.utils.FunctionUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.interceptor.InInterceptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by duyot on 9/9/2016.
 */
@WebService(endpointInterface = "com.vivas.service.interfaces.TCBService",serviceName = "TCBService")
public class TCBServiceImpl implements TCBService {
    @Resource
    public WebServiceContext wsContext;
    private String username;
    private String password;

    Logger log = LoggerFactory.getLogger(TCBServiceImpl.class);

    public void getAccountInfo(ArrayList lstAuthorization){
        //account processing
        String userpass = (String) lstAuthorization.get(0);
        userpass = userpass.substring(5);
        byte[] buf = Base64.decodeBase64(userpass.getBytes());
        String credentials = new String(buf);

        int p = credentials.indexOf(":");
        if (p > -1) {
            this.username = credentials.substring(0, p);
            this.password = credentials.substring(p + 1);
        }
    }

    public SMSResponse sendSMS(SMSRequest mt) {
        log.info("Receiving request: "+ mt.toString());
        //
        MessageContext mctx = wsContext.getMessageContext();
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        ArrayList lstAuthorization = (ArrayList) http_headers.get("Authorization");

        if(FunctionUtils.isListNullOrEmpty(lstAuthorization)){
            log.info("Authorization not found!");
            return new SMSResponse(mt.getMsgID(),"-1","Authorization not found!","");
        }

        getAccountInfo(lstAuthorization);
        log.info("Account info: "+ username + " Password: "+ password);

        if(username == null || password == null){
            log.info("Username or password not found!");
            return new SMSResponse(mt.getMsgID(),"-1","Username or password not found!","");
        }
        if(username.equalsIgnoreCase(BundleUtils.getkey("username")) && password.equalsIgnoreCase(BundleUtils.getkey("password"))){
            //
            mt.setIp(FunctionUtils.getIPFromWebServiceContext(wsContext));
            SendSMSDAO sendSMSDAO = new SendSMSDAO();
            return sendSMSDAO.sendSMS(mt);
        }else{
            log.info("Invalid Username/Password");
            return new SMSResponse(mt.getMsgID(),"-1","Invalid Username/Password","");
        }
    }

    public ListSMSResponse sendSMSList(ListSMSRequest mtList) {
        mtList.setIp(FunctionUtils.getIPFromWebServiceContext(wsContext));
        SendSMSDAO sendSMSDAO = new SendSMSDAO();
        return sendSMSDAO.sendListSMS(mtList);
    }

    @Override
    public ReconcileResponse SMSReconcile(ReconcileRequest reconcileRequest) {
        reconcileRequest.setIp(FunctionUtils.getIPFromWebServiceContext(wsContext));
        SmsReconcileDAO smsReconcileDAO = new SmsReconcileDAO();
        return smsReconcileDAO.smsReconcile(reconcileRequest);
    }

    @Override
    public ListReconcileResponse SMSReconcileList(ListReconcileRequest listReconcileRequest) {
        listReconcileRequest.setIp(FunctionUtils.getIPFromWebServiceContext(wsContext));
        SmsReconcileDAO smsReconcileDAO = new SmsReconcileDAO();
        return smsReconcileDAO.smsReconcileList(listReconcileRequest);
    }

    @Override
    public UpdateMsgTypeResult updateMsgType(MsgType msgType) {
        msgType.setIp(FunctionUtils.getIPFromWebServiceContext(wsContext));
        UpdateMsgTypeDAO updateMsgTypeDAO = new UpdateMsgTypeDAO();
        return updateMsgTypeDAO.updateMsgType(msgType);
    }


    public UserDTO getUser(UserDTO userDTO) {
        return new UserDTO(userDTO.getUsername(),"123456a@");
    }
}
