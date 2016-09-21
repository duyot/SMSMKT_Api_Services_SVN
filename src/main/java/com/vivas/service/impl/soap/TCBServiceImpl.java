package com.vivas.service.impl.soap;

import com.google.common.collect.Lists;
import com.vivas.dto.*;
import com.vivas.persistent.dao.SendSMSDAO;
import com.vivas.persistent.dao.SmsReconcileDAO;
import com.vivas.service.interfaces.TCBService;
import com.vivas.utils.FunctionUtils;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import java.util.List;

/**
 * Created by duyot on 9/9/2016.
 */
@WebService(endpointInterface = "com.vivas.service.interfaces.TCBService",serviceName = "TCBService")
public class TCBServiceImpl implements TCBService {
    @Resource
    public WebServiceContext wsContext;


    public SMSResponse sendSMS(SMSRequest mt) {
        mt.setIp(FunctionUtils.getIPFromWebServiceContext(wsContext));
        SendSMSDAO sendSMSDAO = new SendSMSDAO();
        return sendSMSDAO.sendSMS(mt);
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

    public UserDTO getUser(UserDTO userDTO) {
        return new UserDTO(userDTO.getUsername(),"123456a@");
    }
}
