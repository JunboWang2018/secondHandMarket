package com.mq.test.util;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 2017/8/9.
 * 字节相关转换
 * 统一高位在前
 */
public class ByteHexUtil {

    private static boolean isBigEndian()
    {
        int x = 0x12345678;
        int b0 = x & 0x0FF;
        return (0x12 == b0);
    }

    /**
     * byte[] 与 int 的转换
     * 强制转成主机字节序
     * @param b
     * @return
     */
    public static int byteArrayToInt(byte[] b, int offset) {
        if (isBigEndian()) {
            return b[offset + 0] & 0xFF | (b[offset + 1] & 0xFF) << 8 | (b[offset + 2] & 0xFF) << 16 | (b[offset + 3] & 0xFF) << 24;
        }
        else {
            return b[offset + 3] & 0xFF | (b[offset + 2] & 0xFF) << 8 | (b[offset + 1] & 0xFF) << 16 | (b[offset + 0] & 0xFF) << 24;
        }
    }

    /**
     * int 与 byte[] 的转换
     * 强制转成网络字节序
     * @param a
     * @return
     */
    public static byte[] intToByteArray(int a) {
        if (isBigEndian()) {
            return new byte[]{(byte) (a & 0xFF), (byte) ((a >> 8) & 0xFF), (byte) ((a >> 16) & 0xFF), (byte) ((a >> 24) & 0xFF)};
        }
        else {
            return new byte[]{(byte) ((a >> 24) & 0xFF), (byte) ((a >> 16) & 0xFF), (byte) ((a >> 8) & 0xFF), (byte) (a & 0xFF)};
        }

    }


    /**
     * byte[] 与 short 的转换
     *
     * @param b
     * @return
     */
    public static short byteArrayToShort(byte[] b, int offset) {
        int len = b.length;
        if (isBigEndian()) {
            short s0 = (short) (( b[offset + 0] & 0xFF) );//
            short s1 = 0;
            if (len >= offset + 2){
                s1 = (short) (( b[offset + 1] & 0xFF) << 8);
            }
            return (short) (s0 | s1);
        }
        else {
            short s0 = (short) ((b[offset + 0] & 0xFF) << 8);// 高位在前
            short s1 = 0;
            if (len >= offset + 2){
                s1 = (short) (( b[offset + 1] & 0xFF));
            }
            return (short) (s0 | s1);
        }
    }
    /**
     * short 与 byte[] 转换
     *
     * @param s
     * @return
     */
    public static byte[] shortToByteArray(short s) {
        if (isBigEndian()) {
            byte[] b = new byte[2];
            b[0] = (byte) (0xFF & s);
            b[1] = (byte) (0xFF & (s >> 8));
            return b;
        }
        else {
            byte[] b = new byte[2];
            b[0] = (byte) (0xFF & (s >> 8));   //高位在前
            b[1] = (byte) (0xFF & s);
            return b;
        }

    }

    /**
     * long 与 byte[] 的转换
     *
     * @param x
     * @return
     */
    public static byte[] longToByteArray(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(0, x);
        return buffer.array();
    }

