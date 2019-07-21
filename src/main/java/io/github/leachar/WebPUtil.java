package io.github.leachar;

import io.github.biezhi.webp.WebpIO;

import java.io.File;

/**
 * 与WebP有关的类
 */
public class WebPUtil {

    /**
     * 转换WebP
     * @param src
     * @param dest
     */
    public static void toWebP(String src, String dest) {

    }

    /**
     * 转换成WebP格式
     * @param src
     * @param dest
     */
    private static void webpIo(File src, File dest) {
        WebpIO.create().toWEBP(src, dest);
    }

}
