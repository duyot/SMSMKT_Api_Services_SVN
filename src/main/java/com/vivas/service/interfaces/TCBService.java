package com.vivas.service.interfaces;

import com.vivas.dto.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by duyot on 9/9/2016.
 */
@WebService(targetNamespace = "http://smsmkt.vivas.vn")
public interface TCBService {

    @WebMethod(operationName = "SendSMS")
    @WebResult(name = "SendSMSResult")
    public SMSResponse sendSMS(@WebParam(name = "MT") SMSRequest smsRequest);

    @WebMethod(operationName = "SendSMSList")
    @WebResult(name = "SendSMSListResult")
    public ListSMSResponse sendSMSList(@WebParam(name = "MT") ListSMSRequest lstSMListSMSRequest);


    @WebMethod(operationName = "SMSReconcile")
    @WebResult(name = "SMSReconcileResult")
    public ReconcileResponse SMSReconcile(@WebParam(name = "Msg")ReconcileRequest reconcileRequest);

    @WebMethod(operationName = "SMSReconcileList")
    @WebResult(name = "SMSReconcileListResult")
    public ListReconcileResponse SMSReconcileList(@WebParam(name = "Msg")ListReconcileRequest listReconcileRequest);



//    @WebMethod(operationName = "getUser")
//    @WebResult(name = "userDTO")
//    public UserDTO getUser(@WebParam(name = "userDTO") UserDTO userDTO);
}
