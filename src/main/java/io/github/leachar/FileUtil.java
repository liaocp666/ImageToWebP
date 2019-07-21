package io.github.leachar;

import com.sun.deploy.util.StringUtils;

import java.awt.*;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件和文件夹的类
 */
public class FileUtil {

    private final static String WEBP = File.separator + "WebP-";

    /**
     * 根据用户输入的源路径，生成目标路径
     * 如果不是文件夹，就在文件所在的目录创建一个文件夹
     *
     * @param file
     * @return
     */
    public static File destMkdirs(File file) {
        File newFile = null;
        if (file.isFile()) {
            newFile = new File(file.getParent() + WEBP + StringUtil.getTodayDate());
        } else if (file.isDirectory()) {
            newFile = new File(file.getAbsolutePath() + WEBP + StringUtil.getTodayDate());
        }
        newFile.mkdirs();
        return newFile;
    }

    /**
     * 处理用户输入的字符串
     * @param src 源路径
     * @param recursive 是否开启深度查找图片
     * @return
     */
    public static String processSrcAndDest(String src, String recursive) {
        List<File> srcFiles = getImageFile(new File(src), recursive);
        File destFile = destMkdirs(new File(src));
        return ImageUtil.imageToWebP(srcFiles, destFile);
    }

    /**
     * 获取一个文件夹下面所有的图片文件
     *
     * @param src       路径
     * @param recursive 是否递归所有图片 yes/no
     * @return
     */
    public static List<File> getImageFile(File src, String recursive) {
        List<File> files = new LinkedList<>();
        if (src.isFile() && ImageUtil.isImage(src)) {
            files.add(src);
            return files;
        }
        ImageUtil.getImageFile(src, recursive, files);
        return files;
    }

}