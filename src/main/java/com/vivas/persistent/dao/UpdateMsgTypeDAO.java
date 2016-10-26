package com.vivas.persistent.dao;

import com.vivas.dto.MsgType;
import com.vivas.dto.SMSResponse;
import com.vivas.dto.UpdateMsgTypeResult;
import com.vivas.persistent.DBUtils;
import com.vivas.utils.BundleUtils;
import com.vivas.utils.FunctionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by duyot on 10/14/2016.
 */
public class UpdateMsgTypeDAO {
    public static Logger log = LoggerFactory.getLogger(UpdateMsgTypeDAO.class);
    public static final String SIGNATURE_KEY = BundleUtils.getkey("SIGNATURE_KEY");

    public UpdateMsgTypeDAO() {
    }

    public UpdateMsgTypeResult updateMsgType(MsgType msgType) {
        log.info("Received updatemsgtype info: "+ msgType.toString());

        Connection connection = DBUtils.getConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            String updateMsgTypeSQL = "begin ?:=pkg_tcb_update_msgtype.fUpdateMsgType(?,?,?,?,?,?); end;";
            cstmt = connection.prepareCall(updateMsgTypeSQL);
            cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);

            cstmt.setString(2, msgType.getIp());
            cstmt.setString(3, msgType.getMsgType());
            cstmt.setString(4, msgType.getFromTime());
            cstmt.setString(5, msgType.getToTime());
            cstmt.setString(6, msgType.getSignature());
            cstmt.setString(7, msgType.getDelta()+"");

            cstmt.executeQuery();

            String updateMsgTypeResultStr = cstmt.getString(1);
            String encryptedSignature = initSignature(msgType);
            log.info("Result: "+ updateMsgTypeResultStr);
            log.info("----------------------------------------------");

            return FunctionUtils.initUpdateMsgtype(updateMsgTypeResultStr,encryptedSignature);

        } catch (Exception e) {
            log.info("Error: "+ e.toString());
            e.printStackTrace();
        }finally {
            DBUtils.closeConnection(rs,cstmt,connection);
        }
        return null;
    }

    private String initSignature(MsgType msgType){
        StringBuilder sbSignature = new StringBuilder();
        sbSignature.append(msgType.getMsgType()).append("|")
                   .append(msgType.getFromTime()).append("|")
                   .append(msgType.getToTime()).append("|")
                   .append(msgType.getDelta()).append("|")
                   .append(SIGNATURE_KEY);
        log.info("Signature: "+ sbSignature.toString());
        return FunctionUtils.MD5Encrypt(sbSignature.toString());
    }
}
