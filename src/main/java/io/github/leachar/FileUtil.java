package io.github.leachar;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件和文件夹的类
 */
public class FileUtil {

    private final static String WEBP = File.separatorChar + "WebP";

    /**
     * 用户输入的路径，应该经过这里创建File对象
     * 如果不是文件夹，就在文件所在的目录创建一个文件夹
     *
     * @param file
     * @return
     */
    public static File isFileOrMkdirs(File file) {
        File newFile = null;
        if (file.isFile()) {
            newFile = new File(file.getParent() + WEBP);
        } else if (file.isDirectory()) {
            newFile = new File(file.getAbsolutePath() + WEBP);
        }
        newFile.mkdirs();
        return file;
    }

    public static void main(String[] args) {
        String src = "D:\\Picture\\HeadPortraits";
        File srcFile = new File(src);
        File destFile = isFileOrMkdirs(srcFile);
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