    /**
     * byte[] 与 long 的转换
     *
     * @param bytes
     * @return
     */
    public static long byteArrayToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();//need flip
        return buffer.getLong();
    }

    /**
     * char 与 byte[] 的转换
     *
     * @param c
     * @return
     */
    public static byte[] charToByteArray(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }


    /**
     * byte[] 与 char 的转换
     *
     * @param b
     * @return
     */
    public static char byteArrayToChar(byte[] b, int offset) {
        char c0 = (char) ((b[offset + 0] & 0xFF) << 8);// 高位在前
        char c1 = (char) (b[offset + 1] & 0xFF);
        return (char) (c0 | c1);
    }

    /**
     * byte[] 与 string 的转换
     * @param b
     * @param offset
     * @param len
     * @return
     */
    public static String byteArrayToString(byte[] b, int offset,int len){
        byte[] bytes = new byte[len];
        System.arraycopy(b,offset,bytes,0,len);
        return new String(bytes).trim();
    }

    public static String Bytes2String(byte[] pSrc, int offset, int nSrcLen)
    {
        String[] szTable= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

        String  str = new String();

        for (int i = 0; i < offset+nSrcLen; i++)
        {
            if (i<offset) continue;

            int idx = (pSrc[i] >> 4) & 0x0f;
            str += szTable[idx];

            idx = pSrc[i] & 0x0f;
            str += szTable[idx];
        }

        return  str;
    }

    public static String Bytes2String(byte[] pSrc, int nSrcLen)
    {
        String[] szTable= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

        String  str = new String();

        for (int i = 0; i < nSrcLen; i++)
        {

            int idx = (pSrc[i] >> 4) & 0x0f;
            str += szTable[idx];

            idx = pSrc[i] & 0x0f;
            str += szTable[idx];
        }

        return  str;
    }


    /*
    static char *strupr(char *s)
    {
        int i;
        for (i = 0; s[i] != '\0'; i++) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                s[i] += 'A' - 'a';
            }
        }
        return s;
    }*/

    public static byte toB (byte X) {
        byte BB = 0;
        switch(X) {
            case '0':BB = 0x0;break;
            case '1':BB = 0x1;break;
            case '2':BB = 0x2;break;
            case '3':BB = 0x3;break;
            case '4':BB = 0x4;break;
            case '5':BB = 0x5;break;
            case '6':BB = 0x6;break;
            case '7':BB = 0x7;break;
            case '8':BB = 0x8;break;
            case '9':BB = 0x9;break;
            case 'A':BB = 0xA;break;
            case 'B':BB = 0xB;break;
            case 'C':BB = 0xC;break;
            case 'D':BB = 0xD;break;
            case 'E':BB = 0xE;break;
            case 'F':BB = 0xF;break;
            case 'a':BB = 0xA;break;
            case 'b':BB = 0xB;break;
            case 'c':BB = 0xC;break;
            case 'd':BB = 0xD;break;
            case 'e':BB = 0xE;break;
            case 'f':BB = 0xF;break;

        }
        return BB;
    }
    public static byte[] String2Bytes(String szSrc)
    {
        int iLen = szSrc.length();
        if (iLen <= 0)
        {
            return null;
        }

        iLen /= 2;
        szSrc = szSrc.toUpperCase();

        //byte[] szTable = {0,1,2,3,4,5,6,7,8,9,0xA,0xB,0xC,0xD,0xE,0xF,}
        byte[] arrays = szSrc.getBytes();
        byte[] bins = new byte[iLen];

        for (int i = 0; i < iLen; i++)
        {
            byte HB = arrays[i*2];
            byte LB = arrays[i*2+1];

            HB = toB(HB);
            LB = toB(LB);

            bins[i] = (byte)((((HB<<4)&0xF0) | (LB&0x0F))&0x0FF);

        }

        return bins;
    }


    /**
     * 多个指令转换成字节数据
     *
     * @param ecuCommands
     * @return
     */
    public static byte[] moreCmds(String[] ecuCommands) {
        int len = ecuCommands.length;
        byte[] cmdsByte = new byte[8 * len];
        for (int i = 0; i < len; i++) {
            String replace = ecuCommands[i].replaceAll("\\s+", "");
            byte[] cmdByte = new byte[8];
            int cmdLen = replace.length() / 2;
            cmdByte[0] = (byte) cmdLen;
            byte[] bytes = ByteHexUtil.String2Bytes(replace);
            System.arraycopy(bytes, 0, cmdByte, 1, bytes.length);
            System.arraycopy(cmdByte, 0, cmdsByte, 8 * i, 8);
        }

        return cmdsByte;
    }

    /**
     * K线指令使用
     * @param ecuCommands
     * @return
     */
    public static byte[] moreKLineCmds(String[] ecuCommands) {
        int len = ecuCommands.length, subLen = 0;
        byte[] cmdsByte = new byte[len * 16];
        for (int i = 0; i < len; i++) {
            String replace = ecuCommands[i].replaceAll("\\s+", "");
            byte[] bytes = ByteHexUtil.String2Bytes(replace);
            subLen = bytes.length;
            System.arraycopy(bytes, 0, cmdsByte, i * 16, subLen);
        }

        return cmdsByte;
    }

    /**
     * 通道消息解析
     * @param results
     * @return
     */
    public static String resultToString(byte[] results){
        int len = results.length;
        if (len == 0){
            return "";
        }
        List<String> items = new ArrayList<>();
        for (int i = 0; i < len; i += 8){
            byte[] single = new byte[8];
            System.arraycopy(results, i, single, 0, single.length);
            String strResult = Bytes2String(single, single.length);
            items.add(strResult);
        }

        return String.join("|", items);
    }


    public static String getEcuString(String src){
        String dest = "";
        int i = src.length() / (8 * 2);
        String[] result = new String[i];
        for (int m = 0; m < i; m++){
            result[m] = src.substring(m * 16, (m + 1) * 16);
        }

        dest = String.join("|", result);

        return dest;
    }

    /**
     * K线接收数据处理
     * @param src
     * @return
     *//*
    public static String KLineResultToString(String src){
        int len = src.length();
        if (len == 0){
            return "";
        }
        List<String> items = new ArrayList<>();
        int length = 0, subLen = 0;
        String lenHex = "", item = "";
        for (int i = 0; i < len;){
            lenHex = src.substring(i+1, i+2);
            length = Integer.parseInt(lenHex, 16);
            subLen = 2 + 4 + length * 2 + 2;
            item = src.substring(i, i + subLen);
            i = i + subLen;
            items.add(item);
        }

        List<String> list = StrTools.getDecoderFaultList(src, Constants.CMNCT_MODEL_K);
        String[] strings = new String[list.size()];
        list.toArray(strings);
        list.clear();
        return String.join("|", strings);
    }*/
}
