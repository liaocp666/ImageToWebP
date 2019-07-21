package io.github.leachar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

/**
 * 字符串处理类
 */
public class StringUtil {

    public final static String WEBP = ".webp";

    /**
     * 不为空，将在空格也认为是空
     * @param str
     * @return
     */
    public static Boolean isNotBlank(String str) {
        str = str.trim();
        if (null != str && str.length() > 0) {
            return true;
        }
        return false;
    }

    /**
     * * 判断是否为一个webp的路径
     * @param path 路径
     * @return
     */
    public static boolean isWebP(String path) {
        int index = path.lastIndexOf(".");
        path = path.substring(index, path.length());
        return WEBP.equalsIgnoreCase(path);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString()
                .replaceAll("-", "");
    }

    public static String getTodayDate() {
        return new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
    }

}
