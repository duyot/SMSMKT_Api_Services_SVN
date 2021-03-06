package com.vivas.utils;

import com.google.common.base.Strings;
import com.vivas.dto.ReconcileResponse;
import com.vivas.dto.SMSResponse;
import com.vivas.dto.UpdateMsgTypeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by duyot on 9/21/2016.
 */
public class FunctionUtils {
    public static Logger log = LoggerFactory.getLogger(FunctionUtils.class);

    public static void main(String[] args) {
        System.out.println(FunctionUtils.MD5Encrypt("123456"));
    }

    public static String MD5Encrypt(String inputString)
    {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(inputString.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getIPFromWebServiceContext(WebServiceContext webServiceContext){
        MessageContext mc = webServiceContext.getMessageContext();
        HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
        return req.getRemoteAddr();
    }

    public static boolean isListNullOrEmpty(List<?> lst) {
        return lst == null || lst.isEmpty();
    }

    public static SMSResponse getResponseFromResult(String result,String encryptedSignature){
        if(Strings.isNullOrEmpty(result)){
            log.info("Invalid result from db");
            return new SMSResponse();
        }
        String[] resultArr = result.split("\\|");
        if(resultArr.length >=3){
            return new SMSResponse(resultArr[0],resultArr[1],resultArr[2],encryptedSignature);
        }else{
            return new SMSResponse("",resultArr[0],resultArr[1],encryptedSignature);
        }
    }

    public static ReconcileResponse getReconcileResponseFromResult(String result){
        if(Strings.isNullOrEmpty(result)){
            log.info("Invalid result from db");
            return new ReconcileResponse();
        }
        String[] resultArr = result.split("\\|");
        int msgLeng;
        int msgCount;
        try{
            msgLeng = Integer.parseInt(resultArr[1]);
        }catch(Exception e){
            log.error(e.toString());
            msgLeng = 0;
        }
        try{
            msgCount = Integer.parseInt(resultArr[2]);
        }catch(Exception e){
            log.error(e.toString());
            msgCount = 0;
        }
        return new ReconcileResponse(resultArr[0],msgLeng,msgCount,resultArr[3],resultArr[4]);
    }

    public static SMSResponse genErroResult(String messageId,String respCode,String respDesc,String signature){
        return new SMSResponse(messageId,respCode,respDesc,signature);
    }

    public static ReconcileResponse genReconcileErroResult(String messageId,String signature){
        return new ReconcileResponse(messageId,0,0,signature,"999");
    }

    public static UpdateMsgTypeResult initUpdateMsgtype(String result,String encryptedSignature){
        if(Strings.isNullOrEmpty(result)){
            log.info("Invalid result from db");
            return new UpdateMsgTypeResult();
        }
        String[] resultArr = result.split("\\|");
        UpdateMsgTypeResult updateMsgTypeResult;
        try {
            updateMsgTypeResult =  new UpdateMsgTypeResult(resultArr[0],resultArr[1],resultArr[2],Integer.parseInt(resultArr[3]),encryptedSignature,resultArr[5],resultArr[6]);
        } catch (Exception e) {
            log.info("Parse result form DB error:"+ e.toString());
            e.printStackTrace();
            updateMsgTypeResult =  new UpdateMsgTypeResult(resultArr[0],resultArr[1],resultArr[2],Integer.parseInt(resultArr[3]),encryptedSignature,"-1","parse result error");
        }
        return updateMsgTypeResult;
    }
}
