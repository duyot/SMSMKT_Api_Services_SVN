package com.vivas.persistent;

import com.vivas.utils.BundleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by duyot on 9/16/2016.
 */
public class DBUtils {
    public static Logger log = LoggerFactory.getLogger(DBUtils.class);
    public static final String jndiName = BundleUtils.getkey("JNDI_NAME");

    public static Connection getConnection(){
        Context initContext = null;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup(jndiName);
            return ds.getConnection();
        } catch (Exception e) {
            log.error("Get connection fail caused: "+ e.toString());
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(ResultSet rs, CallableStatement callableStatement,Connection connection){
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception ex) {
                log.error("Error: ", ex);
            }
        }
        //
        if(callableStatement != null){
            try {
                callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
