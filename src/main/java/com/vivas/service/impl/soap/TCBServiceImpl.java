package com.vivas.service.impl.soap;

import com.google.common.collect.Lists;
import com.vivas.dto.*;
import com.vivas.service.interfaces.TCBService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by duyot on 9/9/2016.
 */
@WebService(endpointInterface = "com.vivas.service.interfaces.TCBService",serviceName = "TCBService")
public class TCBServiceImpl implements TCBService {
    @Resource
    public WebServiceContext wsContext;

    public SMSResponse sendSMS(SMSRequest mt) {
        return new SMSResponse("23232","SUCESS","SUCCESS","23A343");
    }

    public ListSMSResponse sendSMSList(ListSMSRequest mtList) {
        List<SMSResponse> lstSendSMSResults = Lists.newArrayList();
        lstSendSMSResults.add(new SMSResponse("23232","SUCESS","SUCCESS","23A343"));
        lstSendSMSResults.add(new SMSResponse("5456","SUCESS","SUCCESS","23A3434564"));
        return new ListSMSResponse(lstSendSMSResults);
    }

    @Override
    public ReconcileResponse SMSReconcile(ReconcileRequest reconcileRequest) {
        return new ReconcileResponse("msgId","3","5","dfwe@323","SUCCESS");
    }

    @Override
    public ListReconcileResponse SMSReconcileList(ListReconcileRequest listReconcileRequest) {
        List<ReconcileResponse> lstResponse = Lists.newArrayList();
        ReconcileResponse rr1 = new ReconcileResponse("msgId","3","5","dfwe@323","SUCCESS");
        ReconcileResponse rr2 = new ReconcileResponse("msgId","3","5","dfwe@323","SUCCESS");
        lstResponse.add(rr1);
        lstResponse.add(rr2);
        return new ListReconcileResponse(lstResponse);
    }

    public UserDTO getUser(UserDTO userDTO) {
        return new UserDTO(userDTO.getUsername(),"123456a@");
    }
}
