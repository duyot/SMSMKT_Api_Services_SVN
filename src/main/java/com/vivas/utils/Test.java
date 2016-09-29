package com.vivas.utils;

import com.vivas.dto.SMSRequest;

/**
 * Created by duyot on 9/28/2016.
 */
public class Test {
    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static void testWithString(SMSRequest mt){
        long startTime = System.currentTimeMillis();
        //
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used Memory before" + usedMemoryBefore);
        //
        for(int i = 0;i<10000;i++){
            String signature = mt.getMsgID()    + "|" + mt.getSender()  + "|" + mt.getMobinumber() + "|" +
                    mt.getMsgText()  + "|" + mt.getMsgType() + "|" + mt.getMsgTime()    + "|" +
                    mt.getMoID()     + "|" + mt.getPriority()+ "|" + mt.getLocalTime()  + "|" +
                    mt.getExtension()+ "|";
            FunctionUtils.MD5Encrypt(signature);
        }
        System.out.println("String time: "+ (System.currentTimeMillis() - startTime));
        //
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory increased:" + (usedMemoryAfter-usedMemoryBefore));
        //

    }

    public static void testWithBuffer(SMSRequest mt){
        long startTime = System.currentTimeMillis();
        //
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used Memory before" + usedMemoryBefore);
        //
        for(int i = 0;i<10000;i++){
            StringBuilder sbSignature = new StringBuilder();
            sbSignature.append(mt.getMsgID()).    append("|").append(mt.getSender()).  append("|").append(mt.getMobinumber()).append("|");
            sbSignature.append(mt.getMsgText()).  append("|").append(mt.getMsgType()). append("|").append(mt.getMobinumber()).append("|");
            sbSignature.append(mt.getMoID()).     append("|").append(mt.getPriority()).append("|").append(mt.getMsgTime()).   append("|");
            sbSignature.append(mt.getExtension()).append("|");
            FunctionUtils.MD5Encrypt(sbSignature.toString());
        }
        System.out.println("Buffer time: "+ (System.currentTimeMillis() - startTime));
        //
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory increased:" + (usedMemoryAfter-usedMemoryBefore));
        //

    }

    public static void main(String[] args) {
        SMSRequest testSMSRequest = new SMSRequest();
        testSMSRequest.setMsgID("addfdf");
        testSMSRequest.setSender("addfdf");
        testSMSRequest.setMobinumber("addfdf");
        testSMSRequest.setMsgText("addfdf");
        testSMSRequest.setMsgType("addfdf");
        testSMSRequest.setMobinumber("addfdf");
        testSMSRequest.setMoID("addfdf");
        testSMSRequest.setPriority("addfdf");
        testSMSRequest.setMsgTime("addfdf");
        testSMSRequest.setExtension("addfdf");
        Test.testWithString(testSMSRequest);
//        Test.testWithBuffer(testSMSRequest);
    }
}
