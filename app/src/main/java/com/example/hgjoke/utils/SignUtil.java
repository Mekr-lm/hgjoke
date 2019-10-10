package com.example.hgjoke.utils;

import android.text.TextUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/**
 * author:hm
 * Date:2019/9/28
 */

public class SignUtil {

    public static String getSign(Map<String, String> map, String sign) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> resultMap = sortMapByKey(map);
        sb.setLength(0);
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            if (!TextUtils.isEmpty(entry.getValue())) {
                sb.append(entry.getValue());
            }
        }
        String result = sb.toString();
        result += sign;
        result = MD5.MD5Encode(result);
        return result;
    }

    /**
     * 根据key排序
     *
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * 加密
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    static class MapKeyComparator implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {

            return str1.compareTo(str2);
        }
    }

}
