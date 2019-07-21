package io.github.leachar;

import io.github.biezhi.webp.WebpIO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 将图片格式转为WebP
 */
public class ToWebPUtil {

    /**
     * 自动在原目录下创建Webp目录，将文件输出到此目录
     *
     * @param src 源文件路径
     * @return
     */
    public static void toWebP(String src) {
        File dest = null;
        File file = new File(src);
        if (file.isDirectory()) {
            dest = new File(file.getAbsolutePath() + File.separator + "WebP");
        } else if (file.isFile()) {
            dest = new File(file.getParent() + File.separator + "WebP");
        }
        dest.mkdirs();
        System.out.println("创建文件夹" + dest.getAbsolutePath());
        start(file, dest);
    }

    /**
     * 图片转为WebP
     *
     * @param src  源文件路径
     * @param dest 目标文件路径
     * @return
     */
    public static void toWebP(String src, String dest) {
        if (null == dest || dest.length() == 0) {
            toWebP(src);
            return;
        }
        File file = new File(src);
        File desc = new File(dest);
        if (!desc.exists()) {
            desc.mkdirs();
        }
        start(file, desc);
    }

    /**
     * 开启转换
     *
     * @param file
     * @param dest
     */
    private static void start(File file, File dest) {
        if (file.isFile() && isPicture(file)) {
            fileToWebP(file, dest);
        } else if (file.isDirectory()) {
            directoryToWebP(file, dest);
        } else {
            System.out.println(">>>>> 路径即不是一个文件也不是一个文件夹");
        }
    }

    /**
     * 将目录下的图片文件转为WebP
     *
     * @param src
     * @param dest
     */
    private static void directoryToWebP(File src, File dest) {
        List<File> files = getDirectoryPicture(src);
        if (files.size() == 0) {
            System.out.println(">>>>> 未发现图片文件");
            return;
        }
        for (File file : files) {
            start(file, dest);
        }
    }

    /**
     * 将图片格式的文件转为WebP
     *
     * @param src  源文件路径
     * @param dest 目标文件路径
     * @return
     */
    private static void fileToWebP(File src, File dest) {
        dest = new File(dest.getAbsoluteFile() + File.separator + getUUID() + ".webp");
        WebpIO.create().toWEBP(src, dest);
        System.out.println(src + " >>>>> " + dest);
        System.out.println();
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").replace("-", "").replace("-", "");
    }

    /**
     * 获取目录下的所有图片
     *
     * @param src
     * @return
     */
    private static List<File> getDirectoryPicture(File src) {
        File[] files = getFiles(src);
        return isPictureToList(files);
    }

    /**
     * 判断File数组是否为集合
     *
     * @param files File
     * @return
     */
    private static List<File> isPictureToList(File files[]) {
        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            isPictureAddList(fileList, file);
        }
        return fileList;
    }

    /**
     * 判断文件是否为图片；true -- 加入到File集合，false -- 打印不是图片
     *
     * @param files 需要加入的List集合
     * @param file  需要判断的图片
     */
    private static void isPictureAddList(List<File> files, File file) {
        if (isPicture(file)) {
            files.add(file);
        }
    }

    /**
     * 判断单个文件是否为图片
     *
     * @param file
     * @return
     */
    private static boolean isPicture(File file) {
        try {
            Image image = ImageIO.read(file);
            return null != image ? true : false;
        } catch (IOException e) {
            if (file.isFile()) {
                System.out.println("不是图片文件>>>>> " + file);
            }
            return false;
        }
    }

    /**
     * 获取File文件夹下的所有文件
     *
     * @param src
     * @return
     */
    private static File[] getFiles(File src) {
        return src.listFiles();
    }

}
