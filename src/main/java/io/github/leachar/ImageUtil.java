package io.github.leachar;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ImageUtil {

    /**
     * 是否递归获取所有图片
     *
     * @return
     */
    public static List<File> getImageFile(File file, String recursive, List<File> files) {
        switch (recursive) {
            case "yes":
                // 递归获取
                getAllFile(file, files);
            break;
            case "no":
                // 只获取当面目录下的图片文件
                File[] fileList = file.listFiles();
                for (File f : fileList) {
                    if (f.isFile() && isImage(f)) {
                        files.add(f);
                    }
                }
            break;
        }
        return files;
    }

    /**
     * 获取图片文件
     *
     * @param file
     * @param files
     * @return
     */
    private static List<File> getAllFile(File file, List<File> files) {
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            for (File f : fileList) {
                getAllFile(f, files);
            }
        } else {
            if (isImage(file)) files.add(file);
        }
        return files;
    }

    /**
     * 判断一个文件对象是否为图片
     *
     * @param file
     * @return
     */
    public static boolean isImage(File file) {
        Image image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
        return null != image ? true : false;
    }

}
