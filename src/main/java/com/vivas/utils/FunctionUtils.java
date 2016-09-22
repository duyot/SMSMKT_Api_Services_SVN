package com.vivas.utils;

import com.google.common.base.Strings;
import com.vivas.dto.ReconcileResponse;
import com.vivas.dto.SMSResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;

/**
 * Created by duyot on 9/21/2016.
 */
public class FunctionUtils {
    public static Logger log = LoggerFactory.getLogger(FunctionUtils.class);

    public static void main(String[] args) {
        String s = "24324234|0|Success|123456a@";
        System.out.println(s.split("\\|")[0]);
    }

    public static String getIPFromWebServiceContext(WebServiceContext webServiceContext){
        MessageContext mc = webServiceContext.getMessageContext();
        HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
        return req.getRemoteAddr();
    }

    public static boolean isListNullOrEmpty(List<?> lst) {
        return lst == null || lst.isEmpty();
    }

    public static SMSResponse getResponseFromResult(String result){
        if(Strings.isNullOrEmpty(result)){
            log.info("Invalid result from db result");
            return new SMSResponse();
        }
        String[] resultArr = result.split("\\|");
        return new SMSResponse(resultArr[0],resultArr[1],resultArr[2],resultArr[3]);
    }

    public static ReconcileResponse getReconcileResponseFromResult(String result){
        if(Strings.isNullOrEmpty(result)){
            log.info("Invalid result from db result");
            return new ReconcileResponse();
        }
        String[] resultArr = result.split("\\|");
        return new ReconcileResponse(resultArr[0],resultArr[1],resultArr[2],resultArr[3],resultArr[4]);
    }

    public static SMSResponse genErroResult(String messageId,String respCode,String respDesc,String signature){
        return new SMSResponse(messageId,respCode,respDesc,signature);
    }

    public static ReconcileResponse genReconcileErroResult(String messageId,String signature){
        return new ReconcileResponse(messageId,"0","0",signature,"999");
    }
}
